package com.hacks.trajectoryCalculator;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

import com.hacks.trajectoryCalculator.*;

import javax.swing.JFrame;
import java.awt.Dimension;

public class TrajectoryGraph extends JFrame {
    public double currentHeight;
    public TrajectoryGraph() {
        InputInitial newInputs = new InputInitial();
        newInputs.spawnInputs();
       drawGraph(InputInitial.initialVelocity, InputInitial.initialDegrees, InputInitial.initialHeight);
    }

    public void drawGraph(double velocity, double degrees, double height) {
        Function2D test = new TrajectoryMath(velocity, degrees, height);
        TrajectoryMath testGetter = new TrajectoryMath(velocity, degrees, height);
        XYDataset dataset = DatasetUtils.sampleFunction2D(test, 0.0, testGetter.getRoot(), 50, "Function");
        final JFreeChart chart = ChartFactory.createXYLineChart("Trajectory Equation", "Time (seconds)", "Position (meters)", dataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel cp = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        cp.setMouseWheelEnabled(true);
        add(cp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    public static void main(String[] args) {
    

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrajectoryGraph().setVisible(true);
            }
        });
        
    }
}