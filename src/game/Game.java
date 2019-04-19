package game;

import data.Card;
import data.Deck;
import data.Hand;
import player.HumanPlayer;
import player.Player;

import java.util.ArrayList;

public class Game {
    public Player player1;
    public Player player2;

    public int round;

    public Deck deck;

    public Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;

        initGame();
        test();
        startGame();
    }

    public Game() {

        initGame();
        test();
        startGame();
    }

    private void test() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            cards.add(deck.getCard());
        }
        Hand h = new Hand(cards);
        h.validateHand();

    }

    private void initGame() {
        deck = new Deck();
        round = 0;


    }

    private void startGame() {


    }


}
