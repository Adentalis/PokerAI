package data;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

    public ArrayList<Card> hand;
    public ArrayList<Card> sortedHand;
    public ArrayList<Card> bestHand;

    private Colour colourOfFlush;
    private int[] flushCounter;

    private int[] cardCounter;
    private int pairCounter;
    private Value straightValue;


    private boolean royalFlush;
    private boolean straightFlush;
    private boolean quads;
    private boolean fullHouse;
    private boolean flush;
    private boolean straight;
    private boolean trips;
    private boolean twoPair;
    private boolean pair;
    private boolean highCard;


    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
        this.bestHand = new ArrayList<>();
        this.sortedHand = hand;

    }


    public ArrayList<Card> getBestHand() {
        if (royalFlush)
            return createRoyalFlush();
        if (straightFlush)
            return createStriaghtFlush();
        if (quads)
            return createQuads();
        if (fullHouse)
            return createFullHouse();
        if (flush)
            return createFlush();
        if (straight)
            return createStraight();
        if (trips)
            return createTrips();
        if (twoPair)
            return createTwoPair();
        if (pair)
            return createPair();
        if (highCard)
            return createHighCard();

        System.out.println("THIS SOULD NEVER HAPPEN - Hand createBestHand default");
        return bestHand;

    }

    private ArrayList<Card> createRoyalFlush() {
        return null;
    }

    private ArrayList<Card> createStriaghtFlush() {
        return null;
    }

    private ArrayList<Card> createQuads() {
        return null;
    }

    private ArrayList<Card> createFullHouse() {
        System.out.println("volles haus");


        return null;


    }

    private ArrayList<Card> createFlush() {
        return null;
    }

    private ArrayList<Card> createStraight() {
        return null;
    }

    private ArrayList<Card> createTrips() {
        return null;
    }

    private ArrayList<Card> createTwoPair() {
        return null;
    }

    private ArrayList<Card> createPair() {
        return null;
    }

    private ArrayList<Card> createHighCard() {
        return null;
    }

    public void validateHand() {
        countCards();
        isQuads();
        isTrips();
        isPairs();
        isFlush();
        isFullHouse();
        isStraight();
        isStraightFlush();
        isRoyalFlush();
        isHighCard();
    }

    private void isRoyalFlush() {
        if (straightFlush && straightValue == Value.ACE) {
            royalFlush = true;
            System.out.println("OMG A ROYAL FLUSH");
        }
    }

    private void isStraightFlush() {
        if (straight && flush) {
            straightFlush = true;
            System.out.println("SO SICK! " + straightValue + " - STRAIGHT FLUSH");
        } else
            straightFlush = false;
    }

    private void isQuads() {
        quads = false;
        for (int i = 0; i < cardCounter.length; i++) {
            if (cardCounter[i] == 4) {
                quads = true;
            }
        }

    }

    private void isFullHouse() {
        fullHouse = false;
        if (trips && pair) {
            fullHouse = true;
        }
    }

    private void isFlush() {
        //TODO create deck of the flush - best hand
        //Heart - Diamond - Spade - Clubs
        flushCounter = new int[4];

        //count the colours
        for (Card c : sortedHand) {
            switch (c.getColour()) {
                case HEARTS:
                    flushCounter[0] += 1;
                    break;
                case DIAMOND:
                    flushCounter[1] += 1;
                    break;
                case SPADE:
                    flushCounter[2] += 1;
                    break;
                case CLUBS:
                    flushCounter[3] += 1;
                    break;
                default:
                    System.out.println("THIS SHOULD NEVER HAPPEN! - isFlush default ");
                    break;
            }
        }
        //check if one colour is more than 5 times in the hand
        if (flushCounter[0] >= 5) {
            System.out.println("HEARTH FLUSH");
            colourOfFlush = Colour.HEARTS;
            flush = true;
        } else if (flushCounter[1] >= 5) {
            System.out.println("DIAMONDS FLUSH");
            colourOfFlush = Colour.DIAMOND;
            flush = true;
        } else if (flushCounter[2] >= 5) {
            System.out.println("SPADE FLUSH");
            colourOfFlush = Colour.SPADE;
            flush = true;
        } else if (flushCounter[3] >= 5) {
            System.out.println("CLUBS FLUSH");
            colourOfFlush = Colour.CLUBS;
            flush = true;
        } else {
            colourOfFlush = Colour.NIL;
            flush = false;
        }

    }

    private void isStraight() {
        //check for straight
        int[] dummyCounter = cardCounter;
        for (int i = 0; i < dummyCounter.length; i++) {
            if (dummyCounter[i] == 2 || dummyCounter[i] == 3 || dummyCounter[i] == 4) {
                dummyCounter[i] = 1;
            }
        }

        System.out.println();
        straight = false;
        if (dummyCounter[12] == 1 && dummyCounter[0] == 1 && dummyCounter[1] == 1 && dummyCounter[2] == 1 && dummyCounter[3] == 1) {
            straight = true;
            straightValue = Value.FIVE;
            System.out.println("5- straight");
        }
        if (dummyCounter[0] == 1 && dummyCounter[1] == 1 && dummyCounter[2] == 1 && dummyCounter[3] == 1 && dummyCounter[4] == 1) {
            straight = true;
            straightValue = Value.SIX;
            System.out.println("6- straight");
        }
        if (dummyCounter[1] == 1 && dummyCounter[2] == 1 && dummyCounter[3] == 1 && dummyCounter[4] == 1 && dummyCounter[5] == 1) {
            straight = true;
            straightValue = Value.SEVEN;
            System.out.println("7- straight");
        }
        if (dummyCounter[2] == 1 && dummyCounter[3] == 1 && dummyCounter[4] == 1 && dummyCounter[5] == 1 && dummyCounter[6] == 1) {
            straight = true;
            straightValue = Value.EIGEHT;
            System.out.println("8- straight");
        }
        if (dummyCounter[3] == 1 && dummyCounter[4] == 1 && dummyCounter[5] == 1 && dummyCounter[6] == 1 && dummyCounter[7] == 1) {
            straight = true;
            straightValue = Value.NINE;
            System.out.println("9 straight");
        }
        if (dummyCounter[4] == 1 && dummyCounter[5] == 1 && dummyCounter[6] == 1 && dummyCounter[7] == 1 && dummyCounter[8] == 1) {
            straight = true;
            straightValue = Value.TEN;
            System.out.println("10 straight");
        }
        if (dummyCounter[5] == 1 && dummyCounter[6] == 1 && dummyCounter[7] == 1 && dummyCounter[8] == 1 && dummyCounter[9] == 1) {
            straight = true;
            straightValue = Value.JACK;
            System.out.println("J- straight");
        }
        if (dummyCounter[6] == 1 && dummyCounter[7] == 1 && dummyCounter[8] == 1 && dummyCounter[9] == 1 && dummyCounter[10] == 1) {
            straight = true;
            straightValue = Value.QUEEN;
            System.out.println("Q- straight");
        }
        if (dummyCounter[7] == 1 && dummyCounter[8] == 1 && dummyCounter[9] == 1 && dummyCounter[10] == 1 && dummyCounter[11] == 1) {
            straight = true;
            straightValue = Value.KING;
            System.out.println("K- straight");
        }
        if (dummyCounter[8] == 1 && dummyCounter[9] == 1 && dummyCounter[10] == 1 && dummyCounter[11] == 1 && dummyCounter[12] == 1) {
            straight = true;
            straightValue = Value.ACE;
            System.out.println("A- straight");
        }


    }

    private void isTrips() {
        trips = false;
        for (int i = 0; i < cardCounter.length; i++) {
            if (cardCounter[i] == 3) {
                System.out.println("TRIPS!!!");
                trips = true;
            }
        }
    }

    private void isPairs() {
        twoPair = false;
        pair = false;
        pairCounter = 0;

        for (int i = 0; i < cardCounter.length; i++) {

            if (cardCounter[i] == 2) {
                pair = true;
                pairCounter++;
            }
        }
        if (pairCounter > 1) {
            System.out.println("AT LEAST 2 PAIR");
            twoPair = true;
        }
    }

    private void isHighCard() {
        if (!straightFlush && !royalFlush && !quads && !fullHouse && !flush && !straight && !trips && !twoPair && !pair) {
            highCard = true;
            System.out.println("HIGH CARD WOHOO");
        } else
            highCard = false;
    }


    private void countCards() {
        cardCounter = new int[13];

        //count the colours
        for (Card c : sortedHand) {
            switch (c.getValue()) {
                case TWO:
                    cardCounter[0] += 1;
                    break;
                case THREE:
                    cardCounter[1] += 1;
                    break;
                case FOUR:
                    cardCounter[2] += 1;
                    break;
                case FIVE:
                    cardCounter[3] += 1;
                    break;
                case SIX:
                    cardCounter[4] += 1;
                    break;
                case SEVEN:
                    cardCounter[5] += 1;
                    break;
                case EIGEHT:
                    cardCounter[6] += 1;
                    break;
                case NINE:
                    cardCounter[7] += 1;
                    break;
                case TEN:
                    cardCounter[8] += 1;
                    break;
                case JACK:
                    cardCounter[9] += 1;
                    break;
                case QUEEN:
                    cardCounter[10] += 1;
                    break;
                case KING:
                    cardCounter[11] += 1;
                    break;
                case ACE:
                    cardCounter[12] += 1;
                    break;

                default:
                    System.out.println("THIS SHOULD NEVER HAPPEN! - count cards default ");
                    break;
            }
        }

    }


    public ArrayList<Card> getSortedHand() {
        Collections.sort(sortedHand);

        return sortedHand;
    }
}
