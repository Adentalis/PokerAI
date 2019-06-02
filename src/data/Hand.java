package data;

import logic.HandValidator;

import java.util.ArrayList;
import java.util.Collections;

import static logic.HandValidator.validateHand;

public class Hand {
    private long value;

    public ArrayList<Card> hand;
    public ArrayList<Card> originalHand;
    public ArrayList<Card> bestHand;
    //dummy hand is a copy of normal hand in validate function. Cards will be removed from it and put to bestHand
    private ArrayList<Card> dummyHand;

    public String bestHandToString;


    public Hand(ArrayList<Card> hand) {
        this.originalHand = hand;
        this.bestHand= HandValidator.validateHand(hand);

        bestHandToString = HandValidator.bestHandToString;
        value = HandValidator.value;

    }



}
