package com.matthew7j;

public class Game {
    int decks;

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
