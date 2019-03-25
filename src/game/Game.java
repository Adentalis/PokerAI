package game;

import data.Deck;
import player.HumanPlayer;
import player.Player;

public class Game {
    public Player player1;
    public Player player2;

    public int round;

    public Deck deck;

    public Game(Player p1, Player p2){
        player1 = p1;
        player2 = p2;

        initGame();
        startGame();
    }

    private void initGame() {
        deck = new Deck();
        round = 0;


    }

    private void startGame() {
        round = 2;
        System.out.println(round);



    }


}
