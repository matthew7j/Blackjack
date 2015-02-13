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
    public int getWeight()
    {
        if (this.value == null) return 0;
        if (this.value.ordinal() > 9) return 10;
        else if (this.value.ordinal() == 0) return 11;
        return this.value.ordinal() + 1;
    }

    public String toString() {
        return value + " of " + suit;
    }
}

