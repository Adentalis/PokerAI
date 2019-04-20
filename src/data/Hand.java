package data;

import java.util.ArrayList;
import java.util.Collections;

public class Hand  {

    public ArrayList<Card> hand;
    public ArrayList<Card> sortedHand;
    public ArrayList<Card> bestHand;

    public Colour colourOfFlush;
    int[] flushCounter;

    int[] cardCounter;
    int pairCounter;
    Value straightValue;



    boolean royalFlush;
    boolean straightFlush;
    boolean quads;
    boolean fullHouse;
    boolean flush;
    boolean straight;
    boolean trips;
    boolean twoPair;
    boolean pair;
    boolean highCard;


    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
        this.bestHand = new ArrayList<>();
        this.sortedHand = hand;

    }

     public void validateHand(){
        countCards();
        isQuads();
        isTrips();
        isPairs();
        isFlush();
        isFullHouse();
        isStraight();
        //todo check for straight flush then ....


     }

    private void isStraight() {
        for(int i = 0 ; i < cardCounter.length; i++){
            System.out.print(cardCounter[i]);
        }
        System.out.println();

        for(int i = 0 ; i < cardCounter.length-4; i++){
           System.out.print(cardCounter[i]);
        }
        System.out.println();

        //TODO check for straight


    }

    private void isFullHouse() {
        fullHouse = false;
        if(trips && pair){
            System.out.println("FULL HOUSE :)");
            fullHouse = true;
        }
    }

    private void isPairs() {
        twoPair = false;
        pair = false;
        pairCounter = 0;

        for(int i = 0; i < cardCounter.length ; i++){

            if(cardCounter[i]==2){
                pair = true;
                pairCounter++;
            }
        }
        if(pairCounter > 1 ){
            System.out.println("AT LEAST 2 PAIR");
            twoPair = true;
        }
    }

    private void isTrips() {
        trips = false;
        for(int i = 0; i < cardCounter.length ; i++){
            if(cardCounter[i]==3){
                System.out.println("TRIPS!!!");
                trips = true;
            }
        }
    }

    private void isQuads() {
        quads = false;
        for(int i = 0; i < cardCounter.length ; i++){
            if(cardCounter[i]==4){
                System.out.println("QUADS!!!");
                quads = true;
            }
        }

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
        if(flushCounter[0] >= 5){
            System.out.println("HEARTH FLUSH");
            colourOfFlush = Colour.HEARTS;
            flush = true;
        }else if(flushCounter[1] >= 5){
            System.out.println("DIAMONDS FLUSH");
            colourOfFlush = Colour.DIAMOND;
            flush = true;
        }else if (flushCounter[2] >= 5){
            System.out.println("SPADE FLUSH");
            colourOfFlush = Colour.SPADE;
            flush = true;
        }else if (flushCounter[3] >= 5){
            System.out.println("CLUBS FLUSH");
            colourOfFlush = Colour.CLUBS;
            flush = true;
        }else{
            colourOfFlush = Colour.NIL;
            flush = false;
        }

    }

    public ArrayList<Card> getSortedHand() {
        Collections.sort(sortedHand);

        return sortedHand;
    }
}
