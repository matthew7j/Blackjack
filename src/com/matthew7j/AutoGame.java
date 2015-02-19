package com.matthew7j;

import java.util.ArrayList;

public class AutoGame {
    private int numDecks, numPlayers;
    private double amount;

    ArrayList<Person> players = new ArrayList<Person>();

    public AutoGame(int numDecks, int numPlayers, double amount) {
        this.numDecks = numDecks;
        this.numPlayers = numPlayers;
        this.amount = amount;

        dealShoe(initGame());
    }

    private Shoe initGame() {
        initPlayers();
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
                dealerTurn(shoe);
                checkResults();
            }
            clearTable();
        }
    }

    private void checkResults(){
        new Results(players);
    }

    private void dealHand(Shoe shoe) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < players.size(); j++) {
                Card c = shoe.cards.remove(0);

                if (c.suit == null) {
                    c = shoe.cards.remove(0);
                    shoe.yellow = true;
                    System.out.println("Last hand of the shoe!");
                }

                players.get(j).addCard(c, players.get(j).hands.get(0));
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
