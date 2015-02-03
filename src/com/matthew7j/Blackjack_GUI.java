package com.matthew7j;

import javax.swing.*;

public class Blackjack_GUI extends JFrame {
    private JPanel blackjackPanel;
    private JSlider slider1;
    private JSlider slider2;
    private JButton startButton;

    public Blackjack_GUI() {
        super("Blackjack");
        setContentPane(blackjackPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);
    }

}
