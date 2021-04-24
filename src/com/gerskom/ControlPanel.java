package com.gerskom;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel{

    static JButton convexHull;

    static JButton rayRotation;
    static JButton linesIntersection;
    static JButton lineAdder;
    static JButton triangleAdder;

    static JButton pointAdder;
    static JButton pointRemover;

    static JButton pointToLineRelation;
    static JButton pointToTriangleRelation;
    static JButton pointToPolygonRelation;
    static JButton pointToCircleRelation;

    static JSlider coefficient;
    static JButton clearButton;

    ControlPanel(SimulationPanel simPanel) {

        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.weighty = 0;  gbc.weightx = 1;
        gbc.gridx = 0;      gbc.gridy = 0;
        pointAdder = new JButton("Add a Random Point");
        pointAdder.setBackground(new Color(52,52,52));
        pointAdder.setForeground(Color.LIGHT_GRAY);
        pointAdder.setBorderPainted(false);
        pointAdder.addActionListener(new InputHandler(simPanel));
        this.add(pointAdder, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx++;      gbc.gridy = 0;
        gbc.weighty = 0;  gbc.weightx = 1;
        pointRemover = new JButton("Remove a Point");
        pointRemover.setBackground(new Color(52,52,52));
        pointRemover.setForeground(Color.LIGHT_GRAY);
        pointRemover.setBorderPainted(false);
        pointRemover.addActionListener(new InputHandler(simPanel));
        this.add(pointRemover, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0.2;  gbc.weightx = 1;
        gbc.gridwidth = 2;
        convexHull = new JButton("Create convex hull");
        convexHull.setBackground(new Color(52,52,52));
        convexHull.setForeground(Color.LIGHT_GRAY);
        convexHull.setBorderPainted(false);
        convexHull.addActionListener(new InputHandler(simPanel));
        this.add(convexHull, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 1;
        rayRotation = new JButton("Rotation of the ray");
        rayRotation.setBackground(new Color(52,52,52));
        rayRotation.setForeground(Color.LIGHT_GRAY);
        rayRotation.setBorderPainted(false);
        rayRotation.addActionListener(new InputHandler(simPanel));
        this.add(rayRotation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        //this.add(new JLabel("a:"), gbc);
        gbc.gridx = 0;    gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 1;
        coefficient = new JSlider(-89, 89,0);
        coefficient.setBackground(new Color(52,52,52));
        coefficient.setForeground(Color.LIGHT_GRAY);
        coefficient.setPaintTicks(true);
        coefficient.setPaintLabels(true);
        coefficient.setMinorTickSpacing(10);
        coefficient.setMajorTickSpacing(89);
        coefficient.addChangeListener(new InputHandler(simPanel));
        this.add(coefficient, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;  gbc.weightx = 1;
        linesIntersection = new JButton("Intersection of random lines");
        linesIntersection.setBackground(new Color(52,52,52));
        linesIntersection.setForeground(Color.LIGHT_GRAY);
        linesIntersection.setBorderPainted(false);
        linesIntersection.addActionListener(new InputHandler(simPanel));
        this.add(linesIntersection, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 1;
        lineAdder = new JButton("Line from two random points");
        lineAdder.setBackground(new Color(52,52,52));
        lineAdder.setForeground(Color.LIGHT_GRAY);
        lineAdder.setBorderPainted(false);
        lineAdder.addActionListener(new InputHandler(simPanel));
        this.add(lineAdder, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;  gbc.weightx = 1;
        pointToLineRelation = new JButton("Point in relation to a line");
        pointToLineRelation.setBackground(new Color(52,52,52));
        pointToLineRelation.setForeground(Color.LIGHT_GRAY);
        pointToLineRelation.setBorderPainted(false);
        pointToLineRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToLineRelation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 1;
        gbc.gridwidth = 2;
        pointToTriangleRelation = new JButton("Point in relation to a triangle");
        pointToTriangleRelation.setBackground(new Color(52,52,52));
        pointToTriangleRelation.setForeground(Color.LIGHT_GRAY);
        pointToTriangleRelation.setBorderPainted(false);
        pointToTriangleRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToTriangleRelation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0.2;  gbc.weightx = 1;
        gbc.gridwidth = 2;
        triangleAdder = new JButton("Calculate area of the triangle");
        triangleAdder.setBackground(new Color(52,52,52));
        triangleAdder.setForeground(Color.LIGHT_GRAY);
        triangleAdder.setBorderPainted(false);
        triangleAdder.addActionListener(new InputHandler(simPanel));
        this.add(triangleAdder, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0;  gbc.weightx = 0;
        gbc.gridwidth = 2;
        pointToPolygonRelation = new JButton("Point in relation to a polygon");
        pointToPolygonRelation.setBackground(new Color(52,52,52));
        pointToPolygonRelation.setForeground(Color.LIGHT_GRAY);
        pointToPolygonRelation.setBorderPainted(false);
        pointToPolygonRelation.addActionListener(new InputHandler(simPanel));
        this.add(pointToPolygonRelation, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        //this.add(new JLabel("a:"), gbc);
        gbc.gridx = 0;    gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;  gbc.weightx = 1;
        coefficient = new JSlider(-89, 89,0);
        coefficient.setBackground(new Color(52,52,52));
        coefficient.setForeground(Color.LIGHT_GRAY);
        coefficient.setPaintTicks(true);
        coefficient.setPaintLabels(true);
        coefficient.setMinorTickSpacing(10);
        coefficient.setMajorTickSpacing(89);
        coefficient.addChangeListener(new InputHandler(simPanel));
        this.add(coefficient, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 8;      gbc.ipadx = 0;
        gbc.gridx = 0;      gbc.gridy++;
        gbc.weighty = 0.3;  gbc.weightx = 1;
        gbc.gridwidth = 2;
        clearButton = new JButton("Delete Everything");
        clearButton.setBackground(new Color(52,52,52));
        clearButton.setForeground(Color.LIGHT_GRAY);
        clearButton.setBorderPainted(false);
        clearButton.addActionListener(new InputHandler(simPanel));
        this.add(clearButton, gbc);
    }
}
