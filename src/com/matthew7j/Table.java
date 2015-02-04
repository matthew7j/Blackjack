package com.matthew7j;

import javax.swing.*;
import java.awt.*;

public class Table {
    int numPlayers;

    public Table(int numPlayers) {
        this.numPlayers = numPlayers;
        ImagePanel panel = new ImagePanel(new ImageIcon("images/blackjack.png").getImage());

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class ImagePanel extends JPanel {
    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

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
