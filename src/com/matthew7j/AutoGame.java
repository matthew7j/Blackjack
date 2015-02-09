package com.matthew7j;

import java.util.ArrayList;

public class AutoGame {
    int numDecks, numPlayers;
    double amount;

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
        for (int i = 0; i < numPlayers; i++)
            players.add(new Player(amount));
        players.add(new Dealer());
    }

    private void dealShoe(Shoe shoe) {
        while (!shoe.yellow) {
            dealHand(shoe);
            playerTurn();
            getCurrentHand();
            clearTable();
        }
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

                players.get(j).addCard(c);
            }
        }
    }
    private void playerTurn(){
        checkBlackJack();
        playerOption();
    }
    private void playerOption(){
        for (Person p : players){

        }
    }
    private void checkBlackJack(){
        for (Person p : players)
        {
            if (p.checkForBlackJack()){
                if (p instanceof Player){
                    p.hand.clear();
                }
                else{
                    clearTable();
                }
            }
        }
    }
    private void clearTable()
    {
        for (Person p : players)
        {
            p.removeHand();
        }
    }

    private void getCurrentHand() {
        for (int i = 0; i < players.size(); i++)
            System.out.println(players.get(i).hand.toString());
    }
}
