package com.matthew7j;

import java.util.ArrayList;

public class Person {
    ArrayList<Card> hand = new ArrayList<Card>();

    public Person() {
    }

    public void addHand(Card c) {
        if (hand.size() >= 2)
            System.out.println("Player cannot have more than 2 cards on initial deal");
        else
            hand.add(c);
    }
}
