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

            if (checkDoubleConditions(dealerCard, card1, card2)){

            }
            else if (checkStandConditions(dealerCard, card1, card2)){

            }
            else if (checkSplitConditions(dealerCard, card1, card2)){

            }
            else{
                //hit
            }

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
        boolean isPair = false;

        if (c1.value == Value.Ace || c2.value == Value.Ace)
            isSoft = true;
        if (c1.value == c2.value)
            isPair = true;

        if (!isPair)
        {
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
        }
        if (isPair && playerTotal == 10) {
            return true;
        }
        return false;
    }

    private boolean checkStandConditions(int dealerCard, Card c1, Card c2){
        int playerTotal = c1.getWeight() + c2.getWeight();
        boolean isSoft = false;
        boolean isPair = false;

        if (c1.value == Value.Ace || c2.value == Value.Ace)
            isSoft = true;
        if (c1.value == c2.value)
            isPair = true;

        if (!isPair) {
            if (playerTotal >= 17 && !isSoft) {
                return true;
            }
            if (playerTotal >= 13 && playerTotal <= 16 & dealerCard >= 2 && dealerCard <= 6) {
                return true;
            }
            if (isSoft && playerTotal >= 19) {
                return true;
            }
            if (isSoft && playerTotal == 18 && dealerCard == 2 || dealerCard == 7 || dealerCard == 8)
                return true;
        }
        if (isPair && playerTotal == 20) {
            return true;
        }
        return false;
    }

    private boolean checkSplitConditions(int dealerCard, Card c1, Card c2){
        int playerTotal = c1.getWeight() + c2.getWeight();
        boolean isPair = false;

        if (c1.value == c2.value)
            isPair = true;

        if (isPair){
            if (playerTotal == 22){
                return true;
            }
            if (playerTotal == 18 && (dealerCard != 7 || dealerCard != 10 || dealerCard != 11)){
                return true;
            }
            if (playerTotal == 16){
                return true;
            }
            if (playerTotal == 14 && dealerCard <= 7){
                return true;
            }
            if (playerTotal == 12 && dealerCard <= 6){
                return true;
            }
            if (playerTotal == 8 && (dealerCard <= 6 && dealerCard >= 5)){
                return true;
            }
            if (playerTotal == 6 && dealerCard <= 7){
                return true;
            }
            if (playerTotal == 4 && dealerCard <= 7){
                return true;
            }
        }
        return false;
    }



}
