package org.zkoss.zkcharts.essentials.model;

import org.zkoss.chart.*;
import org.zkoss.chart.plotOptions.SplinePlotOptions;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

import java.text.*;
import java.util.*;

public class SplinePlotBandsComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        chart.getXAxis().setType("datetime");
        chart.getXAxis().getLabels().setOverflow("justify");

        YAxis yAxis = chart.getYAxis();
        yAxis.setTitle("Wind speed (m/s)");
        yAxis.setMinorGridLineWidth(0);
        yAxis.setGridLineWidth(0);
        yAxis.setAlternateGridColor((String) null);

        final String LABEL_STYLE = "color: '#606060'";

        // Light air
        PlotBand plotBand1 = new PlotBand(0.3, 1.5, "rgba(68, 170, 213, 0.1)");
        plotBand1.getLabel().setText("Light air");
        plotBand1.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand1);

        // Light breeze
        PlotBand plotBand2 = new PlotBand(1.5, 3.3, "rgba(0, 0, 0, 0)");
        plotBand2.getLabel().setText("Light breeze");
        plotBand2.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand2);

        // Gentle breeze
        PlotBand plotBand3 = new PlotBand(3.3, 5.5, "rgba(68, 170, 213, 0.1)");
        plotBand3.getLabel().setText("Gentle breeze");
        plotBand3.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand3);

        // Moderate breeze
        PlotBand plotBand4 = new PlotBand(5.5, 8, "rgba(0, 0, 0, 0)");
        plotBand4.getLabel().setText("Moderate breeze");
        plotBand4.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand4);

        // Fresh breeze
        PlotBand plotBand5 = new PlotBand(8, 11, "rgba(68, 170, 213, 0.1)");
        plotBand5.getLabel().setText("Fresh breeze");
        plotBand5.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand5);

        // Strong breeze
        PlotBand plotBand6 = new PlotBand(11, 14, "rgba(0, 0, 0, 0)");
        plotBand6.getLabel().setText("Strong breeze");
        plotBand6.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand6);

        // High wind
        PlotBand plotBand7 = new PlotBand(14, 15, "rgba(68, 170, 213, 0.1)");
        plotBand7.getLabel().setText("High wind");
        plotBand7.getLabel().setStyle(LABEL_STYLE);
        yAxis.addPlotBand(plotBand7);

        chart.getTooltip().setValueSuffix(" m/s");

        SplinePlotOptions spline = chart.getPlotOptions().getSpline();
        spline.setLineWidth(4);
        spline.getStates().getHover().setLineWidth(5);
        spline.getMarker().setEnabled(false);
        spline.setPointInterval(3600000); // One hour
        spline.setPointStart(parse("10-06-2009", "UTC"));

        Series series1 = chart.getSeries();
        series1.setName("Hestavollane");
        series1.setData(4.3, 5.1, 4.3, 5.2, 5.4, 4.7, 3.5, 4.1, 5.6, 7.4, 6.9,
                7.1, 7.9, 7.9, 7.5, 6.7, 7.7, 7.7, 7.4, 7.0, 7.1, 5.8, 5.9, 7.4,
                8.2, 8.5, 9.4, 8.1, 10.9, 10.4, 10.9, 12.4, 12.1, 9.5, 7.5, 7.1,
                7.5, 8.1, 6.8, 3.4, 2.1, 1.9, 2.8, 2.9, 1.3, 4.4, 4.2, 3.0, 3.0);

        Series series2 = chart.getSeries(1);
        series2.setName("Voll");
        series2.setData(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.3,
                0.0, 0.0, 0.4, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.6, 1.2, 1.7, 0.7, 2.9, 4.1, 2.6, 3.7, 3.9, 1.7, 2.3, 3.0,
                3.3, 4.8, 5.0, 4.8, 5.0, 3.2, 2.0, 0.9, 0.4, 0.3, 0.5, 0.4);
        chart.getNavigation().setMenuItemStyle("fontSize: '10px'");
    }

    private long parse(String date, String timeZone) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        try {
            format.setTimeZone(TimeZone.getTimeZone(timeZone));
            calendar.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }
}