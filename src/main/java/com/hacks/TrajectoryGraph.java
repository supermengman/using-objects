package com.hacks;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.math.TrajectoryMath;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.awt.Dimension;

public class TrajectoryGraph extends JFrame {
    public double currentHeight;
    public TrajectoryGraph() {
        Function2D test = new TrajectoryMath(10, 30, 40);
        XYDataset dataset = DatasetUtils.sampleFunction2D(test, 0.0, 100.0, 50, "Function");
        final JFreeChart chart = ChartFactory.createXYLineChart("Equation", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
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