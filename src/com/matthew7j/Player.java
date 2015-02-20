package com.matthew7j;

import java.util.ArrayList;

public class Player extends Person {
    private double money;

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
            System.out.println("Player got BlackJack with cards: " + h.cards.get(0).value.toString() + " and " + h.cards.get(1).value.toString() + "!");
            return true;
        }
        return false;
    }

    public double getChips()
    {
        return money;
    }
    public void addChips(double amount)
    {
        money += amount;
    }
    public void removeChips(double amount){
        money -= amount;
    }
}
