package ru.job4j.stream.cards;

import java.util.stream.Stream;

public class Deck {

    public static void main(String[] args) {
        Stream.of(Suit.values())
        .flatMap(
                suit -> Stream.of(Values.values())
                .map(val -> new Card(suit, val))
        )
        .forEach(System.out::println);
    }
}
