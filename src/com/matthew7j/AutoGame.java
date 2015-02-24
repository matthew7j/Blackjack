package com.matthew7j;

import javax.swing.*;
import java.util.ArrayList;

public class AutoGame {
    private int numDecks, numPlayers, totalHands;
    private double amount, handAmount, tableMinimum, tableMaximum;

    private ArrayList<Person> players = new ArrayList<Person>();
    private Statistics stats;

    public AutoGame(int numDecks, int numPlayers, double amount, double handAmount, double tableMinimum, double tableMaximum) {
        this.numDecks = numDecks;
        this.numPlayers = numPlayers;
        this.amount = amount;
        this.handAmount = handAmount;
        this.tableMinimum = tableMinimum;
        this.tableMaximum = tableMaximum;

        initPlayers();

        for (int i = 0; i < 100; i++) {
            dealShoe(initGame());
            stats.addData(players, totalHands);
            stats.composeGraph();
            System.out.println("\n\n\n\n\n\nNEW SHOE\n\n\n\n\n\n");
        }
    }

    private Shoe initGame() {
        return initializeShoe();
    }

    private Shoe initializeShoe() {
        Shoe shoe = new Shoe(numDecks);
        shoe.shuffle();
        shoe.yellow = false;

        return shoe;
    }

    private void initPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            String name = "Player " + i;
            players.add(new Player(amount, name));
        }
        players.add(new Dealer());
    }

    private void dealShoe(Shoe shoe) {
        while (!shoe.yellow) {
            dealHand(shoe);
            if (!checkBlackJack()){
                playerTurn(shoe);
                if (checkTable()) {
                    dealerTurn(shoe);
                }
                checkResults();
            }
            clearTable();
        }
    }

    private boolean checkTable(){
        for (Person p : players){
            if (p instanceof Player){
                for (Hand h : p.hands){
                    if (!h.busted){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void checkResults(){
        new Results(players);
    }

    private void checkTableChips(){

        ArrayList<Player> playersToRemove = new ArrayList<Player>();
        for (Person p : players){
            if (p instanceof Player){
                Player player = (Player)p;
                if (player.getChips() <= 0){
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int answer = JOptionPane.showConfirmDialog(null, p.name + ", you have run out of chips.\nDo you want to buy more?", "Warning", dialogButton);
                    if (answer == JOptionPane.YES_OPTION){
                        String money = JOptionPane.showInputDialog("How much do you want to buy in for? ");
                        double amount = Double.parseDouble(money);

                        ((Player) p).addChips(amount);
                    }
                    else{
                        playersToRemove.add((Player)p);
                    }
                }
            }
        }

        for (int i = 0; i < playersToRemove.size(); i++)
        {
            players.remove(playersToRemove.get(i));
        }
    }

    private void dealHand(Shoe shoe) {
        checkTableChips();
        if (totalHands != 0){
            stats.addData(players, totalHands);
        }
        else
        {
            stats = new Statistics("BlackJack Statistics" , players, totalHands);
        }
        totalHands++;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < players.size(); j++) {
                Card c = shoe.cards.remove(0);

                if (c.suit == null) {
                    c = shoe.cards.remove(0);
                    shoe.yellow = true;
                    System.out.println("Last hand of the shoe!");
                }

                players.get(j).addCard(c, players.get(j).hands.get(0));

                if (players.get(j) instanceof  Player){
                    Player player = (Player) players.get(j);
                    new BetHandler(player, handAmount, tableMinimum, tableMaximum);
                }
            }
        }
    }

    private void playerTurn(Shoe shoe){
        new PlayerTurnEngine(players, shoe);
    }
    private void dealerTurn(Shoe shoe){
        new DealerTurnEngine(players, shoe);
    }

    private boolean checkBlackJack(){
        for (Person p : players)
        {
            if (p.checkForBlackJack(p.hands.get(0))){
                if (p instanceof Player){
                    Hand h =  p.hands.get(0);
                    ((Player) p).addChips(h.bet * 1.5);
                    System.out.println(p.name + " won " + h.bet * 1.5 + " with hand: \n" + h.cards.toString());
                    p.hands.clear();

                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
    private void clearTable()
    {
        for (Person p : players)
        {
            p.hands.clear();
            Hand hand = new Hand();
            p.hands.add(hand);
        }
    }

    private void getCurrentHand() {
        for (int i = 0; i < players.size(); i++)
            System.out.println("Player " + players.get(i) + " cards:\n" +  players.get(i).hands.toString());
    }
}
