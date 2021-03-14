package com.sap.cic.code.challenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void test1() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.FOUR, Card.Suit.HEARTS),
                new Card(Card.Kind.SEVEN, Card.Suit.DIAMONDS),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.TWO, Card.Suit.SPADES),
                new Card(Card.Kind.QUEEN, Card.Suit.CLUBS),
                new Card(Card.Kind.THREE, Card.Suit.SPADES)

        );
        game.add(cards);
        assertEquals(Hand.HIGHCARD, game.showHand());
    }

    @Test
    void test2() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.ACE, Card.Suit.HEARTS),
                new Card(Card.Kind.SEVEN, Card.Suit.DIAMONDS),
                new Card(Card.Kind.TWO, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.SPADES),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.SPADES)
        );
        game.add(cards);
        assertEquals(Hand.PAIR, game.showHand());
    }

    @Test
    void test3() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.EIGHT, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.EIGHT, Card.Suit.DIAMONDS),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.SPADES),
                new Card(Card.Kind.SEVEN, Card.Suit.HEARTS),
                new Card(Card.Kind.KING, Card.Suit.SPADES)

        );
        game.add(cards);
        assertEquals(Hand.TWO_PAIRS, game.showHand());
    }

    @Test
    void test4() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.QUEEN, Card.Suit.HEARTS),
                new Card(Card.Kind.KING, Card.Suit.DIAMONDS),
                new Card(Card.Kind.SIX, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.SPADES),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.SPADES)
        );
        game.add(cards);
        assertEquals(Hand.THREE_OF_A_KIND, game.showHand());
    }

    @Test
    void test5() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.THREE, Card.Suit.CLUBS),
                new Card(Card.Kind.SIX, Card.Suit.HEARTS),
                new Card(Card.Kind.FIVE, Card.Suit.DIAMONDS),
                new Card(Card.Kind.SIX, Card.Suit.CLUBS),
                new Card(Card.Kind.FOUR, Card.Suit.SPADES),
                new Card(Card.Kind.SIX, Card.Suit.SPADES),
                new Card(Card.Kind.SEVEN, Card.Suit.SPADES)
        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT, game.showHand());
    }

    @Test
    void test6() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.TEN, Card.Suit.HEARTS),
                new Card(Card.Kind.QUEEN, Card.Suit.DIAMONDS),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.SPADES),
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.DIAMONDS)
        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT, game.showHand());
    }

    @Test
    void test7() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.ACE, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.FOUR, Card.Suit.DIAMONDS),
                new Card(Card.Kind.TWO, Card.Suit.CLUBS),
                new Card(Card.Kind.TEN, Card.Suit.SPADES),
                new Card(Card.Kind.THREE, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.SPADES)
        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT, game.showHand());
    }

    @Test
    void test8() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.ACE, Card.Suit.DIAMONDS),
                new Card(Card.Kind.SIX, Card.Suit.CLUBS),
                new Card(Card.Kind.EIGHT, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.NINE, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.HEARTS)

        );
        game.add(cards);
        assertEquals(Hand.FLUSH, game.showHand());
    }

    @Test
    void test9() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.TEN, Card.Suit.HEARTS),
                new Card(Card.Kind.KING, Card.Suit.DIAMONDS),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS),
                new Card(Card.Kind.SEVEN, Card.Suit.DIAMONDS),
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.SEVEN, Card.Suit.SPADES)

        );
        game.add(cards);
        assertEquals(Hand.FULL_HOUSE, game.showHand());
    }

    @Test
    void test10() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.SEVEN, Card.Suit.DIAMONDS),
                new Card(Card.Kind.KING, Card.Suit.DIAMONDS),
                new Card(Card.Kind.KING, Card.Suit.SPADES),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS),
                new Card(Card.Kind.SEVEN, Card.Suit.SPADES)

        );
        game.add(cards);
        assertEquals(Hand.FOUR_OF_A_KIND, game.showHand());
    }

    @Test
    void test11() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TWO, Card.Suit.CLUBS),
                new Card(Card.Kind.FOUR, Card.Suit.CLUBS),
                new Card(Card.Kind.THREE, Card.Suit.CLUBS),
                new Card(Card.Kind.SIX, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.CLUBS),
                new Card(Card.Kind.EIGHT, Card.Suit.CLUBS),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS)

        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT_FLUSH, game.showHand());
    }

    @Test
    void test12() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.QUEEN, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.SPADES),
                new Card(Card.Kind.QUEEN, Card.Suit.HEARTS)

        );
        game.add(cards);
        assertEquals(Hand.ROYAL_FLUSH, game.showHand());
    }

    @Test
    void test13() {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.QUEEN, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.QUEEN, Card.Suit.DIAMONDS)

        );
        game.add(cards);
        assertThrows(GameException.class, game::showHand);
    }

    @Test
    void test14() {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.QUEEN, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.CLUBS),
                new Card(Card.Kind.QUEEN, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.CLUBS)

        );
        game.add(cards);
        assertThrows(GameException.class, game::showHand);
    }


    @Test
    void test15() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TWO, Card.Suit.CLUBS),
                new Card(Card.Kind.FOUR, Card.Suit.CLUBS),
                new Card(Card.Kind.THREE, Card.Suit.CLUBS),
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.CLUBS),
                new Card(Card.Kind.ACE, Card.Suit.CLUBS),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS)

        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT_FLUSH, game.showHand());
    }

    @Test
    void test16() {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TEN, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.CLUBS),
                new Card(Card.Kind.QUEEN, Card.Suit.CLUBS),
                new Card(Card.Kind.KING, Card.Suit.HEARTS),
                new Card(Card.Kind.QUEEN, Card.Suit.DIAMONDS),
                new Card(Card.Kind.THREE, Card.Suit.HEARTS),
                new Card(Card.Kind.FOUR, Card.Suit.DIAMONDS)

        );
        game.add(cards);
        assertThrows(GameException.class, game::showHand);
    }

    @Test
    void test17() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TWO, Card.Suit.CLUBS),
                new Card(Card.Kind.FOUR, Card.Suit.CLUBS),
                new Card(Card.Kind.THREE, Card.Suit.CLUBS),
                new Card(Card.Kind.SIX, Card.Suit.HEARTS),
                new Card(Card.Kind.FIVE, Card.Suit.CLUBS),
                new Card(Card.Kind.THREE, Card.Suit.SPADES),
                new Card(Card.Kind.SIX, Card.Suit.CLUBS)

        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT_FLUSH, game.showHand());
    }

    @Test
    void test18() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.TWO, Card.Suit.DIAMONDS),
                new Card(Card.Kind.FOUR, Card.Suit.CLUBS),
                new Card(Card.Kind.THREE, Card.Suit.CLUBS),
                new Card(Card.Kind.SIX, Card.Suit.HEARTS),
                new Card(Card.Kind.FIVE, Card.Suit.CLUBS),
                new Card(Card.Kind.TEN, Card.Suit.SPADES),
                new Card(Card.Kind.SIX, Card.Suit.CLUBS)

        );
        game.add(cards);
        assertEquals(Hand.STRAIGHT, game.showHand());
    }

    @Test
    void test19() throws GameException {
        Game game = Game.create();
        List<Card> cards = Arrays.asList(
                new Card(Card.Kind.EIGHT, Card.Suit.CLUBS),
                new Card(Card.Kind.JACK, Card.Suit.HEARTS),
                new Card(Card.Kind.EIGHT, Card.Suit.DIAMONDS),
                new Card(Card.Kind.SEVEN, Card.Suit.CLUBS),
                new Card(Card.Kind.FIVE, Card.Suit.SPADES),
                new Card(Card.Kind.SEVEN, Card.Suit.HEARTS),
                new Card(Card.Kind.KING, Card.Suit.SPADES)

        );
        game.add(cards);
        assertEquals(Hand.TWO_PAIRS, game.showHand());
    }

}