package com.matthew7j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {

    public Table() {
        ImagePanel panel = new ImagePanel(new ImageIcon("images/blackjack.png").getImage());
        JButton addPlayerButton = new JButton("Add Player");
        addPlayerButton.setSize(100, 30);
        panel.add(addPlayerButton);
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

        addPlayerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new Player_GUI();
            }
        });
    }
}

class ImagePanel extends JPanel {
    private Image img;

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
