package com.matthew7j;

import java.util.ArrayList;

public class Person {
    ArrayList<Card> hand = new ArrayList<Card>();

    public Person() {
    }

    public void addCard(Card c) {
        if (hand.size() >= 2)
            System.out.println("Player cannot have more than 2 cards on initial deal");
        else
            hand.add(c);
    }
    public void addHand(Card c){

    }
    public void removeHand(){
        hand.clear();
    }
    public void checkForBlackJack(){

    }
}
