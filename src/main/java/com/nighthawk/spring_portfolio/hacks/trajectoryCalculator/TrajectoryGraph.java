package com.nighthawk.spring_portfolio.hacks.trajectoryCalculator; // maven build

// import the graphs
import org.jfree.data.function.Function2D;
import org.jfree.data.general.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

import com.nighthawk.spring_portfolio.hacks.trajectoryCalculator.*;

// import swing and awt
import javax.swing.JFrame;
import java.awt.Dimension;

public class TrajectoryGraph extends JFrame {
    // Constructor of the graph that will be displayed
    public TrajectoryGraph() {
        InputInitial newInputs = new InputInitial(); // start input object from separate file,
        newInputs.spawnInputs(); // start the process of collecting user input
       drawGraph(InputInitial.initialVelocity, InputInitial.initialDegrees, InputInitial.initialHeight); // call method to draw the graph with the user input taken
    }

    // graph drawer
    public void drawGraph(double velocity, double degrees, double height) {
        Function2D test = new TrajectoryMath(velocity, degrees, height); // TrajectoryMath implements function2d, so use those values create new function2d object
        TrajectoryMath testGetter = new TrajectoryMath(velocity, degrees, height); // creates TrajectoryMath object from the other file to call custom methods
        XYDataset dataset = DatasetUtils.sampleFunction2D(test, 0.0, testGetter.getRoot(), 50, "Function"); // generates the dataset of xy values with the function
        final JFreeChart chart = ChartFactory.createXYLineChart("Trajectory Equation", "X Position (meters)", "Y Position (meters)", dataset, PlotOrientation.VERTICAL, true, true, false); // creates the actual graph with attributes
        
        // initializing the display
        ChartPanel cp = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 500); // set initial dimension
            }
        };

        // allow mouse wheel scrolling
        cp.setMouseWheelEnabled(true);
        add(cp);

        // Finalize the building of the graph
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
    
        // runs the creation of the graph with a queue in a different thread and posts the gui after events are processed
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // initialize new TrajectoryGraph object, setvisible to display the graph
                new TrajectoryGraph().setVisible(true);
            }
        });
        
    }
}