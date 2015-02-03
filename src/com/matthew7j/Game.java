package com.matthew7j;

public class Game {
    int decks, players;

    public Game(int players, int decks) {
        this.players = players;
        this.decks = decks;

        initGame();
    }

    private void initGame() {
        initializeShoe();
    }

    private void initializeShoe() {
        Shoe shoe = new Shoe(decks);
        System.out.println("Not shuffled\n" + shoe.toString());
        shoe.shuffle();
        System.out.println("Shuffled\n" + shoe.toString());
    }
}
