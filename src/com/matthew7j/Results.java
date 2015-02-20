package com.matthew7j;

import java.util.ArrayList;

public class Results {

    ArrayList<Person> players;
    Dealer dealer;

    public Results(ArrayList<Person> players){
        this.players = players;
        findDealer();
        resultsEngine();
    }
    private void resultsEngine(){
        for (Person p : players){
            if (p instanceof Player)
            {
                checkIfWon(p);
            }
        }
    }
    private void checkIfWon(Person p)
    {
        Hand dealerHand = dealer.hands.get(0);
        for (Hand h : p.hands){
            if ((h.getTotal() > dealerHand.getTotal() && !h.busted) || dealerHand.getTotal() > 21){
                System.out.println(p.name + " won " + h.bet + " with hand: \n" + h.cards.toString());
            }
            else if (h.getTotal() == dealerHand.getTotal() && !h.busted)
            {
                System.out.println(p.name + " pushed with hand: \n" + h.cards.toString());
            }
            else
            {
                System.out.println(p.name + " lost " + h.bet + " with hand: \n" + h.cards.toString());
            }
        }
    }
    private void findDealer(){
        for (Person p : players){
            if (p instanceof Dealer) {
                dealer = (Dealer) p;
            }
        }
    }

}
