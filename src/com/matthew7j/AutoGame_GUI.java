package com.matthew7j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoGame_GUI extends JFrame {
    protected int numDecks, numPlayers;
    protected double amount, handAmount, tableMin, tableMax;
    private JTextField decksTextField;
    private JTextField playersTextField;
    private JButton simulateButton;
    private JPanel mainPanel;
    private JTextField amountTextField;
    private JTextField handAmountTextField;
    private JTextField tableMinTextField;
    private JTextField tableMaxTextField;
    private JLabel handLabel;

    public AutoGame_GUI() {
        //add(mainPanel);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        //setVisible(true);
/*
        simulateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numDecks = Integer.parseInt(decksTextField.getText());
                numPlayers = Integer.parseInt(playersTextField.getText());
                amount = Double.parseDouble(amountTextField.getText());
                handAmount = Double.parseDouble(handAmountTextField.getText());
                tableMin = Double.parseDouble(tableMinTextField.getText());
                tableMax = Double.parseDouble(tableMaxTextField.getText());

                new AutoGame(numDecks, numPlayers, amount, handAmount, tableMin, tableMax);
            }
        });
        */

        new AutoGame(7, 5, 1000, 20, 1, 100);

    }
}
