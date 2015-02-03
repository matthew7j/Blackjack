package com.matthew7j;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards;
    private int size;

    public Deck(int size) {
        this.size = size;
    }

    private void createDeck() {
        int num = 0;
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                Card c = new Card(value, suit);
                cards.add(c);
            }
        }
    }

    public void shuffle(Deck d) {

    }
}
