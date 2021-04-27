package com.gerskom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Operation {

    static float tolerance = 2.5f;

    /*public boolean PointAffiliation(Point2D p, Line l) {

        double eq = (-l.a * p.x) + p.y + (-l.b);

        return eq > -tolerance && eq < tolerance;
    }*/

    /*static Line lineTranslation(Vector2D v, Line l) {

        l.b = l.a * -v.x + l.b + v.y;

        return l;
    }*/

    /*public Point2D PointTranslation(Vector2D v, Point2D point2D) {

        point2D.x += v.x;
        point2D.y += v.y;

        return point2D;
    }

    public Point2D PointRotation(Point2D p, float angle) {

        float newX;
        float newY;

        newX = (float) (p.x * Math.cos(angle * Math.PI / 180) - p.y * Math.sin(angle * Math.PI / 180));
        newY = (float) (p.y * Math.cos(angle * Math.PI / 180) + p.x * Math.sin(angle * Math.PI / 180));

        return new Point2D(newX, newY);
    }

    public Point2D PointReflection(Point2D p, int opt) {

        return switch (opt) {
            case 1 -> new Point2D(-p.x, p.y);     //względem osi OX
            case 2 -> new Point2D(p.x, -p.y);     //względem osi OY
            case 3 -> new Point2D(-p.x, -p.y);    //względem początku układu współrzędnych
            default -> p;
        };
    }*/

    static int onLeft(Point2D p1, Point2D p2, Point2D p3) {

        int isLeft = 0;
        double eq = (p3.x - p2.x) * (p1.y - p2.y) - (p1.x - p2.x) * (p3.y - p2.y);

        if (eq > 0) isLeft = 2;

        if (eq <= 0) isLeft = 1;

        return isLeft;
    }

    public static void whichSide(Point2D p, Line l) {

        double eq = (-l.a * p.x) + p.y + (-l.b);

        if (eq > tolerance) {
            System.out.println("The point is on the right.");
        } else if (eq < -tolerance) {
            System.out.println("The point is on the left.");
        } else {
            System.out.println("The point is on the line.");
        }
    }

    public boolean isOnLine(Point2D p, Line l) {

        double eq = (-l.a * p.x) + p.y + (-l.b);

        return !(eq > tolerance) && !(eq < -tolerance);
    }

    public static Point2D crossingPointCramer(Line l1, Line l2) {

        float W = (-l1.a * 1) - (-l2.a * 1);

        float Wx = (l1.b * 1) - (l2.b * 1);
        float Wy = (-l1.a * l2.b) - (l1.b * -l2.a);

        float x = Wx / W;
        float y = Wy / W;

        return new Point2D(x, y);
    }

    static boolean isCrossing(LineSegment lineSegment, Point2D point2D) {

        if (!((point2D.x < lineSegment.p1.x && point2D.x < lineSegment.p2.x) ||
                (point2D.x > lineSegment.p1.x && point2D.x > lineSegment.p2.x))) {
            SimulationPanel.foundPoints.add(point2D);
            return true;
        } else return false;
    }

    public boolean isInsideTriangle(Triangle triangle, Point2D point2D) {

        double PA = new Vector2D(point2D, triangle.A).length;
        double PB = new Vector2D(point2D, triangle.B).length;
        double PC = new Vector2D(point2D, triangle.C).length;

        double b = new Vector2D(triangle.A, triangle.C).length;
        double a = new Vector2D(triangle.B, triangle.C).length;
        double c = new Vector2D(triangle.B, triangle.A).length;

        double angle1 = ((Math.acos(((c * c - PB * PB - PA * PA) / (2 * PA * PB)))) * 180) / Math.PI;
        double angle2 = ((Math.acos(((b * b - PA * PA - PC * PC) / (2 * PA * PC)))) * 180) / Math.PI;
        double angle3 = ((Math.acos(((a * a - PB * PB - PC * PC) / (2 * PC * PB)))) * 180) / Math.PI;

        double angle = angle1 + angle2 + angle3;

        return ((float) angle < 180.0005 && (float) angle > 179.9995)
                || isOnLine(point2D, new Line(new LineSegment(triangle.A, triangle.B)))
                || isOnLine(point2D, new Line(new LineSegment(triangle.B, triangle.C)))
                || isOnLine(point2D, new Line(new LineSegment(triangle.C, triangle.A)));
    }

    static boolean isInsidePolygon(PolygonHandler polygon, Point2D point2D, float angle) {

        int counter = 0;
        Point2D crossedPoint;
        List<Point2D> crossedPoints = new ArrayList<>();
        Ray ray = SimulationPanel.addRay(point2D, angle);
        ray.setAngle(angle);

        for (int c = 0; c < polygon.lineSegments.size(); c++) {
            crossedPoints.add(crossingPointCramer(ray, new Line(polygon.lineSegments.get(c))));
        }

        for (int i = 0; i < polygon.lineSegments.size(); i++) {

            crossedPoint = crossedPoints.get(i);

            if (point2D.x < crossedPoint.x) {
                if (isCrossing(polygon.lineSegments.get(i), crossedPoint)) {
                    counter++;
                }
            }
        }

        System.out.println("The number of points encountered: " + SimulationPanel.foundPoints.size());

        if (counter != 0) {
            System.out.println("Found points:");
            for (int i = 0; i < counter; i++) {
                SimulationPanel.foundPoints.get(i).print();
            }
        }


        return counter % 2 != 0;
    }

    static void isInsideCircle(Circle C, LineSegment l) {

        double a = l.p1.x * l.p1.x + l.p1.y * l.p1.y + l.p2.x * l.p2.x + l.p2.y * l.p2.y - 2 * (l.p1.x * l.p2.x + l.p1.y * l.p2.y);
        double b = 2 * (C.o.x * (l.p2.x - l.p1.x) + C.o.y * (l.p2.y - l.p1.y) + l.p1.x * l.p2.x + l.p1.y * l.p2.y - l.p2.x * l.p2.x - l.p2.y * l.p2.y);
        double c = -(C.r * C.r) + l.p2.x * l.p2.x + l.p2.y * l.p2.y + C.o.x * C.o.x + C.o.y * C.o.y - 2 * (C.o.x * l.p2.x + C.o.y * l.p2.y);

        double delta = (b * b - 4 * a * c);

        Line tmpLine = new Line(l);

        if (delta > 0) {
            System.out.println("Two points of intersection.");

            /*double x1 = (-b + Math.sqrt(delta)) / 2 * a;
            SimulationPanel.addPoint2D(new Point2D((float)x1, (float)(tmpLine.a * x1 + tmpLine.b)));

            double x2 = (-b - Math.sqrt(delta)) / 2 * a;
            SimulationPanel.addPoint2D(new Point2D((float)x2, (float)(tmpLine.a * x2 + tmpLine.b)));*/

            for (float x = 0; x <= SimulationPanel.panelX; x += 0.025) {
                for (float y = 0; y <= SimulationPanel.panelY; y += 0.025) {

                    double equation = Math.pow((x - C.o.x), 2) + Math.pow((y - C.o.y), 2);

                    if (equation >= (Math.pow(C.r, 2) - 0.5) && equation < (Math.pow(C.r, 2)) + 0.5) {
                        if (y >= (tmpLine.a * x + tmpLine.b) - 0.3 && y <= (tmpLine.a * x + tmpLine.b) + 0.3)
                            SimulationPanel.addPoint2D(new Point2D(x, y));
                    }
                }
            }
        } else if (delta == 0) System.out.println("One point of intersection.");
        else if (delta < 0) System.out.println("Zero points of intersection.");
    }

    static void convexHull() {
        if (SimulationPanel.points.size() > 2) {
            List<Point2D> convexPoints = new ArrayList<>();
            Point2D rightest = SimulationPanel.points.get(0);
            for (int i = 1; i < SimulationPanel.points.size(); i++) {
                if (rightest.x < SimulationPanel.points.get(i).x) {
                    rightest = SimulationPanel.points.get(i);
                }
            }
            convexPoints.add(rightest);
            int i = 0;
            Random rand = new Random(System.currentTimeMillis());
            Point2D nextPoint;
            System.out.println("Your convex hull:");
            do {
                nextPoint = SimulationPanel.points.get(i % SimulationPanel.points.size());

                if (rightest.x == SimulationPanel.points.get(0).x && rightest.y == SimulationPanel.points.get(0).y)
                    nextPoint = SimulationPanel.points.get(1 + rand.nextInt(SimulationPanel.points.size() - 1));

                for (int j = 0; j < SimulationPanel.points.size(); j++) {

                    /*if (whichSide(SimulationPanel.points.get(j), new Line(new LineSegment(nextPoint, convexPoints.get(i)))) == 2) {
                        nextPoint = SimulationPanel.points.get(j);
                    }*/
                    if (onLeft(SimulationPanel.points.get(j), nextPoint, convexPoints.get(i)) == 2) {
                        nextPoint = SimulationPanel.points.get(j);
                    }
                }
                convexPoints.add(nextPoint);
                i++;
                LineSegment newLineSegment = new LineSegment(convexPoints.get(i - 1), convexPoints.get(i));
                SimulationPanel.addLineSegment(newLineSegment);
            } while ((nextPoint.x != convexPoints.get(0).x && nextPoint.y != convexPoints.get(0).y));
            for (int l = 0; l < convexPoints.size(); l++) {
                if(l > 0) {
                    if (convexPoints.get(l).x != convexPoints.get(l - 1).x && convexPoints.get(l).y != convexPoints.get(l - 1).y) {
                        convexPoints.get(l).print();
                    }
                }
            }
        } else System.err.println("Not enough points!");
    }
}
