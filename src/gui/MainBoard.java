package gui;

import data.Card;

import data.Hand;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;


public class MainBoard implements ActionListener, Serializable {
    private JFrame jframe = new JFrame("AntiCHESS");

    public JButton p1card1, p1card2, p2card1, p2card2, flop1, flop2, flop3, turn, river;
    public JButton[] boardCards = new JButton[5];
    public JButton[] p1Cards = new JButton[2];
    public JButton[] p2Cards = new JButton[2];
    public MainBoard() {

        jframe.setSize(1200, 800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(dimension.width / 2 - this.jframe.getSize().width / 2, dimension.height / 2 - this.jframe.getSize().height / 2);
        jframe.setDefaultCloseOperation(3);

        initCards();

        ImageIcon img = new ImageIcon("src/res/t.png");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 800);
        jframe.add(background);


        jframe.setVisible(true);
    }

    private void initCards() {
        p1card1 = new JButton();
        p1card1.setSize(100, 160);
        p1card1.setLocation(490, 500);
        p1card1.addActionListener(this);

        p1card2 = new JButton();
        p1card2.setSize(100, 160);
        p1card2.setLocation(610, 500);

        p2card1 = new JButton();
        p2card1.setSize(100, 160);
        p2card1.setLocation(490, 100);

        p2card2 = new JButton();
        p2card2.setSize(100, 160);
        p2card2.setLocation(610, 100);


        flop1 = new JButton();
        flop1.setSize(100, 160);
        flop1.setLocation(310, 300);

        flop2 = new JButton();
        flop2.setSize(100, 160);
        flop2.setLocation(430, 300);

        flop3 = new JButton();
        flop3.setSize(100, 160);
        flop3.setLocation(550, 300);

        turn = new JButton();
        turn.setSize(100, 160);
        turn.setLocation(670, 300);

        river = new JButton();
        river.setSize(100, 160);
        river.setLocation(790, 300);

        boardCards[0] = flop1;
        boardCards[1] = flop2;
        boardCards[2] = flop3;
        boardCards[3] = turn;
        boardCards[4] = river;

        p1Cards[0]= p1card1;
        p1Cards[1]= p1card2;
        p2Cards[0]= p2card1;
        p2Cards[1]= p2card2;

        jframe.add(p1card1);
        jframe.add(p1card2);
        jframe.add(p2card1);
        jframe.add(p2card2);
        jframe.add(flop1);
        jframe.add(flop2);
        jframe.add(flop3);
        jframe.add(turn);
        jframe.add(river);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());

        if (e.getSource() == this.p1card1) {
            System.out.println("But)"+e.getSource());
            System.out.println();
        }

    }

    private ImageIcon getImageIconForCard(Card card) {
        ImageIcon img;
        switch (card.toString()) {
            case "2(HEARTS)":
                img = new ImageIcon("src/res/small/2H.jpg");
                break;
            case "3(HEARTS)":
                img = new ImageIcon("src/res/small/3H.jpg");
                break;
            case "4(HEARTS)":
                img = new ImageIcon("src/res/small/4H.jpg");
                break;
            case "5(HEARTS)":
                img = new ImageIcon("src/res/small/5H.jpg");
                break;
            case "6(HEARTS)":
                img = new ImageIcon("src/res/small/6H.jpg");
                break;
            case "7(HEARTS)":
                img = new ImageIcon("src/res/small/7H.jpg");
                break;
            case "8(HEARTS)":
                img = new ImageIcon("src/res/small/8H.jpg");
                break;
            case "9(HEARTS)":
                img = new ImageIcon("src/res/small/9H.jpg");
                break;
            case "10(HEARTS)":
                img = new ImageIcon("src/res/small/10H.jpg");
                break;
            case "J(HEARTS)":
                img = new ImageIcon("src/res/small/JH.jpg");
                break;
            case "Q(HEARTS)":
                img = new ImageIcon("src/res/small/QH.jpg");
                break;
            case "K(HEARTS)":
                img = new ImageIcon("src/res/small/KH.jpg");
                break;
            case "A(HEARTS)":
                img = new ImageIcon("src/res/small/AH.jpg");
                break;

            case "2(DIAMOND)":
                img = new ImageIcon("src/res/small/2D.jpg");
                break;
            case "3(DIAMOND)":
                img = new ImageIcon("src/res/small/3D.jpg");
                break;
            case "4(DIAMOND)":
                img = new ImageIcon("src/res/small/4D.jpg");
                break;
            case "5(DIAMOND)":
                img = new ImageIcon("src/res/small/5D.jpg");
                break;
            case "6(DIAMOND)":
                img = new ImageIcon("src/res/small/6D.jpg");
                break;
            case "7(DIAMOND)":
                img = new ImageIcon("src/res/small/7D.jpg");
                break;
            case "8(DIAMOND)":
                img = new ImageIcon("src/res/small/8D.jpg");
                break;
            case "9(DIAMOND)":
                img = new ImageIcon("src/res/small/9D.jpg");
                break;
            case "10(DIAMOND)":
                img = new ImageIcon("src/res/small/10D.jpg");
                break;
            case "J(DIAMOND)":
                img = new ImageIcon("src/res/small/JD.jpg");
                break;
            case "Q(DIAMOND)":
                img = new ImageIcon("src/res/small/QD.jpg");
                break;
            case "K(DIAMOND)":
                img = new ImageIcon("src/res/small/KD.jpg");
                break;
            case "A(DIAMOND)":
                img = new ImageIcon("src/res/small/AD.jpg");
                break;

            case "2(CLUBS)":
                img = new ImageIcon("src/res/small/2C.jpg");
                break;
            case "3(CLUBS)":
                img = new ImageIcon("src/res/small/3C.jpg");
                break;
            case "4(CLUBS)":
                img = new ImageIcon("src/res/small/4C.jpg");
                break;
            case "5(CLUBS)":
                img = new ImageIcon("src/res/small/5C.jpg");
                break;
            case "6(CLUBS)":
                img = new ImageIcon("src/res/small/6C.jpg");
                break;
            case "7(CLUBS)":
                img = new ImageIcon("src/res/small/7C.jpg");
                break;
            case "8(CLUBS)":
                img = new ImageIcon("src/res/small/8C.jpg");
                break;
            case "9(CLUBS)":
                img = new ImageIcon("src/res/small/9C.jpg");
                break;
            case "10(CLUBS)":
                img = new ImageIcon("src/res/small/10C.jpg");
                break;
            case "J(CLUBS)":
                img = new ImageIcon("src/res/small/JC.jpg");
                break;
            case "Q(CLUBS)":
                img = new ImageIcon("src/res/small/QC.jpg");
                break;
            case "K(CLUBS)":
                img = new ImageIcon("src/res/small/KC.jpg");
                break;
            case "A(CLUBS)":
                img = new ImageIcon("src/res/small/AC.jpg");
                break;

            case "2(SPADE)":
                img = new ImageIcon("src/res/small/2S.jpg");
                break;
            case "3(SPADE)":
                img = new ImageIcon("src/res/small/3S.jpg");
                break;
            case "4(SPADE)":
                img = new ImageIcon("src/res/small/4S.jpg");
                break;
            case "5(SPADE)":
                img = new ImageIcon("src/res/small/5S.jpg");
                break;
            case "6(SPADE)":
                img = new ImageIcon("src/res/small/6S.jpg");
                break;
            case "7(SPADE)":
                img = new ImageIcon("src/res/small/7S.jpg");
                break;
            case "8(SPADE)":
                img = new ImageIcon("src/res/small/8S.jpg");
                break;
            case "9(SPADE)":
                img = new ImageIcon("src/res/small/9S.jpg");
                break;
            case "10(SPADE)":
                img = new ImageIcon("src/res/small/10S.jpg");
                break;
            case "J(SPADE)":
                img = new ImageIcon("src/res/small/JS.jpg");
                break;
            case "Q(SPADE)":
                img = new ImageIcon("src/res/small/QS.jpg");
                break;
            case "K(SPADE)":
                img = new ImageIcon("src/res/small/KS.jpg");
                break;
            case "A(SPADE)":
                img = new ImageIcon("src/res/small/AS.jpg");
                break;

            default:
                System.out.println("THIS SHOULD NOT HAPPEN - TESTBOARD -> update7Cards deafult case");
                img = new ImageIcon("src/res/small/AS.jpg");
        }

        return img;
    }

    public void showBoardCards(ArrayList<Card> hand) {

        setImage(hand, boardCards);

    }

    public void showPlayerOneCards(ArrayList<Card> hand) {

        setImage(hand, p1Cards);

    }

    public void showPlayerTwoCards(ArrayList<Card> hand) {

        setImage(hand, p2Cards);

    }

    private void setImage(ArrayList<Card> hand, JButton[] cards) {
        for (int i = 0; i < cards.length; i++) {

            if(i <= hand.size()) {
                ImageIcon img = getImageIconForCard(hand.get(i));
                cards[i].setIcon(img);
            }else{
                cards[i].setIcon(null);
            }
        }
    }

    //this opens a new Gui - just for tests at start
    public void showHandOnGui(ArrayList<Card> bestHand_array)  {
        JFrame jframeBest = new JFrame("BEST-HAND-GUI");
        jframeBest.setSize(880, 255);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframeBest.setLocation(dimension.width / 2 - this.jframe.getSize().width / 2, dimension.height / 2 - this.jframe.getSize().height / 2);
        jframeBest.setVisible(true);

        //Collections.sort(bestHand_array);

        JButton bestcard1, bestcard2, bestflop1, bestflop2, bestflop3, bestturn, bestriver;
        JButton[] bestcardButtons_array = new JButton[7];
        bestcard1 = new JButton();
        bestcard1.setSize(100, 160);
        bestcard1.setLocation(30, 30);

        bestcard2 = new JButton();
        bestcard2.setSize(100, 160);
        bestcard2.setLocation(145, 30);

        bestflop1 = new JButton();
        bestflop1.setSize(100, 160);
        bestflop1.setLocation(260, 30);

        bestflop2 = new JButton();
        bestflop2.setSize(100, 160);
        bestflop2.setLocation(375, 30);

        bestflop3 = new JButton();
        bestflop3.setSize(100, 160);
        bestflop3.setLocation(490, 30);

        bestturn = new JButton();
        bestturn.setSize(100, 160);
        bestturn.setLocation(605, 30);

        bestriver = new JButton();
        bestriver.setSize(100, 160);
        bestriver.setLocation(720, 30);

        bestcardButtons_array[0] = bestcard1;
        bestcardButtons_array[1] = bestcard2;
        bestcardButtons_array[2] = bestflop1;
        bestcardButtons_array[3] = bestflop2;
        bestcardButtons_array[4] = bestflop3;
        bestcardButtons_array[5] = bestturn;
        bestcardButtons_array[6] = bestriver;



        for (int i = 0; i < boardCards.length; i++) {

            if(i < bestHand_array.size()) {
                ImageIcon img = getImageIconForCard(bestHand_array.get(i));

                bestcardButtons_array[i].setIcon(img);
            }else{
                bestcardButtons_array[i].setIcon(null);
            }
        }

        jframeBest.add(bestcard1);
        jframeBest.add(bestcard2);
        jframeBest.add(bestflop1);
        jframeBest.add(bestflop2);
        jframeBest.add(bestflop3);
        jframeBest.add(bestturn);
        jframeBest.add(bestriver);

        ImageIcon img = new ImageIcon("src/res/t.png");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 800);
        jframeBest.add(background);
    }
}
