
package com.sap.cic.code.challenge;

public class Card implements Comparable<Card> {

    public enum Suit {
        DIAMONDS("diamonds"), HEARTS("hearts"), SPADES("spades"), CLUBS("clubs");

        public final String value;

        Suit(String value) {
            this.value = value;
        }
    }

    public enum Kind {
        TWO(1, "2"), THREE(2, "3"), FOUR(3, "4"), FIVE(4, "5"), SIX(5, "6"), SEVEN(6, "7"), EIGHT(7, "8"), NINE(8,
                "9"), TEN(9, "10"), JACK(10, "Jack"), QUEEN(11, "Queen"), KING(12, "King"), ACE(13, "Ace");

        public final int rank;
        public final String value;

        Kind(int rank, String value) {
            this.rank = rank;
            this.value = value;
        }
    }

    public final Card.Kind kind;
    public final Card.Suit suit;

    public Card(Kind kind, Suit suit) {
        this.kind = kind;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card c) {
        return this.kind.rank - c.kind.rank;
    }

    @Override
    public String toString() {
        return suit + " " + kind;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kind == null) ? 0 : kind.hashCode());
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (kind != other.kind)
            return false;
        if (suit != other.suit)
            return false;
        return true;
    }
}