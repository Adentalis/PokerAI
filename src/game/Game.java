package game;

import data.Card;
import data.Deck;
import data.Hand;
import gui.MainBoard;
import player.HumanPlayer;
import player.Player;

import java.util.ArrayList;

public class Game {
  //  private Player player1;
  //  private Player player2;

    private int round;
    private MainBoard mainBoard;


    private ArrayList<Card> p1Cards;
    private ArrayList<Card> p2Cards;
    private ArrayList<Card> boardCards;

    private Deck deck;


    public Game() {

        initGame();

        startGame();

    }



    private void initGame() {
        mainBoard = new MainBoard();
        p1Cards = new ArrayList<>();
        p2Cards = new ArrayList<>();
        boardCards = new ArrayList<>();
        deck = new Deck();

        p1Cards.add(deck.getCard());
        p2Cards.add(deck.getCard());
        p1Cards.add(deck.getCard());
        p2Cards.add(deck.getCard());
        boardCards.add(deck.getCard());
        boardCards.add(deck.getCard());
        boardCards.add(deck.getCard());
        boardCards.add(deck.getCard());
        boardCards.add(deck.getCard());

        round = 0;

        mainBoard.showBoardCards(boardCards);
        mainBoard.showPlayerOneCards(p1Cards);
        mainBoard.showPlayerTwoCards(p2Cards);
    }

    private void startGame() {

    }

    private static ArrayList<Card> createNewHand() {
        Deck deck = new Deck();
        ArrayList<Card> hand_array = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            hand_array.add(deck.getCard());
            System.out.println(hand_array.get(i));
        }
        return hand_array;
    }


}
