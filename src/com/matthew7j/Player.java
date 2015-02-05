package com.matthew7j;

import java.util.ArrayList;

public class Player extends Person {
    double money;
    ArrayList<Card> cards = new ArrayList<Card>();

    public Player(double money) {
        this.money = money;
    }

}
