package data;

import java.util.ArrayList;
import java.util.Collections;

public class Hand  {

    public ArrayList<Card> hand;
    public ArrayList<Card> sortedHand;
    public ArrayList<Card> bestHand;

    public Colour colourOfFlush;

    public Hand(ArrayList<Card> hand) {
        this.hand = hand;
        this.bestHand = new ArrayList<>();
        this.sortedHand = hand;

    }
     public ArrayList<Card> validateHand(){

        boolean flush = isFlush();


         return bestHand;
     }

    private boolean isFlush() {
        //TODO create deck of the flush - best hand
        //Heart - Diamond - Spade - Clubs
        int[] flushCounter = new int[4];

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
            return true;
        }else if(flushCounter[1] >= 5){
            System.out.println("DIAMONDS FLUSH");
            colourOfFlush = Colour.DIAMOND;
            return true;
        }else if (flushCounter[2] >= 5){
            System.out.println("SPADE FLUSH");
            colourOfFlush = Colour.SPADE;
            return true;
        }else if (flushCounter[3] >= 5){
            System.out.println("CLUBS FLUSH");
            colourOfFlush = Colour.CLUBS;
            return true;
        }else{
            colourOfFlush = Colour.NIL;
            return false;
        }

    }

    public ArrayList<Card> getSortedHand() {
        Collections.sort(sortedHand);

        return sortedHand;
    }
}
