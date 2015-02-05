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

        Shoe shoe = initGame(numDecks, numDecks);
    }

    private Shoe initGame(int numPlayers, int numDecks) {
        for (int i = 0; i < numPlayers; i++)
            players.add(new Player(amount));
        players.add(new Dealer());

        Shoe shoe = new Shoe(numDecks);
        shoe.shuffle();

        return shoe;
    }
}
