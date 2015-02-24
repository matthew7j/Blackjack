package com.matthew7j;

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
import java.util.ArrayList;

public class Statistics extends ApplicationFrame
{
    private ArrayList<Person> players = new ArrayList<Person>();
    private int handNum;
    private CategoryDataset dataset;

    public Statistics(final String title, ArrayList<Person> players, int handNum){
        super(title);

        this.players = players;
        this.handNum = handNum;

        this.dataset = createDataset();

    }

    private CategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Person p : players){
            if (p instanceof Player) {
                dataset.addValue((Number)((Player) p).getChips(), p.name, handNum);
            }
        }
        return dataset;
    }

    private JFreeChart createChart(){
        final JFreeChart chart = ChartFactory.createLineChart(
                "BlackJack Statistics",
                "Hand Number",
                "Chips",
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

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        return chart;
    }
    public void addData(ArrayList<Person> players, int handNum){
        DefaultCategoryDataset datasetTemp = (DefaultCategoryDataset)this.dataset;
        for (Person p : players){
            if (p instanceof Player) {
                datasetTemp.addValue((Number) ((Player) p).getChips(), p.name, handNum);
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
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        chartPanel.setPreferredSize(new java.awt.Dimension(500,500));
        setContentPane(chartPanel);
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }

}
