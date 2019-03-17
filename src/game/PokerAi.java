package game;

import data.Deck;

public class PokerAi {
    public static void main(String[] args) {
        System.out.println("--> PokerAI <--t");
        Deck deck = new Deck();

        for(int i = 1 ; i <= 52 ; i ++) {
            System.out.println(i+": "+deck.getCard().toString());
        }

    }
}
