package com.matthew7j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blackjack_GUI extends JFrame {
    private JPanel blackjackPanel;
    private JSlider playerSlider;
    private JSlider deckSlider;
    private JButton startButton;

    public Blackjack_GUI() {
        super("Blackjack");
        setContentPane(blackjackPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);

        startButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int numPlayers = playerSlider.getValue();
                int numDecks = deckSlider.getValue();

                Game game = new Game(numPlayers, numDecks);
            }
        });
    }

}
