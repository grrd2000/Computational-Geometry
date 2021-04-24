package com.gerskom;

import java.awt.*;

public class Triangle {

    Point2D A;
    Point2D B;
    Point2D C;

    public Triangle() {
        this.A = new Point2D();
        this.B = new Point2D();
        this.C = new Point2D();
    }

    public Triangle(Point2D a, Point2D b, Point2D c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public Triangle(Triangle triangle) {
        this.A = triangle.A;
        this.B = triangle.B;
        this.C = triangle.C;
    }

    public float Area(Vector2D v1, Vector2D v2) {
        return (float)(Math.abs(0.5 * (v1.x * v2.y - v2.x * v1.y)));
    }

    public float Area() {

        return (float)(Math.abs(0.5 * ((B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y))));
    }

    /*public void printArea() {
        System.out.println("Area of the triangle:\t" + Area());
    }*/

    public void paintComponent (Graphics g) {

        int[] xPoints = {(int)A.x, (int)B.x, (int)C.x};
        int[] yPoints = {(int)A.y, (int)B.y, (int)C.y};

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(3.5f));
        g2D.drawPolygon(xPoints, yPoints, 3);
        g2D.setPaint(new Color(52,52,52));
        g2D.fillPolygon(xPoints, yPoints, 3);
    }
}
