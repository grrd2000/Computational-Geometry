package com.gerskom;

import java.awt.*;

public class Line {
    float a;
    float b;
    Point2D p;
    Point2D pBorder;
    float angle;

    public Line(float a, float b) {
        this.a = a;
        this.b = b;
        this.angle = (float)(Math.atan(a * 180 / Math.PI));
    }

    public Line(LineSegment l) {
        this.a = (l.p1.y - l.p2.y) / (l.p1.x - l.p2.x);
        this.b = l.p1.y - a * l.p1.x;
        this.p = l.p1;
        this.angle = (float)(Math.atan(a * 180 / Math.PI));
    }

    public Line(LineSegment l, Point2D p1) {
        this.a = (l.p1.y - l.p2.y) / (l.p1.x - l.p2.x);
        this.b = l.p1.y - a * l.p1.x;
        this.p = p1;
        this.pBorder = new Point2D();
        this.angle = (float)(Math.atan(a * 180 / Math.PI));
    }

    public Line (Point2D p, float angle) {
        this.p = p;
        this.angle = angle;
        this.a = (float)Math.tan(angle * Math.PI / 180);
        this.b = p.y - a * p.x;
    }

    public Line(Line line, Point2D point2D) {
        this.a = line.a;
        this.b = line.b;
        this.p = point2D;
        this.angle = (float)(Math.atan(a * 180 / Math.PI));
    }

    public Line(Point2D p1, Point2D p2) {
        this.a = (p1.y - p2.y) / (p1.x - p2.x);
        this.b = p1.y - a * p1.x;
        this.p = p1;
        this.angle = (float)(Math.atan(a * 180 / Math.PI));
    }

    public void print() {
        if(b > 0)   System.out.println("y = " + a + "x + " + b);
        else if(b < 0)   System.out.println("y = " + a + "x " + b);
        else if(b == 0)   System.out.println("y = " + a + "x");
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(2f));

        float lineRes = 0.1f;
        for (float x = 0; x <= SimulationPanel.panelX ; x += lineRes) {
            double eqX = a * x + b;
            if (eqX > 0 || eqX < SimulationPanel.panelY - 5)
                g2D.drawLine((int) x, (int) eqX, (int) x, (int) eqX);

        }

        for (float y = 0; y <= SimulationPanel.panelY ; y += lineRes) {
            double eqY = a * y + b;
            if (eqY > 5 || eqY < SimulationPanel.panelX - 5)
                g2D.drawLine((int) y, (int) eqY, (int) y, (int) eqY);
        }

    }
}
