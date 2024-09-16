package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.awt.Color;

public class SalesPurchaseChart extends ApplicationFrame {

    public SalesPurchaseChart(String title) {
        super(title);
        JFreeChart barChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        setContentPane(chartPanel);
    }

    // Create dataset for sales and purchases
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add sales data (positive values)
        dataset.addValue(100, "Sales", "Jan");
        dataset.addValue(200, "Sales", "Feb");
        dataset.addValue(300, "Sales", "Mar");
        dataset.addValue(150, "Sales", "Apr");
        dataset.addValue(180, "Sales", "May");
        dataset.addValue(230, "Sales", "Jun");
        dataset.addValue(280, "Sales", "Jul");
        dataset.addValue(310, "Sales", "Aug");
        dataset.addValue(120, "Sales", "Sep");

        // Add purchase data (negative values)
        dataset.addValue(-100, "Purchase", "Jan");
        dataset.addValue(-150, "Purchase", "Feb");
        dataset.addValue(-200, "Purchase", "Mar");
        dataset.addValue(-50, "Purchase", "Apr");
        dataset.addValue(-100, "Purchase", "May");
        dataset.addValue(-50, "Purchase", "Jun");
        dataset.addValue(-150, "Purchase", "Jul");
        dataset.addValue(-200, "Purchase", "Aug");
        dataset.addValue(-90, "Purchase", "Sep");

        return dataset;
    }

    // Create the bar chart
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Purchase & Sales",
                "Month", // X-axis Label
                "Amount", // Y-axis Label
                dataset,
                PlotOrientation.VERTICAL,
                true, // Show Legend
                true, // Use tooltips
                false // Configure chart to generate URLs
        );

        // Customize the bar colors for positive (Sales) and negative (Purchase) values
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        renderer.setSeriesPaint(0, Color.GREEN);  // Sales bar color
        renderer.setSeriesPaint(1, Color.RED);    // Purchase bar color

        return barChart;
    }

    public static void main(String[] args) {
        
    }
}
