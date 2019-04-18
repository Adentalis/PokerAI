package gui;

import data.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class TestBoard implements ActionListener, Serializable {
    private JFrame jframe = new JFrame("AntiCHESS");

    public JButton card1, card2, flop1 , flop2 , flop3 ,turn, river;
    public JButton[] cardButtons = new JButton[7];

    public TestBoard(){
        jframe.setSize(1200,800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(dimension.width / 2 - this.jframe.getSize().width / 2, dimension.height / 2 - this.jframe.getSize().height / 2);
        jframe.setDefaultCloseOperation(3);

        initCards();

        ImageIcon img = new ImageIcon("src/res/t.png");
        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,800);
        jframe.add(background);





        jframe.setVisible(true);
    }

    private void initCards() {
        card1 = new JButton();
        card1.setSize(100,160);
        card1.setLocation(490,500);

        card2 = new JButton();
        card2.setSize(100,160);
        card2.setLocation(610,500);

        flop1 = new JButton();
        flop1.setSize(100,160);
        flop1.setLocation(310,300);

        flop2 = new JButton();
        flop2.setSize(100,160);
        flop2.setLocation(430,300);

        flop3 = new JButton();
        flop3.setSize(100,160);
        flop3.setLocation(550,300);

        turn = new JButton();
        turn.setSize(100,160);
        turn.setLocation(670,300);

        river = new JButton();
        river.setSize(100,160);
        river.setLocation(790,300);

        ImageIcon img1 = new ImageIcon("src/res/small/10C.jpg");
        card1.setIcon(img1);
        card2.setIcon(img1);
        flop1.setIcon(img1);
        flop2.setIcon(img1);
        flop3.setIcon(img1);
        turn.setIcon(img1);
        river.setIcon(img1);

        cardButtons[0]=card1;
        cardButtons[1]=card2;
        cardButtons[2]=flop1;
        cardButtons[3]=flop2;
        cardButtons[4]=flop3;
        cardButtons[5]=turn;
        cardButtons[6]=river;


        jframe.add(card1);
        jframe.add(card2);
        jframe.add(flop1);
        jframe.add(flop2);
        jframe.add(flop3);
        jframe.add(turn);
        jframe.add(river);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void update7Cards(Deck deck) {

        for(int i = 0; i<cardButtons.length;i++){
            ImageIcon img;
            switch (deck.getCard().toString()){
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
            cardButtons[i].setIcon(img);


        }

    }
}
