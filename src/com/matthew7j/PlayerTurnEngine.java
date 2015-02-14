package com.matthew7j;

import java.util.ArrayList;

public class PlayerTurnEngine {
    private ArrayList<Person> players;
    private Dealer dealer;
    private Shoe shoe;

    public PlayerTurnEngine(ArrayList<Person> players, Shoe shoe)
    {
        this.players = players;
        this.shoe = shoe;
        findDealer();
        turnEngine();
    }

    private void findDealer(){
        for (Person p : players){
            if (p instanceof Dealer) {
                dealer = (Dealer) p;
            }
        }
    }

    private void turnEngine(){
        System.out.println("Dealer card: " + dealer.hands.get(0).cards.get(0).value);
        for (Person p : players){
            if (p instanceof  Player) {
                for (Hand h : players.get(players.indexOf(p)).hands) {
                    if (!h.splitAces)
                        handleHand(h, p);
                }
            }
        }

    }

    private void handleHand(Hand h, Person p){
        System.out.println(p.name + " current hand: \n" + h.toString());
        boolean isPair = false;
        boolean isSoft = false;
        int playerTotal = h.getTotal();
        System.out.println(p.name + " current total: \n" + playerTotal);

        for (Card c : h.cards){
            if (c.getWeight() == 11)
                isSoft = true;
        }

        if (h.cards.size() == 2){
            Card card1 = h.cards.get(0);
            Card card2 = h.cards.get(1);

            if (card1.getWeight() == card2.getWeight())
                isPair = true;

            int dealerCard = dealer.hands.get(0).cards.get(0).getWeight();

            if (checkDoubleConditions(dealerCard, isSoft, isPair, playerTotal)){
                doubleDown(h);
            }
            else if (checkStandConditions(dealerCard, isSoft, isPair, playerTotal)){
                stand(h);
            }
            else if (checkSplitConditions(dealerCard, isPair, playerTotal)){
                split(card1, card1, h, p);

            }
            else {
                hit(h);
                handleHand(h, p);
            }
        }
        else
        {
            int dealerCard = dealer.hands.get(0).cards.get(0).getWeight();

            if (checkStandConditions(dealerCard, isSoft, isPair, playerTotal)){
                stand(h);
            }
            else {
                hit(h);
                handleHand(h, p);
            }
        }
    }

    private Card addCard()
    {
        Card c = shoe.cards.remove(0);

        if (c.suit == null) {
            c = shoe.cards.remove(0);
            shoe.yellow = true;
            System.out.println("Last hand of the shoe!");
        }

        return c;
    }

    private boolean checkDoubleConditions(int dealerCard, boolean isSoft, boolean isPair, int playerTotal) {

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

    private boolean checkStandConditions(int dealerCard, boolean isSoft, boolean isPair, int playerTotal){

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

    private boolean checkSplitConditions(int dealerCard, boolean isPair, int playerTotal){

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

    private void hit(Hand h){
        System.out.println("Player is hitting with " + h.getTotal());
        h.addCard(addCard());
    }
    private void stand(Hand h){
        System.out.println("Player is staying with " + h.getTotal());
    }
    private void split(Card card1, Card card2, Hand h, Person p){

        System.out.println("Player is splitting with Cards:  " + card1 + " and " + card2);

        if (card1.getWeight() != 11) {
            Hand hand = new Hand();
            hand.addCard(card2);
            h.cards.remove(card2);

            p.hands.add(hand);
            handleHand(h, p);
        }
        else
        {
            Hand hand = new Hand();
            hand.addCard(card2);
            h.cards.remove(card2);

            hand.addCard(addCard());
            h.cards.add(addCard());
            hand.splitAces = true;
            h.splitAces = true;
            p.hands.add(hand);
        }
    }
    private void doubleDown(Hand h){
        System.out.println("Player is doubling down with " + h.getTotal());

        h.addCard(addCard());
    }



}
