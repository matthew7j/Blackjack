package com.matthew7j;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> shoe = new ArrayList<Card>();

    public Deck(ArrayList<Card> shoe) {
        this.shoe = shoe;
        createDeck();
    }

    private void createDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                Card c = new Card(value, suit);
                shoe.add(c);
            }
        }
    }

    public void shuffle(Deck d) {

    }
}
