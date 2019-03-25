package data;

import java.util.ArrayList;

public class Hand {

    public ArrayList<Card> hand;

    public Hand(ArrayList<Card> hand) {
        this.hand = hand;

    }
     public void validateHand(){
         System.out.println("dd");
        for(Card c : hand){
            System.out.println(c.toString());
        }


     }

}
