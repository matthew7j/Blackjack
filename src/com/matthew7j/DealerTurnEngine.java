package com.matthew7j;

import java.util.ArrayList;

public class DealerTurnEngine {
    private ArrayList<Person> players;
    private Dealer dealer;
    private Shoe shoe;
    boolean isSoft = false;

    public DealerTurnEngine(ArrayList<Person> players, Shoe shoe){
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
        Hand h = dealer.hands.get(0);

        for (Card c : h.cards){
            if (c.getWeight() == 11)
                isSoft = true;
        }

        handleHand(h, dealer);
    }

    private void handleHand(Hand h, Dealer dealer){
        System.out.println("\n" + dealer.name + " current hand: \n" + h.toString());
        int dealerTotal = h.getTotal();

        if (dealerTotal <= 16)
        {
            hit(h);
            handleHand(h, dealer);
        }
        else if (isSoft && dealerTotal == 17)
        {
            hit(h);
            handleHand(h, dealer);
        }
        else
        {
            stand(h);
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

    private boolean checkStandConditions(int dealerCard, boolean isSoft, boolean isPair, int playerTotal){

        if (!isPair) {
            if (playerTotal >= 17 && !isSoft) {
                System.out.println("1");
                return true;
            }
            if (playerTotal >= 12 && playerTotal <= 16 && dealerCard >= 2 && dealerCard <= 6) {
                System.out.println("2");
                return true;
            }
            if (isSoft && playerTotal >= 19) {
                System.out.println("3");
                return true;
            }
            if ((isSoft && playerTotal == 18) && (dealerCard == 2 || dealerCard == 7 || dealerCard == 8)) {
                System.out.println("4");
                return true;
            }
        }
        if (isPair && playerTotal == 20) {
            System.out.println("5");
            return true;
        }
        return false;
    }

    private void hit(Hand h){
        System.out.println("Dealer is hitting with " + h.getTotal());
        h.addCard(addCard());
    }
    private void stand(Hand h){
        System.out.println("Dealer is staying with " + h.getTotal());
    }
}
