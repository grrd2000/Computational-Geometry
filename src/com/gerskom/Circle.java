package com.gerskom;

import java.awt.*;

public class Circle {

    Point2D o;
    float r;

    public Circle(Point2D o, float r) {
        this.o = o;
        this.r = r;
    }

    public Circle(float x, float y) {
        this.o = new Point2D(x, y);
        this.r = (float) Math.random() * 150 + 50;
    }

    public Circle(float x, float y, float r) {
        this.o = new Point2D(x, y);
        this.r = r;
    }

    public Circle(Point2D point2D) {
        this.o = new Point2D();
        this.r = (float) Math.random() * 150 + 50;
    }

    public void print() {
        System.out.println("Circle of radius r: " + r);
        System.out.print("Center:  ");
        o.print();
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153, 51, 153));
        g2D.setStroke(new BasicStroke(3.5f));

        float tolerance = 1f;
        float res = 0.075f;

        for(float x = 0; x <= SimulationPanel.panelX; x += res){

            for(float y = 0; y <= SimulationPanel.panelY; y += res){

                //double x_pos = Math.sqrt(Math.abs(Math.pow(r, 2) - Math.pow((y - o.y), 2))) + o.x;
                //double y_pos = Math.sqrt(Math.abs(Math.pow(r, 2) - Math.pow((x - o.x), 2))) + o.y;

                double equation = Math.pow((x - o.x),2) + Math.pow((y - o.y), 2);

                if(equation >= (Math.pow(r,2) - tolerance) && equation < (Math.pow(r,2) + tolerance)) {
                    g2D.drawLine((int) x, (int) y, (int) x, (int) y);
                }
            }
        }
        g2D.setPaint(new Color(52,52,52));
        g2D.fillOval((int)(o.x - r), (int)(o.y - r + 1), (int)r*2, (int)r*2);
    }
}
