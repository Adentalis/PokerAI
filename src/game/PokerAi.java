package game;

import data.Deck;
import gui.TestBoard;

public class PokerAi {
    public static void main(String[] args) {
        System.out.println("--> PokerAI <--");

        //Game game = new Game();

        TestBoard board = new TestBoard();

    }

    public static void soutDeck(){
        Deck deck = new Deck();

        for(int i = 1 ; i <= 52 ; i ++) {
            System.out.println(i+": "+deck.getCard().toString());
        }

    }

}
