package game;

import data.Deck;
import gui.TestBoard;

public class PokerAi {
    public static void main(String[] args) {
        System.out.println("--> PokerAI <--");
        //Game game = new Game();

        Deck deck = new Deck();


        TestBoard board = new TestBoard();
        board.update7Cards(deck);
    }

    public static void soutDeck(){
        Deck deck = new Deck();



    }

}
