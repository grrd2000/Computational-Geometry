package com.gerskom;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{

    static JButton rayRotation;
    static JButton linesIntersection;
    static JButton lineAdder;

    static JButton pointAdder;
    static JButton pointRemover;
    static JButton triangleAdder;

    static JButton clearButton;

    static JButton pointToLineRelation;
    static JButton pointToTriangleRelation;
    static JButton pointToPolygonRelation;
    static JButton pointToCircleRelation;

    static JButton convexHull;

    static JSlider coefficient = new JSlider();

    ControlPanel(SimulationPanel simPanel) {

        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.weighty = 0.5;  gbc.weightx = 0;
        gbc.gridx = 0;      gbc.gridy = 0;
        pointAdder = new JButton("Add a Random Point");
        pointAdder.addActionListener(new InputHandler(simPanel));
        this.add(pointAdder, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx++;      gbc.gridy = 0;
        gbc.weighty = 0;  gbc.weightx = 0;
        pointRemover = new JButton("Remove a Point");
        pointRemover.addActionListener(new InputHandler(simPanel));
        this.add(pointRemover, gbc);

        /*gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        lineAdder = new JButton("Add a Random Line");
        lineAdder.addActionListener(new InputHandler(simPanel));
        this.add(lineAdder, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx++;      gbc.gridy = 1;
        gbc.weighty = 0;  gbc.weightx = 0;
        lineSegmentRemover = new JButton("Remove a Line");
        lineSegmentRemover.addActionListener(new InputHandler(simPanel));
        this.add(lineSegmentRemover, gbc);*/

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 0;
        rayRotation = new JButton("Rotation of the ray");
        rayRotation.addActionListener(new InputHandler(simPanel));
        this.add(rayRotation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 0;
        linesIntersection = new JButton("Intersection of random lines");
        linesIntersection.addActionListener(new InputHandler(simPanel));
        this.add(linesIntersection, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 0;
        lineAdder = new JButton("Line from two random points");
        lineAdder.addActionListener(new InputHandler(simPanel));
        this.add(lineAdder, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 0;
        pointToLineRelation = new JButton("Point in relation to a line");
        pointToLineRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToLineRelation, gbc);

        /*gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy = 3;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 1;
        triangleAdder = new JButton("Add a Random Triangle");
        triangleAdder.addActionListener(new InputHandler(simPanel));
        this.add(triangleAdder, gbc);*/

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 2;
        pointToTriangleRelation = new JButton("Point in relation to a triangle");
        pointToTriangleRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToTriangleRelation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 2;
        pointToPolygonRelation = new JButton("Point in relation to a polygon");
        pointToPolygonRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToPolygonRelation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        //this.add(new JLabel("a:"), gbc);
        gbc.gridx = 0;    gbc.gridy++;
        gbc.gridwidth = 2;
        //gbc.weightx = ;
        coefficient = new JSlider(-89, 89,0);
        coefficient.addChangeListener(new InputHandler(simPanel));
        this.add(coefficient, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 2;
        pointToCircleRelation = new JButton("Point in relation to a circle");
        pointToCircleRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToCircleRelation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 2;
        convexHull = new JButton("Create convex hull");
        convexHull.addActionListener(new InputHandler(simPanel));
        this.add(convexHull, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 2;
        clearButton = new JButton("Delete Everything");
        clearButton.addActionListener(new InputHandler(simPanel));
        this.add(clearButton, gbc);

        //this.addMouseListener(simPanel);
    }
}
