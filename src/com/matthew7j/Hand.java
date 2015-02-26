package com.matthew7j;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    boolean splitAces = false;
    double bet;
    boolean busted = false;
    boolean doubled = false;

    public Hand()
    {

    }
    public void addCard(Card c)
    {
        cards.add(c);
    }
    public int getTotal()
    {
        boolean ace = false;
        int total = 0;

        for (Card c : cards){
            if (c.getWeight() == 11) {
                total += 1;
                ace = true;
            }
            else
                total += c.getWeight();
        }

        if (total <= 11 && ace)
            total += 10;
        return total;
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
