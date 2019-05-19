package game;

import data.Card;
import data.Deck;
import data.Hand;
import gui.HandTestGui;
import gui.MainBoard;


import java.util.ArrayList;


public class PokerAi {
    private static final boolean HANDTEST_GAMEMODE = true;
    public static void main(String[] args)

    {
        System.out.println("--> PokerAI <--");

        if (HANDTEST_GAMEMODE){
            HandTestGui handTestGui = new HandTestGui();
        }else {

            //Game game = new Game();
            Hand hand = new Hand(createNewHand());
            MainBoard mainBoard = new MainBoard();

            mainBoard.update7Cards(hand);

        /*open the sortedCards Gui
        ArrayList<Card> sortedHand_array = hand.getSortedHand();
        board.showHandOnGui(sortedHand_array);
        */


            hand.validateHand();
        }

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


