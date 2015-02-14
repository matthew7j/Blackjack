package com.matthew7j;

import java.util.ArrayList;

abstract class Person {
    public ArrayList<Hand> hands = new ArrayList<Hand>();

    public Person() {
    }

    public void addCard(Card c, Hand h) {
        hands.get(hands.indexOf(h)).addCard(c);
    }
    public void removeHand(Hand h){
        hands.remove(h);
    }
    abstract boolean checkForBlackJack(Hand h);

    abstract void act(ArrayList<Card> cards);
}
