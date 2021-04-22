package com.gerskom;

public class Vector2D {
    float x;
    float y;
    double length;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
        this.length = Math.sqrt(x * x + y * y);
    }

    public Vector2D(Point2D p1, Point2D p2) {
        this.x = p2.x - p1.x;
        this.y = p2.y - p1.y;
        this.length = Math.sqrt(x * x + y * y);
    }
}
