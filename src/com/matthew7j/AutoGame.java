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

        return shoe;
    }

    private void initPlayers() {
        for (int i = 0; i < numPlayers; i++)
            players.add(new Player(amount));
        players.add(new Dealer());
    }

    private void dealShoe(Shoe shoe) {
        dealHand(shoe);
        getCurrentHand();
    }

    private void dealHand(Shoe shoe) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < players.size(); j++) {
                players.get(j).addHand(shoe.cards.remove(0));
            }
        }
    }

    private void getCurrentHand() {
        for (int i = 0; i < players.size(); i++)
            System.out.println(players.get(i).hand.toString());
    }
}
