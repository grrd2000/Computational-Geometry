package com.gerskom;

import java.awt.*;

public class Point2D {
    float x;
    float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this.x = (int)(Math.random() * SimulationPanel.panelX);
        this.y = (int)(Math.random() * SimulationPanel.panelY);
    }

    public void print() {
        System.out.println("P[" + x + ", " + y + "]");
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(250,110,0));
        g2D.setStroke(new BasicStroke(9));
        g2D.drawLine((int)x, (int)y, (int)x, (int)y);
    }
}
