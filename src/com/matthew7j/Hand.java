package com.matthew7j;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    boolean splitAces = false;
    public Hand()
    {

    }
    public void addCard(Card c)
    {
        cards.add(c);
    }
    public int getTotal()
    {
        int handTotalWeight = 0;
        for (Card c : cards){
            handTotalWeight += c.getWeight();
        }
        return handTotalWeight;
    }
    public ArrayList<Card> getCards()
    {
        return cards;
    }
    public String toString()
    {
        return cards.toString();
    }
}
