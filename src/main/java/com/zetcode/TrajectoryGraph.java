package com.zetcode;
//import org.jfree.data.general.DatasetUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
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

public class TrajectoryGraph extends JFrame {

    

    public static void main(String[] args) {
        TrajectoryMath test = new TrajectoryMath(10, 30, 40);
        //System.out.println(test.getEquation());
        //XYDataset dataset = DatasetUtilities.sampleFunction2D(test, 1.0, 5.0, 50, "Function");
        //final JFreeChart chart = ChartFactory.createXYLineChart("Equation", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);
    }
}