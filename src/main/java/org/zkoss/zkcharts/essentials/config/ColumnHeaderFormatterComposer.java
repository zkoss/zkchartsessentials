package org.zkoss.zkcharts.essentials.config;

import org.zkoss.chart.*;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.json.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class ColumnHeaderFormatterComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        chart.getXAxis().setCategories("Jan", "Feb", "Mar", "Apr", "May",
                "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        // Primary y Axis
        YAxis yAxis1 = chart.getYAxis();
        yAxis1.getLabels().setFormat("{value}°C");
        yAxis1.setTitle("Temperature");

        // Secondary y Axis
        YAxis yAxis2 = chart.getYAxis(1);
        yAxis2.setTitle("Rainfall");
        yAxis2.getLabels().setFormat("{value} mm");
        yAxis2.setOpposite(true);
        setYAxisesColor();

        chart.getTooltip().setShared(true);


        Series series = chart.getSeries();
        series.setName("Rainfall error");
        series.setType("errorbar");
        series.setYAxis(1);
        series.addPoint(48, 51);
        series.addPoint(68, 73);
        series.addPoint(92, 110);
        series.addPoint(128, 136);
        series.addPoint(140, 150);
        series.addPoint(171, 179);
        series.addPoint(135, 143);
        series.addPoint(142, 149);
        series.addPoint(204, 220);
        series.addPoint(189, 199);
        series.addPoint(95, 110);
        series.addPoint(52, 56);
        series.getPlotOptions().getTooltip().setPointFormat(
                "(error range: {point.low}-{point.high} mm)<br/>");

        chart.addEventListener(0, ChartsEvents.ON_PLOT_THEME_CHANGE, new EventListener() {
            public void onEvent(Event event) throws Exception {
                setYAxisesColor();
            }
        });


        setupColumnHeader();
    }

    /**
     * change column header of a data table.
     * https://api.highcharts.com/highcharts/exporting.csv.columnHeaderFormatter
     * https://jsfiddle.net/gh/get/library/pure/highcharts/highcharts/tree/master/samples/highcharts/export-data/multilevel-table
     */
    private void setupColumnHeader() {
        JSONObject headerFormatter = new JSONObject();
        headerFormatter.put("columnHeaderFormatter", new JavaScriptValue("function (item, key) {\n" +
                "                if (!item || item instanceof Highcharts.Axis) {\n" +
                "                    return item.options.title.text;\n" +
                "                }\n" +
                "                // Item is not axis, now we are working with series.\n" +
                "                // Key is the property on the series we show in this column.\n" +
                "                if (key == 'low') {colTitle = 'Baja'} \n" +
                "                else if (key =='high') {colTitle = 'Alto' } \n" +
                "                else {colTitle = key}\n" +
                "                return {\n" +
                "                    topLevelColumnTitle: item.name,\n" +
                "                    columnTitle: colTitle\n" +
                "                };\n" +
                "            }"));
        chart.getExporting().addExtraAttr("csv", headerFormatter);
        chart.getExporting().addExtraAttr("showTable", new AnyVal<Boolean>(true));
    }

    private void setYAxisesColor() {
        YAxis yAxis1 = chart.getYAxis();
        YAxis yAxis2 = chart.getYAxis(1);
        String color1 = chart.getColors().get(0).stringValue();
        String color2 = chart.getColors().get(1).stringValue();
        yAxis1.getLabels().setStyle("color: '" + color2 + "'");
        yAxis1.getTitle().setStyle("color: '" + color2 + "'");
        yAxis2.getLabels().setStyle("color: '" + color1 + "'");
        yAxis2.getTitle().setStyle("color: '" + color1 + "'");
    }
}