package com.matthew7j;

import java.util.ArrayList;

public class PlayerTurnEngine {
    ArrayList<Person> players;
    Dealer dealer;

    public PlayerTurnEngine(ArrayList<Person> players)
    {
        this.players = players;
        findDealer();
        turnEngine();
    }

    private void findDealer(){
        for (Person p : players){
            if (p instanceof Dealer) {
                dealer = (Dealer) p;
                players.remove(p);
            }
        }
    }

    private void turnEngine(){
        for (Person p : players){
            for (Hand h : players.get(players.indexOf(p)).hands){
                handleHand(h);
            }
        }

    }

    private void handleHand(Hand h){

        if (h.cards.size() == 2){
            Card card1 = h.cards.get(0);
            Card card2 = h.cards.get(1);

            int dealerCard = dealer.hands.get(0).cards.get(0).getWeight();

            if (checkDoubleConditions(dealerCard, card1, card2));

        }
        else
        {
            int playerTotal = h.getTotal();
            int dealerCard = dealer.hands.get(0).cards.get(0).getWeight();



        }
    }

    private boolean checkDoubleConditions(int dealerCard, Card c1, Card c2) {

        int playerTotal = c1.getWeight() + c2.getWeight();
        boolean isSoft = false;

        if (c1.value == Value.Ace || c2.value == Value.Ace)
            isSoft = true;

        if (playerTotal == 9 && (3 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (playerTotal == 10 && (2 <= dealerCard && dealerCard <= 9)){
            return true;
        }
        if (playerTotal == 11 && (2 <= dealerCard && dealerCard <= 10)){
            return true;
        }
        if (playerTotal == 18 && isSoft && (3 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (playerTotal == 17 && isSoft && (3 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (playerTotal == 16 && isSoft && (4 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (playerTotal == 15 && isSoft && (4 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (playerTotal == 14 && isSoft && (5 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (playerTotal == 13 && isSoft && (5 <= dealerCard && dealerCard <= 6)){
            return true;
        }
        if (c1.getWeight() == 5 && c2.getWeight() == 5 && (2 <= dealerCard && dealerCard <= 9)){
            return true;
        }
        return false;

    }



}
