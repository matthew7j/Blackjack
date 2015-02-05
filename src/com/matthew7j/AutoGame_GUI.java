package com.matthew7j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoGame_GUI extends JFrame {
    protected int numDecks, numPlayers;
    private JTextField decksTextField;
    private JTextField playersTextField;
    private JButton simulateButton;
    private JPanel mainPanel;

    public AutoGame_GUI() {
        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);


        simulateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numDecks = Integer.parseInt(decksTextField.getText());
                numPlayers = Integer.parseInt(playersTextField.getText());
            }
        });

        new AutoGame(numDecks, numPlayers);
    }
}
