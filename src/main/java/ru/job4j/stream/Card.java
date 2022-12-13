package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit[] suit;
    private Value[] value;

    public Card(Suit[] suit, Value[] value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
    Card cards = new Card(Suit.values(), Value.values());
        Stream.of(cards.suit)
            .flatMap(suit -> Stream.of(cards.value)
                    .map(value -> suit + " " + value))
            .forEach(System.out::println);
    }
}