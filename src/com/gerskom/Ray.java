package com.gerskom;

import java.awt.*;

public class Ray extends Line{

    public int direction;
    public int quarter = 0;

    /*public Ray(float a, float b) {
        super(a, b);
    }

    public Ray(LineSegment l) {
        super(l);
    }

    public Ray(LineSegment l, Point2D p1) {
        super(l, p1);
    }

    public Ray(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    public Ray(Line line, Point2D point2D) {
        super(line, point2D);
    }*/

    public Ray(Point2D p, float angle) {
        super(p, angle);
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public void print() {
        super.print();
        System.out.print("Starting point:  ");
        p.print();
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(2f));

        float lineRes = 0.1f;

        switch (direction) {
            case 0, 1 -> {
                for (float x = 0; x <= SimulationPanel.panelX; x += lineRes) {
                    double eqX = a * x + b;
                    if ((eqX > 5 || eqX < SimulationPanel.panelY - 5) && x > p.x)
                        g2D.drawLine((int) x, (int) eqX, (int) x, (int) eqX);

                }

                for (float y = 0; y <= SimulationPanel.panelY; y += lineRes) {
                    double eqY = a * y + b;
                    if ((eqY > 5 || eqY < SimulationPanel.panelX - 5) && y > p.x)
                        g2D.drawLine((int) y, (int) eqY, (int) y, (int) eqY);
                }
                quarter = 1;
            }
            case 2 -> {
                for (float x = 0; x <= SimulationPanel.panelX; x += lineRes) {
                    double eqX = a * x + b;
                    if ((eqX > 5 || eqX < SimulationPanel.panelY - 5) && x < p.x)
                        g2D.drawLine((int) x, (int) eqX, (int) x, (int) eqX);

                }
                quarter = 2;

                /*for (float y = 0; y <= SimulationPanel.panelY; y += lineRes) {
                    double eqY = a * y + b;
                    if ((eqY > 5 || eqY < SimulationPanel.panelX - 5) && y > p.x)
                        g2D.drawLine((int) y, (int) eqY, (int) y, (int) eqY);
                }*/
            }
            case 3 -> {
                for (float x = 0; x <= SimulationPanel.panelX; x += lineRes) {
                    double eqX = a * x + b;
                    if ((eqX > 5 || eqX < SimulationPanel.panelY - 5) && x > p.x)
                        g2D.drawLine((int) x, (int) eqX, (int) x, (int) eqX);

                }
                quarter = 3;

                /*for (float y = 0; y <= SimulationPanel.panelY; y += lineRes) {
                    double eqY = a * y + b;
                    if ((eqY > 5 || eqY < SimulationPanel.panelX - 5) && y < p.x)
                        g2D.drawLine((int) y, (int) eqY, (int) y, (int) eqY);
                }*/
            }
            case 4 -> {
                for (float x = 0; x <= SimulationPanel.panelX; x += lineRes) {
                    double eqX = a * x + b;
                    if ((eqX > 5 || eqX < SimulationPanel.panelY - 5) && x < p.x)
                        g2D.drawLine((int) x, (int) eqX, (int) x, (int) eqX);

                }

                for (float y = 0; y <= SimulationPanel.panelY; y += lineRes) {
                    double eqY = a * y + b;
                    if ((eqY > 5 || eqY < SimulationPanel.panelX - 5) && y < p.x)
                        g2D.drawLine((int) y, (int) eqY, (int) y, (int) eqY);
                }
                quarter = 4;

            }
        }
        //System.out.println(direction);
    }
}
