package com.sap.cic.code.challenge;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wenbo Huang on 2021/03/28.
 */
public class HandEvaluator {

    private static final int MAX_NO_OF_PAIRS = 2;

    private final int[] pairs = new int[MAX_NO_OF_PAIRS];

    private final List<Card> cards;

    private int noOfPairs;

    private int noOfTriples;

    private int flushSuit = -1;

    private int flushRank = -1;

    private int straightRank = -1;

    private int tripleRank = -1;

    private int quadRank = -1;

    private Hand type;

    /**
     * Whether we have a Straight with a wheeling Ace.
     */
    private boolean wheelingAce;

    /**
     * The rank distribution (number of cards for each rank).
     */
    private final int[] rankDist = new int[Card.Kind.values().length];

    /**
     * The suit distribution (number of cards for each suit).
     */
    private final int[] suitDist = new int[Card.Suit.values().length];

    public HandEvaluator(List<Card> cardList) {
        cards = cardList.stream()
                .sorted((o1, o2) -> o1.suit == o2.suit ? o2.compareTo(o1) : o1.suit.compareTo(o2.suit))
                .collect(Collectors.toList());

        // Find patterns.
        calculateDistributions();
        findStraight();
        findFlush();
        findDuplicates();

        // Find special values.
        boolean isSpecialValue =
                isStraightFlush() ||
                        isFourOfAKind() ||
                        isFullHouse() ||
                        isFlush() ||
                        isStraight() ||
                        isThreeOfAKind() ||
                        isTwoPairs() ||
                        isOnePair();

        if (!isSpecialValue) {
            type = Hand.HIGHCARD;
        }

    }

    public Hand getType() {
        return type;
    }

    /**
     * Calculates the rank and suit distributions.
     */
    private void calculateDistributions() {
        for (Card card : cards) {
            rankDist[card.kind.ordinal()]++;
            suitDist[card.suit.ordinal()]++;
        }
    }

    /**
     * Looks for a flush, i.e. five cards with the same suit.
     */
    private void findFlush() {
        for (int i = 0; i < Card.Suit.values().length; i++) {
            if (suitDist[i] >= 5) {
                flushSuit = i;
                for (Card card : cards) {
                    if (card.suit.ordinal() == flushSuit) {
                        if (!wheelingAce || card.kind != Card.Kind.ACE) {
                            flushRank = card.kind.ordinal();
                            break;
                        }
                        flushRank = Math.max(flushRank, card.kind.ordinal());
                    }
                }
                break;
            }
        }
    }

    /**
     * Looks for a Straight, i.e. five cards with sequential ranks.
     * <p>
     * The Ace has the rank of One in case of a Five-high Straight (5-4-3-2-A).
     */
    private void findStraight() {
        boolean inStraight = false;
        int rank = -1;
        int count = 0;
        for (int i = Card.Kind.values().length - 1; i >= 0; i--) {
            if (rankDist[i] == 0) {
                inStraight = false;
                count = 0;
            } else {
                if (!inStraight) {
                    // First card of the potential Straight.
                    inStraight = true;
                    rank = i;
                }
                count++;
                if (count >= 5) {
                    // Found a Straight!
                    straightRank = rank;
                }
            }
        }
        // Special case for the 'Steel Wheel' (Five-high Straight with a 'wheeling Ace') .
        if (count == 4 && rank == Card.Kind.FIVE.ordinal() && rankDist[Card.Kind.ACE.ordinal()] > 0) {
            wheelingAce = true;
            straightRank = rank;
        }
    }

    /**
     * Finds duplicates (pairs, triples and quads), i.e. two or more cards with
     * the same rank.
     */
    private void findDuplicates() {
        for (int i = Card.Kind.values().length - 1; i >= 0; i--) {
            if (rankDist[i] == 4) {
                quadRank = i;
            } else if (rankDist[i] == 3) {
                tripleRank = i;
                noOfTriples++;
            } else if (rankDist[i] == 2) {
                if (noOfPairs < MAX_NO_OF_PAIRS) {
                    pairs[noOfPairs++] = i;
                }
            }
        }
    }

    private boolean isOnePair() {
        if (noOfPairs == 1) {
            type = Hand.PAIR;
            // Get the rank of the pair.
            int pairRank = pairs[0];
            // Get the three kickers.
            int index = 2;
            for (Card card : cards) {
                int rank = card.kind.ordinal();
                if (rank != pairRank) {
                    if (index > 4) {
                        // We don't need any more kickers.
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isTwoPairs() {
        if (noOfPairs == 2) {
            type = Hand.TWO_PAIRS;
            // Get the value of the high and low pairs.
            int highRank = pairs[0];
            int lowRank = pairs[1];
            // Get the kicker card.
            for (Card card : cards) {
                int rank = card.kind.ordinal();
                if (rank != highRank && rank != lowRank) {
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isThreeOfAKind() {
        if (tripleRank != -1) {
            type = Hand.THREE_OF_A_KIND;
            // Get the remaining two cards as kickers.
            int index = 2;
            for (Card card : cards) {
                int rank = card.kind.ordinal();
                if (rank != tripleRank) {
                    if (index > 3) {
                        // We don't need any more kickers.
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isStraight() {
        if (straightRank != -1) {
            type = Hand.STRAIGHT;
            return true;
        } else {
            return false;
        }
    }

    private boolean isFlush() {
        if (flushSuit != -1) {
            type = Hand.FLUSH;
            int index = 1;
            for (Card card : cards) {
                if (card.suit.ordinal() == flushSuit) {
                    int rank = card.kind.ordinal();
                    if (index == 1) {
                        flushRank = rank;
                    }
                    if (index > 5) {
                        // We don't need more kickers.
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isFullHouse() {
        if (tripleRank != -1 && (noOfPairs > 0 || noOfTriples > 1)) {
            type = Hand.FULL_HOUSE;
            return true;
        } else {
            return false;
        }
    }

    private boolean isFourOfAKind() {
        if (quadRank != -1) {
            type = Hand.FOUR_OF_A_KIND;
            // Get the remaining card as kicker.
            for (Card card : cards) {
                int rank = card.kind.ordinal();
                if (rank != quadRank) {
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isStraightFlush() {
        if (straightRank != -1 && (flushRank == straightRank || wheelingAce)) {
            // Flush and Straight (possibly separate); check for Straight Flush.
            int straightRank2 = -1;
            int lastSuit = -1;
            int lastRank = -1;
            int inStraight = 1;
            int inFlush = 1;

            for (Card card : cards) {
                int rank = card.kind.ordinal();
                int suit = card.suit.ordinal();
                if (lastRank != -1) {
                    int rankDiff = lastRank - rank;
                    if (rankDiff == 1) {
                        // Consecutive rank; possible straight!
                        inStraight++;
                        if (straightRank2 == -1) {
                            straightRank2 = lastRank;
                        }
                        if (suit == lastSuit) {
                            inFlush++;
                        } else {
                            inFlush = 1;
                        }
                        if (inStraight >= 5 && inFlush >= 5) {
                            // Straight!
                            break;
                        }
                    } else if (rankDiff == 0) {
                        // Duplicate rank; skip.
                    } else {
                        // Non-consecutive; reset.
                        straightRank2 = -1;
                        inStraight = 1;
                        inFlush = 1;
                    }
                }
                lastRank = rank;
                lastSuit = suit;
            }

            if (inStraight >= 5 && inFlush >= 5) {
                if (straightRank == Card.Kind.ACE.ordinal()) {
                    // Royal Flush.
                    type = Hand.ROYAL_FLUSH;
                } else {
                    // Straight Flush.
                    type = Hand.STRAIGHT_FLUSH;
                }
                return true;
            } else if (wheelingAce && inStraight >= 4 && inFlush >= 4) {
                // Steel Wheel (Straight Flush with wheeling Ace).
                type = Hand.STRAIGHT_FLUSH;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
