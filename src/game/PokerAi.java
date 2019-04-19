package game;

import data.Card;
import data.Deck;
import data.Hand;
import gui.HandTestGui;
import gui.MainBoard;


import java.util.ArrayList;


public class PokerAi {
    public static void main(String[] args)

    {
        System.out.println("--> PokerAI <--");
        //Game game = new Game();
        MainBoard board = new MainBoard();

        ArrayList<Card> hand_array = createNewHand();

        Hand hand = new Hand(hand_array);
        board.update7Cards(hand);

        /*open the sortedCards Gui
        ArrayList<Card> sortedHand_array = hand.getSortedHand();
        board.showHandOnGui(sortedHand_array);
        */

        HandTestGui handTestGui = new HandTestGui();

        ArrayList<Card> bestHand_array = hand.validateHand();


    }

    private static ArrayList<Card> createNewHand() {
        Deck deck = new Deck();
        ArrayList<Card> hand_array = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            hand_array.add(deck.getCard());
        }
        return hand_array;
    }


}


