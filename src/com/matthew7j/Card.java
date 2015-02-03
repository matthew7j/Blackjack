package com.matthew7j;

public class Card {
    Value value;
    Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Card() {

    }

    public String toString() {
        return value + " of " + suit;
    }
}

