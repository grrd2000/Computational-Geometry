package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel implements MouseListener {

    static List<Point2D> points = new ArrayList<>();
    static List<Point2D> foundPoints = new ArrayList<>();
    static List<LineSegment> lineSegments = new ArrayList<>();
    static List<Line> lines = new ArrayList<>();
    static List<Ray> rays = new ArrayList<>();
    static List<Triangle> triangles = new ArrayList<>();
    static List<PolygonHandler> polygons = new ArrayList<>();
    static List<Circle> circles = new ArrayList<>();

    int maxVertices = 5;

    int option = 0;

    static public int panelX = 930;
    static public int panelY = 620;

    public SimulationPanel () {
        super();
        this.addMouseListener(this);
        Timer timer = new Timer(10, e -> {
            for (Ray ray : rays) {
                ray.setAngle(ControlPanel.coefficient.getValue());
            }
            repaint();
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        for (PolygonHandler polygon : polygons) {
            polygon.paintComponent(g2D);
        }

        for (Circle circle : circles) {
            circle.paintComponent(g2D);
        }

        for (Triangle triangle : triangles) {
            triangle.paintComponent(g2D);
        }

        for (Line line : lines) {
            line.paintComponent(g2D);
        }

        for (Ray ray : rays) {
            ray.paintComponent(g2D);
        }

        for (LineSegment lineSegment : lineSegments) {
            lineSegment.paintComponent(g2D);
        }

        for (Point2D point2D : points) {
            point2D.paintComponent(g2D);
        }

        for (Point2D point2D : foundPoints) {
            point2D.paintComponent(g2D);
        }

        g2D.dispose();
    }

    public void clearPanel() {
        lineSegments.clear();
        foundPoints.clear();
        points.clear();
        triangles.clear();
        polygons.clear();
        lines.clear();
        rays.clear();
        circles.clear();
        option = 0;
        //System.out.println("\n\n\n\n\n\n\n~CLEAR!~\n\n\n");
    }

    public Point2D addPoint2D() {

        Point2D point2D = new Point2D();
        //Point2D point2D = new Point2D(150,150);
        points.add(point2D);
        point2D.print();
        return point2D;
    }

    public static Point2D addPoint2D(Point2D point2D) {

        points.add(point2D);
        //point2D.print();
        return point2D;
    }

    static void removePoint2D() {

        if(points.size() > 0) points.remove(points.size() - 1);
        else System.err.println("No points to remove!");
    }

    /*public LineSegment addLineSegment() {

        Point2D p1 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        Point2D p2 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        //Point2D p1 = new Point2D(0,0);
        //Point2D p2 = new Point2D(400,400);

        if(new Vector2D(p1,p2).length < minLineSegmentLength) {
            float resize = 1.5f;
            Operation translation = new Operation();
            Vector2D vector2D = new Vector2D(p1, p2);
            Vector2D newVector = new Vector2D(vector2D.x * resize, vector2D.y * resize);
            p2 = translation.PointTranslation(newVector, p2);

            if(p2.x > panelX) p2.x = panelX - 5;
            if(p2.y > panelY) p2.y = panelY - 5;
            if(p2.x > panelX && p2.y > p2.y) {
                p2.x = panelX - 5;
                p2.y = panelY - 5;
            }
            if(p2.x < 0) p2.x = 5;
            if(p2.y < 0) p2.y = 5;
            if(p2.x < 0 && p2.y > 0) {
                p2.x = 5;
                p2.y = 5;
            }

            vector2D = new Vector2D(p2, p1);
            if(vector2D.length < minLineSegmentLength) {
                newVector = new Vector2D(vector2D.x * resize, vector2D.y * resize);
                p1 = translation.PointTranslation(newVector, p1);

                if (p1.x > panelX) p1.x = panelX - 5;
                if (p1.y > panelY) p1.y = panelY - 5;
                if (p1.x > panelX && p1.y > p1.y) {
                    p1.x = panelX - 5;
                    p1.y = panelY - 5;
                }
                if (p1.x < 0) p1.x = 5;
                if (p1.y < 0) p1.y = 5;
                if (p1.x < 0 && p1.y > 0) {
                    p1.x = 5;
                    p1.y = 5;
                }
            }
        }
        LineSegment lineSegment = new LineSegment(p1, p2);
        lineSegments.add(lineSegment);
        addPoint2D(p1);     addPoint2D(p2);
        return lineSegment;
    }*/

    public static LineSegment addLineSegment(LineSegment lineSegment) {

        lineSegments.add(lineSegment);
        return lineSegment;
    }

    public static void addLineSegment() {

        LineSegment lineSegment = new LineSegment();
        lineSegments.add(lineSegment);
        addPoint2D(lineSegment.p1);
        addPoint2D(lineSegment.p2);
    }

    public void addLineFromTwoRandomPoints() {
        System.out.println("-----------------------------");
        Point2D p1 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        Point2D p2 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);

        Line line = new Line(p1, p2);
        lines.add(line);
        points.add(p1); points.add(p2);
        p1.print();     p2.print();
        line.print();
    }

    public Line addLine() {
        Point2D p1 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        Point2D p2 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        //Point2D p1 = new Point2D(0,0);
        //Point2D p2 = new Point2D(400,400);

        Line line = new Line(p1, p2);
        //Line line = new Line(2, 0);
        lines.add(line);
        line.print();
        return line;
    }

    public void addLine(LineSegment lineSegment) {
        Line line = new Line(lineSegment);
        lines.add(line);
        line.print();
    }

    /*public Line addLine(Point2D point2D) {

        Point2D p2 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        //Point2D p1 = new Point2D(0,0);
        //Point2D p2 = new Point2D(400,400);

        Line line = new Line(point2D, p2);
        //Line line = new Line((float)Math.tan(-135 * Math.PI / 180), 0);
        lines.add(line);
        return line;
    }*/

    /*public Ray addRay() {

        //Point2D p2 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        Point2D p2 = new Point2D((float)panelX/2,(float)panelY/2);

        Ray ray = new Ray(p2, 0);
        rays.add(ray);
        return ray;
    }*/

    static Ray addRay(Point2D p1, float angle) {

        Ray ray = new Ray(p1, angle);
        rays.add(ray);
        return ray;
    }

    public Triangle addTriangle() {

        Point2D p1 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        Point2D p2 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
        Point2D p3 = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);

        Triangle triangle = new Triangle(p1, p2, p3);
        //Triangle triangle = new Triangle(new Point2D(100,100), new Point2D(100,200), new Point2D(200,150));
        triangles.add(triangle);
        addPoint2D(p1);     addPoint2D(p2);     addPoint2D(p3);
        return triangle;
    }

    public PolygonHandler addPolygon() {

        int v = (int)(Math.random() * maxVertices + 3);
        //int v = 3;
        //int[] xPoints = new int[v];
        int[] xPoints = new int[v];
        //int[] yPoints = new int[v];
        int[] yPoints = new int[v];

        for(int i = 0; i < v; i++) {
            Point2D randPoint = new Point2D((float)Math.random() * panelX, (float)Math.random() * panelY);
            xPoints[i] = (int)randPoint.x;
            yPoints[i] = (int)randPoint.y;
            points.add(randPoint);
        }

        PolygonHandler polygon = new PolygonHandler(xPoints, yPoints, v);
        //PolygonHandler polygon = new PolygonHandler(new int[] {100, 200, 300}, new int[] {100, 200, 300}, 3);
        polygons.add(polygon);

        return polygon;
    }

    public Circle addCircle() {
        //Circle circle = new Circle(new Point2D());
        Circle circle = new Circle(300,300);

        circles.add(circle);
        circle.print();

        return circle;
    }

    public void twoLinesIntersection() {
        System.out.println("-----------------------------");
        Line line1 = addLine();
        Line line2 = addLine();
        addPoint2D(Operation.crossingPointCramer(line1, line2)).print();
    }

    public void pointToLine() {
        System.out.println("-----------------------------");
        Line line = addLine();
        Operation.whichSide(addPoint2D(), line);
    }

    public void pointToTriangle() {
        System.out.println("-----------------------------");
        Triangle triangle = new Triangle(addTriangle());
        if(new Operation().isInsideTriangle(triangle, addPoint2D()))
            System.out.println("This point is inside the triangle.");
        else System.out.println("This point isn't inside of the triangle.");
    }

    public void triangleArea() {
        System.out.println("-----------------------------");
        Triangle triangle = new Triangle(addTriangle());
        System.out.println("Area of the triangle:\t" + triangle.Area());
    }

    public void pointToPolygon() {
        option = 1;
        System.out.println("-----------------------------");
        PolygonHandler polygon = new PolygonHandler(addPolygon());
        Point2D point2D = addPoint2D();
        if(Operation.isInsidePolygon(polygon, point2D, 0)) {
            System.out.println("~INSIDE~");
        }
        else System.out.println("~OUTSIDE~");
    }

    public void pointToCircle() {
        System.out.println("-----------------------------");
        Circle circle = addCircle();
        LineSegment lineSegment = addLineSegment(new LineSegment(new Point2D(20,20), new Point2D()));
        //LineSegment lineSegment = addLineSegment(new LineSegment(new Point2D(310,310), new Point2D(10, 10)));
        //LineSegment lineSegment = addLineSegment(new LineSegment(new Point2D(-1,-2), new Point2D(2,4)));
        Operation.isInsideCircle(circle, lineSegment);
        addLine(lineSegment);
    }

    public void convexHull() {
        option = 2;
        System.out.println("-----------------------------");
        Operation.convexHull();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = getMousePosition().x;
        int y = getMousePosition().y;

        if(option == 1) {
            Point2D newPoint = new Point2D(x, y);
            points.remove(points.size() - 1);
            rays.clear();
            foundPoints.clear();
            System.out.println("-----------------------------");
            addPoint2D(newPoint);
            if (Operation.isInsidePolygon(polygons.get(0), newPoint, 0)) {
                System.out.println("~INSIDE~");
            } else System.out.println("~OUTSIDE~");
            repaint();
        }

        else if (option  == 2 || option == 0) {

            Point2D newPoint = new Point2D(x, y);
            addPoint2D(newPoint);

            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
