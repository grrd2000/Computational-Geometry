package com.gerskom;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandler implements ActionListener, ChangeListener {

    SimulationPanel simulationPanel;
    public static int option = 0;

    public InputHandler(SimulationPanel simulationPanel) {
        this.simulationPanel = simulationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*if(e.getSource() == ControlPanel.lineAdder) {
            System.out.print("Line added!  ");
            simulationPanel.addLine();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.lineSegmentRemover) {
            simulationPanel.removeLineSegment();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.triangleAdder) {
            System.out.println("Triangle added!");
            simulationPanel.addTriangle();
            simulationPanel.repaint();
        }*/

        if(e.getSource() == ControlPanel.pointAdder) {
            //System.out.println("Point added!");
            simulationPanel.addPoint2D();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.pointRemover) {
            SimulationPanel.removePoint2D();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.rayRotation) {
            option = 2;
            simulationPanel.clearPanel();
            SimulationPanel.addRay(SimulationPanel.addPoint2D(new Point2D((float)(SimulationPanel.panelX / 2 - 200), (float)(SimulationPanel.panelY / 2 - 50))), 0);
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.linesIntersection) {
            simulationPanel.clearPanel();
            simulationPanel.twoLinesIntersection();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.lineAdder) {
            simulationPanel.clearPanel();
            simulationPanel.addLineFromTwoRandomPoints();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.pointToLineRelation) {
            simulationPanel.clearPanel();
            simulationPanel.pointToLine();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.pointToTriangleRelation) {
            simulationPanel.clearPanel();
            simulationPanel.pointToTriangle();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.triangleAdder) {
            simulationPanel.clearPanel();
            simulationPanel.triangleArea();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.pointToPolygonRelation) {
            option = 1;
            simulationPanel.clearPanel();
            simulationPanel.pointToPolygon();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.pointToCircleRelation) {
            simulationPanel.clearPanel();
            simulationPanel.pointToCircle();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.convexHull) {
            {SimulationPanel.lineSegments.clear();
            SimulationPanel.foundPoints.clear();
            SimulationPanel.lines.clear();
            SimulationPanel.rays.clear();
            SimulationPanel.triangles.clear();
            SimulationPanel.polygons.clear();
            SimulationPanel.circles.clear();}
            simulationPanel.convexHull();
            simulationPanel.repaint();
        }

        if(e.getSource() == ControlPanel.clearButton) {
            simulationPanel.clearPanel();
            simulationPanel.repaint();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        JSlider source = (JSlider)e.getSource();
        int angle = source.getValue();

        SimulationPanel.rays.clear();
        SimulationPanel.foundPoints.clear();
        System.out.println("-----------------------------");
        //System.out.println(option);
        if(option == 1) {
            if (Operation.isInsidePolygon(SimulationPanel.polygons.get(0), SimulationPanel.points.get(SimulationPanel.points.size() - 1), angle)) {
                System.out.println("~INSIDE~");

            } else {
                System.out.println("~OUTSIDE~");
            }
        }
        else if(option == 2) {
            Point2D middlePoint = new Point2D((float)SimulationPanel.panelX / 2 - 200, (float)SimulationPanel.panelY / 2 - 50);
            SimulationPanel.addPoint2D(middlePoint);
            SimulationPanel.addRay(middlePoint, angle);
        }
    }
}
