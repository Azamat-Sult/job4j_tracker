package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeckOfCards {

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8, V_9, V_10, V_J, V_Q, V_K, V_A
    }

    public static class Card {
        private final Suit suit;
        private final Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Card{" + "suit=" + suit + ", value=" + value + '}';
        }
    }

    public static void main(String[] args) {
        List<Card> deck = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values()).map(val -> new Card(suit, val)))
                .collect(Collectors.toList());
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
