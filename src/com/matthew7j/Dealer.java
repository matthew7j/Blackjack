package com.matthew7j;

public class Dealer extends Person {

    public boolean checkForBlackJack(){
        Value v1 = hand.get(0).value;
        Value v2 = hand.get(1).value;

        if ((v1.compareTo(Value.Ace) == 0 || v2.compareTo(Value.Ace) == 0) && (v1.compareTo(Value.Ten) == 0 || v1.compareTo(Value.Jack) == 0 || v1.compareTo(Value.Queen) == 0 || v1.compareTo(Value.King) == 0 || v2.compareTo(Value.Ten) == 0 || v2.compareTo(Value.Jack) == 0 || v2.compareTo(Value.Queen) == 0 || v2.compareTo(Value.King) == 0))
        {
            System.out.println("Dealer got BlackJack with cards: " + hand.get(0).toString() + " and " + hand.get(1).toString() + "! Everyone else loses =(");
            return true;
        }
        return false;
    }
    public void handOption(){

    }
}
