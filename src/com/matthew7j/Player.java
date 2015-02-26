package com.matthew7j;

import java.util.ArrayList;

public class Player extends Person {
    private double money;
    private int totalHands;
    private int handsWon, handsPushed, handsLost, handsDoubledWon, handDoubledLost, numBlackJacks;

    public Player(double money, String name) {
        this.money = money;
        Hand hand = new Hand();
        hands.add(hand);
        this.name = name;
    }

    public boolean checkForBlackJack(Hand h) {
        Value v1 = h.cards.get(0).value;
        Value v2 = h.cards.get(1).value;

        if ((v1.compareTo(Value.Ace) == 0 || v2.compareTo(Value.Ace) == 0) && (v1.compareTo(Value.Ten) == 0 || v1.compareTo(Value.Jack) == 0 || v1.compareTo(Value.Queen) == 0 || v1.compareTo(Value.King) == 0 || v2.compareTo(Value.Ten) == 0 || v2.compareTo(Value.Jack) == 0 || v2.compareTo(Value.Queen) == 0 || v2.compareTo(Value.King) == 0)) {
            System.out.println("\nPlayer got BlackJack with cards: " + h.cards.get(0).value.toString() + " and " + h.cards.get(1).value.toString() + "!");
            numBlackJacks++;
            return true;
        }
        return false;
    }

    public double getChips()
    {
        return money;
    }
    public void addChips(double amount, boolean doubled) {
        if (doubled)
            handsDoubledWon++;
        money += amount;
        addHand(1);
    }
    public void removeChips(double amount, boolean doubled){
        if (doubled)
            handDoubledLost++;
        money -= amount;
        addHand(2);
    }
    public void addHand(int val)
    {
        if (val == 1)
            handsWon++;
        else if (val == 2)
            handsLost++;
        else
            handsPushed++;

        totalHands++;
    }
    public double getPercentageHandsWon(){
        if (totalHands == 0)
            return 0;
        return ((double)handsWon / (double)totalHands) * 100;
    }
    public double getPercentageHandsLost(){
        if (totalHands == 0)
            return 0;
        return ((double)handsLost / (double)totalHands) * 100;
    }
    public double getPercentageHandsPushed(){
        if (totalHands == 0)
            return 0;
        return (handsPushed / (double)totalHands) * 100;
    }
    public int getHandsDoubledWon()
    {
        return handsDoubledWon;
    }
    public int getNumberHandsWon()
    {
        return handsWon;
    }public int getNumberHandsLost()
    {
        return handsLost;
    }public int getNumberHandsPushed()
    {
        return handsPushed;
    }
    public int getHandsDoubledLost()
    {
        return handDoubledLost;
    }
    public int getNumBlackJacks()
    {
        return numBlackJacks;
    }

}
