# Code Challenge

----

## Introduction
Welcome, welcome, to this code puzzle, presenting to you with ❤️ by your future colleagues here @ CIC!

This is a very small yet hopefully interesting problem that will serve as the first step towards a career with CIC. You should aim to finish it within a few hours. 

## Texas Hold'em...

is a very popular card game across the world. If you haven't learnt to play it, please give [Texas Hold'em](https://en.wikipedia.org/wiki/Texas_hold_%27em) a read, as understanding the rule of this game is essential to completing this challenge. 

![image](https://user-images.githubusercontent.com/7297840/111072409-77769680-8515-11eb-8fc5-46991b5ee577.png)

## What we expect from you

Make a **Hand Judge**!

If you have read the rule of Texas Hold'em (**please do**), you will understand that the winner in a round of Texas Hold'em is determined by the **hands**. In essence, a hand is the five cards a player has at the end of each round, which consist of two cards on hand and three out of the five community cards. The player will opt for the largest card that will make five cards the **largest** in terms of the value of his **hand**. For instance,

![image](https://user-images.githubusercontent.com/7297840/111101545-1be3f180-8585-11eb-8faa-ae12e1b1d28b.png)

In this scenario, there are five community cards and two hands cards, and the player decides to select three out of the five community cards that will, in combination with the cards the player has on hand, make that **hand** a **straight flush**. 

In sum, we expect you will be able to build a **hand judge** that can tell us what the highest possible hand is among these seven cards.

## What has been provided

You will find a Java application in the repository. Four classes have been provided, namely `Game`, `Card`, `Hand` and `GameException`. The classes are expected to function as follows:

```java
Game game = Game.create();
List<Card> cards = Arrays.asList(
        new Card(Card.Kind.TEN, Card.Suit.CLUBS),
        new Card(Card.Kind.FOUR, Card.Suit.HEARTS),
        new Card(Card.Kind.SEVEN, Card.Suit.DIAMONDS),
        new Card(Card.Kind.KING, Card.Suit.CLUBS),
        new Card(Card.Kind.TWO, Card.Suit.SPADES),
        new Card(Card.Kind.ACE, Card.Suit.HEARTS),
        new Card(Card.Kind.EIGHT, Card.Suit.CLUBS)
);
game.add(cards);
assertEquals(Hand.HIGHCARD, game.showHand());
```

As you can see, we create a game, populate seven cards to the deck, and when we call `game.showHand()`, the function should return a `Hand` that corresponds to the highest possible hand out from these seven cards. 

There is also a `GameTest` in the test folder provided for you, and hopefully it can give you some hints as of what we expect from the solution you provide. 

> ⚠️ **Please refrain from tempering with `GameTest` as changing it will disqualify you from being considered for this position!**

> ⚠️ Please add `songford@me.com` as collabator. 

## Caveats

1. Submission with failed test cases is ignored. Exceeding time limit without successful submission means failure.
2. Submission with all tests passed will be reviewed, cheating would cause disqualification.
3. Faster and successful submission gets higher score   
4. You should click that green `Use this template` at the top right portion of the page. Fork this repository under your own GitHub profile, and start from there.
> :warning: **Make sure that the repository you fork is **PRIVATE**.** 
4. Have fun!
