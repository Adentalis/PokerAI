package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class TestBoard implements ActionListener, Serializable {
    private JFrame jframe = new JFrame("AntiCHESS");

    public JButton card1, card2;


    public TestBoard(){
        jframe.setSize(1200,800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(dimension.width / 2 - this.jframe.getSize().width / 2, dimension.height / 2 - this.jframe.getSize().height / 2);
        jframe.setDefaultCloseOperation(3);


        card1 = new JButton();
        card1.setSize(100,160);
        card1.setLocation(500,500);

        card2 = new JButton();
        card2.setSize(100,160);
        card2.setLocation(620,500);

        jframe.add(card1);
        jframe.add(card2);

        ImageIcon img = new ImageIcon("src/res/t.png");
        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,800);
        jframe.add(background);


        ImageIcon img1 = new ImageIcon("src/res/small/10C.jpg");
        ImageIcon img2 = new ImageIcon("src/res/small/9H.jpg");

        card1.setIcon(img1);
        card2.setIcon(img2);





        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
