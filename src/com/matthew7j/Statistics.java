package com.matthew7j;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;
import java.util.ArrayList;

public class Statistics extends ApplicationFrame
{
    ArrayList<Person> players = new ArrayList<Person>();

    public Statistics(final String title, ArrayList<Person> players){
        super(title);

        this.players = players;
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(500,500));
        setContentPane(chartPanel);
    }

    private XYDataset createDataset(){
        final XYSeriesCollection dataset = new XYSeriesCollection();

        for (Person p : players){
            if (p instanceof Player) {
                final XYSeries series = new XYSeries(p.name);
                dataset.addSeries(series);
            }
        }
        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset){
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "BlackJack Statistics",
                "Hand Number",
                "Chips",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.BLACK);

        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.BLACK);

        plot.setDomainGridlinePaint(Color.green);
        plot.setRangeGridlinePaint(Color.green);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        return chart;
    }

}
