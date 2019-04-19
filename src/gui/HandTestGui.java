package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


public class HandTestGui implements ActionListener {
    private final int AMOUNTOFCARDS = 52;
    private JFrame jframe = new JFrame("CREATE A HAND");
    ArrayList<JButton> cardButtonsArrayList;

    public HandTestGui() {
        jframe.setSize(1700, 800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation((dimension.width / 2 - this.jframe.getSize().width / 2) + 1850, (dimension.height / 2 - this.jframe.getSize().height / 2) - 110);
        jframe.setDefaultCloseOperation(3);
        jframe.setLayout(new LayoutManager() {
            @Override
            public void addLayoutComponent(String name, Component comp) {

            }

            @Override
            public void removeLayoutComponent(Component comp) {

            }

            @Override
            public Dimension preferredLayoutSize(Container parent) {
                return null;
            }

            @Override
            public Dimension minimumLayoutSize(Container parent) {
                return null;
            }

            @Override
            public void layoutContainer(Container parent) {

            }
        });

        initCardButtons();
        jframe.setVisible(true);
    }

    private void initCardButtons() {
        //manage all 52 cards just with this arrayList - will be fun
        cardButtonsArrayList = new ArrayList<>();

        //init JButtons + add to jframe
        for (int i = 0; i < AMOUNTOFCARDS; i++) {
            cardButtonsArrayList.add(new JButton());
            cardButtonsArrayList.get(i).setSize(100, 160);
            int multiplier = i / 13;
            cardButtonsArrayList.get(i).setLocation((50 + 125 * i) - (13 * 125 * multiplier), 50 + 180 * multiplier);
            jframe.add(cardButtonsArrayList.get(i));
            cardButtonsArrayList.get(i).addActionListener(this);
        }
        int counter = 0;

        for(int i = 0 ; i < AMOUNTOFCARDS; i++) {
            if (i == 0)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/AH.jpg"));
            if (i == 1)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/KH.jpg"));
            if (i == 2)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/QH.jpg"));
            if (i == 3)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/JH.jpg"));
            if (i == 4)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/10H.jpg"));
            if (i == 5)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/9H.jpg"));
            if (i == 6)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/8H.jpg"));
            if (i == 7)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/7H.jpg"));
            if (i == 8)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/6H.jpg"));
            if (i == 9)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/5H.jpg"));
            if (i == 10)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/4H.jpg"));
            if (i == 11)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/3H.jpg"));
            if (i == 12)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/2H.jpg"));
            if (i == 13)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/AD.jpg"));
            if (i == 14)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/KD.jpg"));
            if (i == 15)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/QD.jpg"));
            if (i == 16)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/JD.jpg"));
            if (i == 17)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/10D.jpg"));
            if (i == 18)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/9D.jpg"));
            if (i == 19)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/8D.jpg"));
            if (i == 20)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/7D.jpg"));
            if (i == 21)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/6D.jpg"));
            if (i == 22)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/5D.jpg"));
            if (i == 23)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/4D.jpg"));
            if (i == 24)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/3D.jpg"));
            if (i == 25)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/2D.jpg"));
            if (i == 26)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/AC.jpg"));
            if (i == 27)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/KC.jpg"));
            if (i == 28)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/QC.jpg"));
            if (i == 29)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/JC.jpg"));
            if (i == 30)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/10C.jpg"));
            if (i == 31)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/9C.jpg"));
            if (i == 32)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/8C.jpg"));
            if (i == 33)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/7C.jpg"));
            if (i == 34)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/6C.jpg"));
            if (i == 35)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/5C.jpg"));
            if (i == 36)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/4C.jpg"));
            if (i == 37)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/3C.jpg"));
            if (i == 38)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/2C.jpg"));
            if (i == 39)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/AS.jpg"));
            if (i == 40)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/KS.jpg"));
            if (i == 41)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/QS.jpg"));
            if (i == 42)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/JS.jpg"));
            if (i == 43)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/10S.jpg"));
            if (i == 44)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/9S.jpg"));
            if (i == 45)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/8S.jpg"));
            if (i == 46)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/7S.jpg"));
            if (i == 47)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/6S.jpg"));
            if (i == 48)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/5S.jpg"));
            if (i == 49)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/4S.jpg"));
            if (i == 50)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/3S.jpg"));
            if (i == 51)
                cardButtonsArrayList.get(counter).setIcon(new ImageIcon("src/res/small/2S.jpg"));

            counter++;

        }


        ImageIcon img = new ImageIcon("src/res/green_back.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1400, 800);
        //jframe.add(background);

    }

    private Icon getImageIcon(int i) {
        if (i == 0)
            return new ImageIcon("src/res/small/AH.jpg");
        if (i == 1)
            return new ImageIcon("src/res/small/KH.jpg");
        if (i == 2)
            return new ImageIcon("src/res/small/QH.jpg");
        if (i == 3)
            return new ImageIcon("src/res/small/JH.jpg");
        if (i == 4)
            return new ImageIcon("src/res/small/10H.jpg");
        if (i == 5)
            return new ImageIcon("src/res/small/9H.jpg");
        if (i == 6)
            return new ImageIcon("src/res/small/8H.jpg");
        if (i == 7)
            return new ImageIcon("src/res/small/7H.jpg");
        if (i == 8)
            return new ImageIcon("src/res/small/6H.jpg");
        if (i == 9)
            return new ImageIcon("src/res/small/5H.jpg");
        if (i == 10)
            return new ImageIcon("src/res/small/4H.jpg");
        if (i == 11)
            return new ImageIcon("src/res/small/3H.jpg");
        if (i == 12)
            return new ImageIcon("src/res/small/2H.jpg");
        if (i == 13)
            return new ImageIcon("src/res/small/AD.jpg");
        if (i == 14)
            return new ImageIcon("src/res/small/KD.jpg");
        if (i == 15)
            return new ImageIcon("src/res/small/QD.jpg");
        if (i == 16)
            return new ImageIcon("src/res/small/JD.jpg");
        if (i == 17)
            return new ImageIcon("src/res/small/10D.jpg");
        if (i == 18)
            return new ImageIcon("src/res/small/9D.jpg");
        if (i == 19)
            return new ImageIcon("src/res/small/8D.jpg");
        if (i == 20)
            return new ImageIcon("src/res/small/7D.jpg");
        if (i == 21)
            return new ImageIcon("src/res/small/6D.jpg");
        if (i == 22)
            return new ImageIcon("src/res/small/5D.jpg");
        if (i == 23)
            return new ImageIcon("src/res/small/4D.jpg");
        if (i == 24)
            return new ImageIcon("src/res/small/3D.jpg");
        if (i == 25)
            return new ImageIcon("src/res/small/2D.jpg");
        if (i == 26)
            return new ImageIcon("src/res/small/AC.jpg");
        if (i == 27)
            return new ImageIcon("src/res/small/KC.jpg");
        if (i == 28)
            return new ImageIcon("src/res/small/QC.jpg");
        if (i == 29)
            return new ImageIcon("src/res/small/JC.jpg");
        if (i == 30)
            return new ImageIcon("src/res/small/10C.jpg");
        if (i == 31)
            return new ImageIcon("src/res/small/9C.jpg");
        if (i == 32)
            return new ImageIcon("src/res/small/8C.jpg");
        if (i == 33)
            return new ImageIcon("src/res/small/7C.jpg");
        if (i == 34)
            return new ImageIcon("src/res/small/6C.jpg");
        if (i == 35)
            return new ImageIcon("src/res/small/5C.jpg");
        if (i == 36)
            return new ImageIcon("src/res/small/4C.jpg");
        if (i == 37)
            return new ImageIcon("src/res/small/3C.jpg");
        if (i == 38)
            return new ImageIcon("src/res/small/2C.jpg");
        if (i == 39)
            return new ImageIcon("src/res/small/AS.jpg");
        if (i == 40)
            return new ImageIcon("src/res/small/KS.jpg");
        if (i == 41)
            return new ImageIcon("src/res/small/QS.jpg");
        if (i == 42)
            return new ImageIcon("src/res/small/JS.jpg");
        if (i == 43)
            return new ImageIcon("src/res/small/10S.jpg");
        if (i == 44)
            return new ImageIcon("src/res/small/9S.jpg");
        if (i == 45)
            return new ImageIcon("src/res/small/8S.jpg");
        if (i == 46)
            return new ImageIcon("src/res/small/7S.jpg");
        if (i == 47)
            return new ImageIcon("src/res/small/6S.jpg");
        if (i == 48)
            return new ImageIcon("src/res/small/5S.jpg");
        if (i == 49)
            return new ImageIcon("src/res/small/4S.jpg");
        if (i == 50)
            return new ImageIcon("src/res/small/3S.jpg");


        return null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());



    }



}
