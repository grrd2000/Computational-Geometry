package com.gerskom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolygonHandler {

    Polygon polygon;
    int[] xPoints;
    int[] yPoints;
    int points;
    List<LineSegment> lineSegments = new ArrayList<>();

    public PolygonHandler(Polygon polygon) {
        this.polygon = polygon;
        this.xPoints = polygon.xpoints;
        this.yPoints = polygon.ypoints;
        this.points = polygon.npoints;

        for (int i = 0; i < points - 1; i++) {
            this.lineSegments.add(new LineSegment(new Point2D(xPoints[i], yPoints[i]), new Point2D(xPoints[i + 1], yPoints[i + 1])));
        }
        this.lineSegments.add(new LineSegment(new Point2D(xPoints[0], yPoints[0]), new Point2D(xPoints[xPoints.length - 1], yPoints[yPoints.length - 1])));
    }

    public PolygonHandler(PolygonHandler polygon) {
        this.polygon = polygon.polygon;
        this.xPoints = polygon.xPoints;
        this.yPoints = polygon.yPoints;
        this.points = polygon.points;
        for (int i = 0; i < points - 1; i++) {
            this.lineSegments.add(new LineSegment(new Point2D(xPoints[i], yPoints[i]), new Point2D(xPoints[i + 1], yPoints[i + 1])));
        }
        this.lineSegments.add(new LineSegment(new Point2D(xPoints[0], yPoints[0]), new Point2D(xPoints[xPoints.length - 1], yPoints[yPoints.length - 1])));
    }

    public PolygonHandler(int[] x, int[] y, int p) {
        this.polygon = new Polygon(x, y, p);
        this.xPoints = x;
        this.yPoints = y;
        this.points = p;
        for (int i = 0; i < points - 1; i++) {
            this.lineSegments.add(new LineSegment(new Point2D(xPoints[i], yPoints[i]), new Point2D(xPoints[i + 1], yPoints[i + 1])));
        }
        this.lineSegments.add(new LineSegment(new Point2D(xPoints[0], yPoints[0]), new Point2D(xPoints[xPoints.length - 1], yPoints[yPoints.length - 1])));
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(153,51,153));
        g2D.setStroke(new BasicStroke(3.5f));
        g2D.drawPolygon(xPoints, yPoints, points);
        g2D.setPaint(new Color(52,52,52));
        g2D.fillPolygon(xPoints, yPoints, points);
    }
}
