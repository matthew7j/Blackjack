package com.matthew7j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player_GUI extends JFrame {
    private JPanel newPlayerPanel;
    private JTextField buyinAmount;
    private JButton OKButton;

    public Player_GUI() {
        super("New Player");
        setContentPane(newPlayerPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 200);

        OKButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int money = Integer.parseInt(buyinAmount.getText());
                Player p = new Player(money);
            }
        });
    }
}


