package data;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private long value;

    public ArrayList<Card> hand;
    public ArrayList<Card> originalHand;
    public ArrayList<Card> bestHand;
    //dummy hand is a copy of normal hand in validate function. Cards will be removed from it and put to bestHand
    private ArrayList<Card> dummyHand;

    private Colour colourOfFlush;
    private Value straightValue;
    private Value quadsValue;
    private Value bestTripsValue;

    private int[] flushCounter;
    private ArrayList<Value> aPairsValue;
    private ArrayList<Value> aTripsValue;

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
        this.originalHand = hand;
        this.hand = getSortedHand(hand);
        this.bestHand= new ArrayList<>();
        validateHand();

    }


    public void validateHand() {
        bestHandToString = "";
        dummyHand= hand;
        value = 0L;
        cardCounter = countCards(this.hand);
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
        createBestHand();
        System.out.println("--------------");
        System.out.println(bestHandToString +"   #####   value = "+valueToString());


    }

    private void createBestHand() {
        if (royalFlush)
            createRoyalFlush();
        else if(straightFlush)
            createStriaghtFlush();
        else if (quads)
            createQuads();
        else if (fullHouse)
            createFullHouse();
        else if (flush)
            createFlush();
        else if (straight)
            createStraight();
        else if (trips)
            createTrips();
        else if (twoPair)
            createTwoPair();
        else if (pair)
            createPair();
        else if (highCard)
            createHighCard();
        else
            System.out.println("THIS SHOULD NEVER HAPPEN - Hand createBestHand default");

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
                case EIGHT:
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
        aPairsValue = new ArrayList<>();

        for(int i = cardCounter.length-1 ; i >= 0 ; i--){
            if(cardCounter[i]== 2){
                aPairsValue.add(getValueOutOfInt(i));
                pair = true;
                pairCounter++;
            }
        }

        if (pairCounter > 1) {
            twoPair = true;
        }

    }


    private void createRoyalFlush() {
        bestHandToString += "Royal Flush - A - K - Q - J - 10";
        value = 99999999999L;

    }

    private void createStriaghtFlush() {
        bestHandToString += "Straight Flush - ";
        value = 90000000000L;

    }

    private void createQuads() {
        bestHandToString += "Quads - "+ quadsValue;

        //add the four cards to best hand
        for(Card c : dummyHand ){
            if (c.getValue()== quadsValue){
                bestHand.add(c);
            }
        }
        dummyHand.removeIf(c -> c.getValue() == quadsValue);

        value = 80000000000L;
        value += calculateValue(getIntOutOfValue(quadsValue),1);

        //in test case the is the possibility of just a hand-to-test with 4 cards --> so no 5. card can be checked
        if(dummyHand.size()!= 0){
            Card bestOfTheRest =getHighcardOfHand();
            dummyHand.remove(bestOfTheRest);
            bestHand.add(bestOfTheRest);
            if (bestOfTheRest != null) {
                value += calculateValue(getIntOutOfValue(bestOfTheRest.getValue()),2);
            }
        }


    }

    private void createFullHouse() {
        bestHandToString += "Full House - " + aTripsValue.get(0)+ " - ";
        value = 70000000000L;

        //add the best trips to bestHand and remove them from dummyHand
        for(Card c : dummyHand){
            if (c.getValue() == aTripsValue.get(0)){
                bestHand.add(c);
            }
        }
        value += calculateValue(getIntOutOfValue(aTripsValue.get(0)), 1);
        dummyHand.removeIf(c -> c.getValue() == aTripsValue.get(0));

        //decide to add second trips or best pair
        if(aTripsValue.size() <=  1 ){
            System.out.println("IN ADD PAIR");
            bestHandToString += aPairsValue.get(0);

            for(Card c : dummyHand){
                if (c.getValue() == aPairsValue.get(0)){
                    bestHand.add(c);
                }
            }
            value += calculateValue(getIntOutOfValue(aPairsValue.get(0)), 2);

        }else{
            //BUG - when testing with +7 cards there can be 2 trips and a bestPair - then you have normally to check wich one of them is bigger
            bestHandToString += aTripsValue.get(1);
            int counter = 0;
            for(Card c : dummyHand){
                if (c.getValue() == aTripsValue.get(1)){
                    bestHand.add(c);
                    counter++;
                    if(counter == 2)
                        break;
                }
            }
            value += calculateValue(getIntOutOfValue(aTripsValue.get(1)), 2);

        }//end of else
    }

    private void createFlush() {
        bestHandToString += "Flush ";
        value = 60000000000L;

        dummyHand.removeIf(c -> c.getColour() != colourOfFlush);

        for(int i = 0 ; i < 5 ; i ++) {
            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);
            if (choosen != null) {
                value += calculateValue(getIntOutOfValue(choosen.getValue()), i + 1);
            }
        }

    }

    private void createStraight() {
        bestHandToString += "Straight - "+ straightValue;
        value = 50000000000L;
        value += calculateValue(getIntOutOfValue(straightValue), 1);

        //loop 5 times
        for (int i = straightValue.ordinal() ; i> straightValue.ordinal()-5; i--){
            int position = 1;
            for(Card c : dummyHand){
                if (c.getValue().ordinal() == i){
                    bestHand.add(c);
                    break;
                }
            }
        }//end 5loop

        if(straightValue == Value.FIVE){
            for(Card c : dummyHand){
                if (c.getValue() == Value.ACE){
                    bestHand.add(c);
                    break;
                }
            }
        }



    }

    private void createTrips() {
        bestHandToString += "Trips - "+ bestTripsValue;
        value = 40000000000L;
        value += calculateValue(getIntOutOfValue(bestTripsValue), 1);

        //add the tree cards to best hand
        for(Card c : dummyHand ){
            if (c.getValue()== bestTripsValue){
                bestHand.add(c);
            }
        }
        dummyHand.removeIf(c -> c.getValue() == bestTripsValue);

        for(int i = 1 ; i < 3   ; i ++) {
            if(dummyHand.size() == 0)
                break;

            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);
            value += calculateValue(getIntOutOfValue(choosen.getValue()), i + 1);
        }

    }

    private void createTwoPair() {
        bestHandToString += "Two Pair - "+aPairsValue.get(0) + " - "+aPairsValue.get(1);
        value = 30000000000L;

        //add the first pair  to bestHand and remove them from dummyHand
        for(Card c : dummyHand){
            if (c.getValue() == aPairsValue.get(0)){
                bestHand.add(c);
            }
        }
        value += calculateValue(getIntOutOfValue(aPairsValue.get(0)), 1);
        dummyHand.removeIf(c -> c.getValue() == aPairsValue.get(0));

        //add the second pair to bestHand and remove them from dummyHand
        for(Card c : dummyHand){
            if (c.getValue() == aPairsValue.get(1)){
                bestHand.add(c);
            }
        }
        value += calculateValue(getIntOutOfValue(aPairsValue.get(1)), 2);
        dummyHand.removeIf(c -> c.getValue() == aPairsValue.get(1));

        //add the last card
        if(dummyHand.size() != 0){
            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);
            value += calculateValue(getIntOutOfValue(choosen.getValue()), 3);
        }


    }

    private void createPair() {
        bestHandToString += "Pair - "+aPairsValue.get(0);
        value = 20000000000L;
        value += calculateValue(getIntOutOfValue(aPairsValue.get(0)), 1);

        //add the two cards to bestHand and remove them from dummyHand
        for(Card c : dummyHand){
            if (c.getValue() == aPairsValue.get(0)){
                bestHand.add(c);
            }
        }
        dummyHand.removeIf(c -> c.getValue() == aPairsValue.get(0));

        //get the other 3 cards
        for(int i = 1 ; i < 4   ; i ++) {
            if(dummyHand.size() == 0)
                break;
            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);
            value += calculateValue(getIntOutOfValue(choosen.getValue()), i + 1);
        }

    }

    private void createHighCard() {
        bestHandToString += "Highcard ";
        value = 10000000000L;

        //get 5x Times the highest valued card and remove it from dummy
        for(int i = 0 ; i < 5   ; i ++) {

            if(dummyHand.size() == 0)
                break;

            Card choosen = getHighcardOfHand();
            bestHand.add(choosen);
            dummyHand.remove(choosen);
            value += calculateValue(getIntOutOfValue(choosen.getValue()), i + 1);
        }

    }


    //looks in dummy for the highest valued card
    private Card getHighcardOfHand(){
        int [] dummyCardCounter = countCards(dummyHand);
        Value toSearch;
        if(dummyCardCounter[12] >= 1){
            toSearch = Value.ACE;
            bestHandToString+="- A ";
            for(Card c : dummyHand){
                if(c.getValue()== toSearch)
                    return c;

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
            toSearch = Value.EIGHT;
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
       return flush && straight;


    }

    private boolean isQuads() {
        for(int i = cardCounter.length-1 ; i >= 0 ; i--){
            if(cardCounter[i]== 4){
                quadsValue = getValueOutOfInt(i);
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse() {
        return trips && pair || aTripsValue.size() > 1;
    }

    private boolean isFlush() {
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
            straightValue = Value.EIGHT;
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
        aTripsValue = new ArrayList<>();
        for ( int i = cardCounter.length-1;i >= 0; i--){
            if(cardCounter[i]== 3)
                aTripsValue.add(getValueOutOfInt(i));
        }

        if(aTripsValue.size()>= 1){
            bestTripsValue = aTripsValue.get(0);
            return true;
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
        return !straightFlush && !royalFlush && !quads && !fullHouse && !flush && !straight && !trips && !twoPair && !pair;
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
            case EIGHT:
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

    private Value getValueOutOfInt(int i){
        switch (i){
            case 0:
                return Value.TWO;
            case 1:
                return Value.THREE;
            case 2:
                return Value.FOUR;
            case 3:
                return Value.FIVE;
            case 4:
                return Value.SIX;
            case 5:
                return Value.SEVEN;
            case 6:
                return Value.EIGHT;
            case 7:
                return Value.NINE;
            case 8:
                return Value.TEN;
            case 9:
                return Value.JACK;
            case 10:
                return Value.QUEEN;
            case 11:
                return Value.KING;
            case 12:
                return Value.ACE;
            default :
                return Value.TWO;
        }
    }

    //position at format X X X X X
    private int calculateValue(int v, int position){
        int exponent;
        switch (position){
            case 1:
                exponent = 8;
                break;
            case 2:
                exponent = 6;
                break;
            case 3:
                exponent = 4;
                break;
            case 4:
                exponent = 2;
                break;
            case 5:
                exponent = 0;
                break;
            default:
                System.out.println("THIS SHOULD NEVER HAPPEN - calculateValue() in Hand-(Validator)");
                exponent = 0;
                break;
        }
        return v * (int)Math.pow(10, exponent);
    }

    public ArrayList<Card> getSortedHand(ArrayList<Card> hand) {
        Collections.sort(hand);

        return hand;
    }

    private String valueToString(){

        String x = String.valueOf(value);
        x = addChar(x,'|',1);
        x = addChar(x,'-',10);
        x = addChar(x,'-',8);
        x = addChar(x,'-',6);
        x = addChar(x,'-',4);
        return x;
    }

    private String addChar(String str, char ch, int position) {
        int len = str.length();
        char[] updatedArr = new char[len + 1];
        str.getChars(0, position, updatedArr, 0);
        updatedArr[position] = ch;
        str.getChars(position, len, updatedArr, position + 1);
        return new String(updatedArr);
    }
}
