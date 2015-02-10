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
        switch (this.value) {
            case Two: {
                return 2;
            }
            case Three: {
                return 3;
            }
            case Four: {
                return 4;
            }
            case Five: {
                return 5;
            }
            case Six: {
                return 6;
            }
            case Seven: {
                return 7;
            }
            case Eight: {
                return 8;
            }
            case Nine: {
                return 9;
            }
            case Ten: {
                return 10;
            }
            case Jack: {
                return 10;
            }
            case Queen: {
                return 10;
            }
            case King: {
                return 10;
            }
            case Ace: {
                return 11;
            }
            default: {
                return 0;
            }
        }
    }

    public String toString() {
        return value + " of " + suit;
    }
}

