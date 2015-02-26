package com.matthew7j;

import javafx.scene.chart.CategoryAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

public class PlayerLostPercentageLineGraph extends ApplicationFrame
{
    private ArrayList<Person> players = new ArrayList<Person>();
    private int handNum;
    private CategoryDataset dataset;

    public PlayerLostPercentageLineGraph(final String title, ArrayList<Person> players, int handNum){
        super(title);

        this.players = players;
        this.handNum = handNum;

        this.dataset = createDataset();
    }

    private CategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Person p : players){
            if (p instanceof Player) {
                double num = ((Player) p).getPercentageHandsLost();
                dataset.addValue((Number)num, p.name, handNum);
            }
        }
        return dataset;
    }

    private JFreeChart createChart(){
        final JFreeChart chart = ChartFactory.createLineChart(
                "BlackJack PlayerChipLineGraph",
                "Hand Number",
                "Percentage of hands won",
                this.dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.BLACK);

        final CategoryPlot  plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.BLACK);

        plot.setDomainGridlinePaint(Color.green);
        plot.setRangeGridlinePaint(Color.green);

        plot.getDomainAxis().setLabelPaint(Color.orange);
        plot.getRangeAxis().setLabelPaint(Color.orange);
        plot.getDomainAxis().setTickLabelPaint(Color.orange);
        plot.getRangeAxis().setTickLabelPaint(Color.orange);
        plot.getDomainAxis().setTickMarkPaint(Color.orange);
        plot.getRangeAxis().setTickMarkPaint(Color.orange);

        plot.setRangeGridlinePaint(Color.cyan);
        plot.setDomainGridlinePaint(Color.cyan);
        plot.setDomainGridlinesVisible(true);

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);



        return chart;
    }
    public void addData(ArrayList<Person> players, int handNum){
        DefaultCategoryDataset datasetTemp = (DefaultCategoryDataset)this.dataset;
        for (Person p : players){
            if (p instanceof Player) {
                datasetTemp.addValue((Number) ((Player) p).getPercentageHandsLost(), p.name, handNum);
            }
        }
        this.dataset = datasetTemp;
    }

    public void composeGraph(){
        final JFreeChart chart = createChart();
        final ChartPanel chartPanel = new ChartPanel(chart);

        final CategoryPlot  plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.BLACK);

        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesLinesVisible(0, true);
        plot.setRenderer(renderer);

        chartPanel.setPreferredSize(new java.awt.Dimension(500,500));
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }

}
