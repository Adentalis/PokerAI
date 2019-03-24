package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class TestBoard implements ActionListener, Serializable {
    private JFrame jframe = new JFrame("AntiCHESS");
    private JPanel jpanel ;


    public TestBoard(){
        jframe.setLayout(new BorderLayout());
        jframe.setSize(1200,800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jframe.setLocation(dimension.width / 2 - this.jframe.getSize().width / 2, dimension.height / 2 - this.jframe.getSize().height / 2);
        jframe.setDefaultCloseOperation(3);

        jpanel = new JPanel();


        ImageIcon img = new ImageIcon("src/res/t.png");
        JLabel background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1200,800);
        jframe.add(background);



        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
