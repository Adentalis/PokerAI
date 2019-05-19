package data;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private long value;

    public ArrayList<Card> hand;
    public ArrayList<Card> sortedHand;
    public ArrayList<Card> bestHand;
    public ArrayList<Card> dummyHand;

    private Colour colourOfFlush;
    private Value straightValue;

    private int[] flushCounter;

    private int[] cardCounter;
    private int pairCounter;

    public String bestHandToString;

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
        this.hand = getSortedHand(hand);
        this.bestHand= new ArrayList<>();
        validateHand();

    }


    public void validateHand() {
        bestHandToString = "";
        dummyHand= hand;
        cardCounter = countCards(this.hand);

        countCards(this.hand);
        countPairs();
        quads = isQuads();
        trips = isTrips();
        twoPair = isTwoPair();
        pair= isPair();
        flush = isFlush();
        fullHouse = isFullHouse();
        straight = isStraight();
        straightFlush = isStraightFlush();
        royalFlush = isRoyalFlush();
        highCard  = isHighCard();
        this.bestHand = getBestHand();
        System.out.println(bestHandToString);
        System.out.println("--------------");
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

    private int[] countCards(ArrayList<Card> handOvergiven) {
        int [] cardCounterX  = new int[13];
        //count the values
        for (Card c : handOvergiven) {
            switch (c.getValue()) {
                case TWO:
                    cardCounterX[0] += 1;
                    break;
                case THREE:
                    cardCounterX[1] += 1;
                    break;
                case FOUR:
                    cardCounterX[2] += 1;
                    break;
                case FIVE:
                    cardCounterX[3] += 1;
                    break;
                case SIX:
                    cardCounterX[4] += 1;
                    break;
                case SEVEN:
                    cardCounterX[5] += 1;
                    break;
                case EIGEHT:
                    cardCounterX[6] += 1;
                    break;
                case NINE:
                    cardCounterX[7] += 1;
                    break;
                case TEN:
                    cardCounterX[8] += 1;
                    break;
                case JACK:
                    cardCounterX[9] += 1;
                    break;
                case QUEEN:
                    cardCounterX[10] += 1;
                    break;
                case KING:
                    cardCounterX[11] += 1;
                    break;
                case ACE:
                    cardCounterX[12] += 1;
                    break;

                default:
                    System.out.println("THIS SHOULD NEVER HAPPEN! - count cards default ");
                    break;
            }
        }
        return cardCounterX;
    }

    private void countPairs() {
        twoPair = false;
        pair = false;
        pairCounter = 0;
        for (int aCardCounter : cardCounter) {

            if (aCardCounter == 2) {
                pair = true;
                pairCounter++;
            }
        }
        if (pairCounter > 1) {
            twoPair = true;
        }
    }

    private ArrayList<Card> createRoyalFlush() {
        bestHandToString += "Royal Flush - ";

        value = 99999999999L;
        System.out.println(value);
        return null;
    }

    private ArrayList<Card> createStriaghtFlush() {
        bestHandToString += "Straight Flush - ";
        return null;
    }

    private ArrayList<Card> createQuads() {
        bestHandToString += "Quads - ";
        return null;
    }

    private ArrayList<Card> createFullHouse() {
        bestHandToString += "Full House - ";
        return null;
    }

    private ArrayList<Card> createFlush() {
        bestHandToString += "Flush - ";
        return null;
    }

    private ArrayList<Card> createStraight() {
        bestHandToString += "Straight - ";
        return null;
    }

    private ArrayList<Card> createTrips() {
        bestHandToString += "Trips - ";
        return null;
    }

    private ArrayList<Card> createTwoPair() {
        bestHandToString += "Two Pair - ";
        return null;
    }

    private ArrayList<Card> createPair() {
        bestHandToString += "Pair ";
        return null;
    }

    private ArrayList<Card> createHighCard() {
        bestHandToString += "Highcard ";
        for(int i = 0 ; i < 5 ; i ++) {
            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);

        }
        System.out.println(bestHandToString);
        return bestHand;
    }

    //looks in dummy for the highest valued card
    private Card getHighcardOfHand(){
        int [] dummyCardCounter = countCards(dummyHand);
        Value toSearch;
        if(dummyCardCounter[12] >= 1){
            System.out.println("CHECKED FO A");
            toSearch = Value.ACE;
            bestHandToString+="- A ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch){
                    System.out.println("CHECKED FO A");
                    return c;
                }

            }
        }

        if(dummyCardCounter[11] >= 1){
            toSearch = Value.KING;
            bestHandToString+="- K ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[10] >= 1){
            toSearch = Value.QUEEN;
            bestHandToString+="- Q ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[9] >= 1){
            toSearch = Value.JACK;
            bestHandToString+="- J ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[8] >= 1){
            toSearch = Value.TEN;
            bestHandToString+="- 10 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[7] >= 1){
            toSearch = Value.NINE;
            bestHandToString+="- 9 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[6] >= 1){
            toSearch = Value.EIGEHT;
            bestHandToString+="- 8 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[5] >= 1){
            toSearch = Value.SEVEN;
            bestHandToString+="- 7 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[4] >= 1){
            toSearch = Value.SIX;
            bestHandToString+="- 6 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[3] >= 1){
            toSearch = Value.FIVE;
            bestHandToString+="- 5 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[2] >= 1){
            toSearch = Value.FOUR;
            bestHandToString+="- 4 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[1] >= 1){
            toSearch = Value.THREE;
            bestHandToString+="- 3 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        if(dummyCardCounter[0] >= 1){
            toSearch = Value.TWO;
            bestHandToString+="- 2 ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;
            }
        }
        return null;
    }

    private boolean isRoyalFlush() {
        //TODO this is buggy - can get royal without real royal
        if (straightFlush && straightValue == Value.ACE) {
            System.out.println("IT IS ROYAL");
            return true;
        }
        return false;
    }

    //TODO this is buggy - can get royal without real royal
    private boolean isStraightFlush() {
        return straight && flush;
    }

    private boolean isQuads() {
        for (int aCardCounter : cardCounter) {
            if (aCardCounter == 4) {
                return true;
            }
        }
        return false;

    }

    //TODO buggy - 2x trips wird nich als full house erkannt
    private boolean isFullHouse() {
        return trips && pair;
    }

    private boolean isFlush() {
        //TODO create deck of the flush - best hand
        //Heart - Diamond - Spade - Clubs
        flushCounter = new int[4];

        //count the colours
        for (Card c : hand) {
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
            colourOfFlush = Colour.HEARTS;
            return true;
        } else if (flushCounter[1] >= 5) {
            colourOfFlush = Colour.DIAMOND;
            return true;
        } else if (flushCounter[2] >= 5) {
            colourOfFlush = Colour.SPADE;
            return true;
        } else if (flushCounter[3] >= 5) {
            colourOfFlush = Colour.CLUBS;
            return true;
        } else {
            colourOfFlush = Colour.NIL;
            return false;
        }


    }

    private boolean isStraight() {

        if (cardCounter[8] >= 1 && cardCounter[9] >= 1 && cardCounter[10] >= 1 && cardCounter[11] >= 1 && cardCounter[12] >= 1) {
            straightValue = Value.ACE;
            return true;
        }
        if (cardCounter[7] >= 1 && cardCounter[8] >= 1 && cardCounter[9] >= 1 && cardCounter[10] >= 1 && cardCounter[11] >= 1) {
            straightValue = Value.KING;
            return true;
        }
        if (cardCounter[6] >= 1 && cardCounter[7] >= 1 && cardCounter[8] >= 1 && cardCounter[9] >= 1 && cardCounter[10] >= 1) {
            straightValue = Value.QUEEN;
            return true;
        }
        if (cardCounter[5] >= 1 && cardCounter[6] >= 1 && cardCounter[7] >= 1 && cardCounter[8] >= 1 && cardCounter[9] >= 1) {
            straightValue = Value.JACK;
            return true;
        }
        if (cardCounter[4] >= 1 && cardCounter[5] >= 1 && cardCounter[6] >= 1 && cardCounter[7] >= 1 && cardCounter[8] >= 1) {
            straightValue = Value.TEN;
            return true;
        }
        if (cardCounter[3] >= 1 && cardCounter[4] >= 1 && cardCounter[5] >= 1 && cardCounter[6] >= 1 && cardCounter[7] >= 1) {
            straightValue = Value.NINE;
            return true;
        }
        if (cardCounter[2] >= 1 && cardCounter[3] >= 1 && cardCounter[4] >= 1 && cardCounter[5] >= 1 && cardCounter[6] >= 1) {
            straightValue = Value.EIGEHT;
            return true;
        }
        if (cardCounter[1] >= 1 && cardCounter[2] >= 1 && cardCounter[3] >= 1 && cardCounter[4] >= 1 && cardCounter[5] >= 1) {
            straightValue = Value.SEVEN;
            return true;
        }
        if (cardCounter[0] >= 1 && cardCounter[1] >= 1 && cardCounter[2] >= 1 && cardCounter[3] >= 1 && cardCounter[4] >= 1) {
            straightValue = Value.SIX;
            return true;
        }
        if (cardCounter[12] >= 1 && cardCounter[0] >= 1 && cardCounter[1] >= 1 && cardCounter[2] >= 1 && cardCounter[3] >= 1) {
            straightValue = Value.FIVE;
            return true;
        }

        return false;

    }

    private boolean isTrips() {

        for (int aCardCounter : cardCounter) {
            if (aCardCounter == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPair() {
        return twoPair;
    }

    private boolean isPair() {
        return pair;
    }

    private boolean isHighCard() {
        if (!straightFlush && !royalFlush && !quads && !fullHouse && !flush && !straight && !trips && !twoPair && !pair) {
            return true;
        } else
            return false;
    }


    public ArrayList<Card> getSortedHand(ArrayList<Card> hand) {
        Collections.sort(hand);

        return hand;
    }
}
