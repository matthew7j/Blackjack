package com.matthew7j;

import java.util.ArrayList;

public class Shoe {
    int numDecks;
    ArrayList<Card> cards = new ArrayList<Card>();

    public Shoe(int numDecks) {
        this.numDecks = numDecks;
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < numDecks; i++) {
            new Deck(cards);
        }
    }

    public String toString() {
        String results = "";
        for (Card c : cards) {
            results += c.toString() + "\n";
        }
        return results;
    }
}
