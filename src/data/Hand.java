package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Hand {
    private long value;

    public ArrayList<Card> hand;
    public ArrayList<Card> sortedHand;
    public ArrayList<Card> bestHand;
    //dummy hand is a copy of normal hand in validate function. Cards will be removed from it and put to bestHand
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
        value = 0L;
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

        System.out.println("THIS SHOULD NEVER HAPPEN - Hand createBestHand default");
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
        value = 90000000000L;
        return null;
    }

    private ArrayList<Card> createQuads() {
        bestHandToString += "Quads - ";
        value = 80000000000L;
        return null;
    }

    private ArrayList<Card> createFullHouse() {
        bestHandToString += "Full House - ";
        value = 70000000000L;
        return null;
    }

    private ArrayList<Card> createFlush() {
        bestHandToString += "Flush ";
        value = 60000000000L;

        dummyHand.removeIf(c -> c.getColour() != colourOfFlush);

        for(int i = 0 ; i < 5 ; i ++) {
            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);
        }
        value+= 100000000* getIntOutOfValue(bestHand.get(0).getValue());
        value+= 1000000* getIntOutOfValue(bestHand.get(1).getValue());
        value+= 10000* getIntOutOfValue(bestHand.get(2).getValue());
        value+= 100* getIntOutOfValue(bestHand.get(3).getValue());
        value+= 1* getIntOutOfValue(bestHand.get(4).getValue());

        System.out.println("value = "+value);
        return null;
    }

    private ArrayList<Card> createStraight() {
        bestHandToString += "Straight - ";
        value = 50000000000L;

        return null;
    }

    private ArrayList<Card> createTrips() {
        bestHandToString += "Trips - ";
        value = 40000000000L;

        return null;
    }

    private ArrayList<Card> createTwoPair() {
        bestHandToString += "Two Pair - ";
        value = 30000000000L;
        return null;
    }

    private ArrayList<Card> createPair() {
        bestHandToString += "Pair ";
        value = 20000000000L;
        return null;
    }

    private ArrayList<Card> createHighCard() {
        bestHandToString += "Highcard ";
        value = 10000000000L;
        //get 5x Times the highest valued card and remove it from dummy
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
            toSearch = Value.ACE;
            bestHandToString+="- A ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch){
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
    private int getIntOutOfValue(Value v){
        switch (v){
            case ACE:
                return 14;
            case KING:
                return 13;
            case QUEEN:
                return 12;
            case JACK:
                return 11;
            case TEN:
                return 10;
            case NINE:
                return 9;
            case EIGEHT:
                return 8;
            case SEVEN:
                return 7;
            case SIX:
                return 6;
            case FIVE:
                return 5;
            case FOUR:
                return 4;
            case THREE:
                return 3;
            case TWO:
                return 2;
            default :
                return 0;
        }
    }

    public ArrayList<Card> getSortedHand(ArrayList<Card> hand) {
        Collections.sort(hand);

        return hand;
    }
}
