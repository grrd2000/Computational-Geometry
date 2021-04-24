package com.gerskom;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    JPanel northPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();

    SimulationPanel centerPanel = new SimulationPanel();
    ControlPanel eastPanel = new ControlPanel(centerPanel);

    MyFrame() {

        ImageIcon icon = new ImageIcon("triangle.png");

        int width = 1280;
        int height = 720;
        this.setSize(width, height);
        this.setTitle("Point In Relation To Stuff");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20,5));
        this.setVisible(true);

        northPanel.setBackground(Color.DARK_GRAY);
        westPanel.setBackground(Color.DARK_GRAY);
        southPanel.setBackground(Color.DARK_GRAY);
        eastPanel.setBackground(new Color(58,58,58));
        centerPanel.setBackground(new Color(58,58,58));

        centerPanel.setLayout(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(100,30));
        westPanel.setPreferredSize(new Dimension(15,100));
        eastPanel.setPreferredSize(new Dimension(280,100));
        southPanel.setPreferredSize(new Dimension(100,30));
        centerPanel.setPreferredSize(new Dimension(100,100));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);


    }
}
