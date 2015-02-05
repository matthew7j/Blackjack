package com.matthew7j;

import java.util.ArrayList;

public class AutoGame {
    int numDecks, numPlayers;
    double amount;

    ArrayList<Player> players = new ArrayList<Player>();

    public AutoGame(int numDecks, int numPlayers, double amount) {
        this.numDecks = numDecks;
        this.numPlayers = numPlayers;
        this.amount = amount;

        initGame(numDecks, numDecks);
    }

    private void initGame(int numPlayers, int numDecks) {
        for (int i = 0; i < numPlayers; i++)
            players.add(new Player(amount));

        Shoe shoe = new Shoe(numDecks);
        shoe.shuffle();
    }
}
