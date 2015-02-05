package com.matthew7j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoGame_GUI {
    protected int numDecks, numPlayers;
    private JTextField decksTextField;
    private JTextField playersTextField;
    private JButton simulateButton;

    public AutoGame_GUI() {
        simulateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numDecks = Integer.parseInt(decksTextField.getText());
                numPlayers = Integer.parseInt(playersTextField.getText());
            }
        });

        AutoGame game = new AutoGame(numDecks, numPlayers);
    }
}
