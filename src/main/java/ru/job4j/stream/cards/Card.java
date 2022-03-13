package ru.job4j.stream.cards;

public class Card {

    private Suit suit;
    private Values value;

    public Card(Suit suit, Values value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }
}
