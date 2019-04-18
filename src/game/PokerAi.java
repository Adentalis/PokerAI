package game;

import data.Card;
import data.Deck;
import data.Hand;
import gui.TestBoard;

import java.util.ArrayList;


public class PokerAi {
    public static void main(String[] args) {
        System.out.println("--> PokerAI <--");
        //Game game = new Game();
        TestBoard board = new TestBoard();

        ArrayList<Card> hand_array = createNewHand();

        Hand hand = new Hand(hand_array);
        board.update7Cards(hand);

        ArrayList<Card> sortedHand_array = hand.getSortedHand();
        board.showHandOnGui(sortedHand_array);

        ArrayList<Card> bestHand_array = hand.validateHand();


    }

    private static ArrayList<Card> createNewHand() {
        Deck deck = new Deck();
        ArrayList<Card>hand_array = new ArrayList<>();

        for(int i = 0 ; i <= 6 ; i ++){
            hand_array.add(deck.getCard());
        }
        return hand_array;
    }


}


