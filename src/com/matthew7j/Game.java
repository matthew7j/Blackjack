package com.matthew7j;

import java.util.ArrayList;

public class Game {
    int decks;
    ArrayList<Player> players = new ArrayList<Player>();

    public Game(int decks) {
        this.decks = decks;

        initGame();
    }

    private void initGame() {
        initializeShoe();
    }

    private void initializeShoe() {
        Shoe shoe = new Shoe(decks);
        shoe.shuffle();

        System.out.println(shoe.toString());
    }

}
