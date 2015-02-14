package com.matthew7j;

import java.util.ArrayList;

public class Dealer extends Person {

    public Dealer()
    {
        Hand hand = new Hand();
        hands.add(hand);
        this.name = "Deala";
    }

    public boolean checkForBlackJack(Hand h){
        Value v1 = h.cards.get(0).value;
        Value v2 = h.cards.get(1).value;

        if ((v1.compareTo(Value.Ace) == 0 || v2.compareTo(Value.Ace) == 0) && (v1.compareTo(Value.Ten) == 0 || v1.compareTo(Value.Jack) == 0 || v1.compareTo(Value.Queen) == 0 || v1.compareTo(Value.King) == 0 || v2.compareTo(Value.Ten) == 0 || v2.compareTo(Value.Jack) == 0 || v2.compareTo(Value.Queen) == 0 || v2.compareTo(Value.King) == 0))
        {
            System.out.println("Dealer got BlackJack with cards: " + h.cards.get(0).toString() + " and " + h.cards.get(1).toString() + "! Everyone else loses =(");
            return true;
        }
        return false;
    }
}
