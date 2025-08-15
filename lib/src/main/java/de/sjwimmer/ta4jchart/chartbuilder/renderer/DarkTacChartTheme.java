package de.sjwimmer.ta4jchart.chartbuilder.renderer;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

import static org.jfree.chart.StandardChartTheme.createDarknessTheme;

public class DarkTacChartTheme implements TacChartTheme {

    public DarkTacChartTheme() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void apply(JFreeChart chart) {
        ChartTheme darknessTheme = createDarknessTheme();
        darknessTheme.apply(chart);
        chart.setBorderVisible(false);
        chart.setBackgroundPaint(new Color(0x1E1E1E));
        chart.getLegend().setBackgroundPaint(new Color(0x1E1E1E));
        applyChart(chart);
    }
}
