package com.matthew7j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    public void shuffle() {
        Collections.shuffle(cards);
        insertYellowCard();
    }

    private void insertYellowCard() {
        Random rand = new Random();

        int yellowCardLocation = (52 * numDecks) - (numDecks * (rand.nextInt((15 - 10) + 1) + 10));
        Card yellowCard = new Card();
        cards.add(yellowCardLocation, yellowCard);
    }
}
