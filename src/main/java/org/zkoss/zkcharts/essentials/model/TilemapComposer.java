package org.zkoss.zkcharts.essentials.model;

import org.zkoss.chart.*;
import org.zkoss.chart.plotOptions.DataLabels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

import java.util.HashMap;

public class TilemapComposer extends SelectorComposer<Component> {
    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        chart.setType(Charts.TILEMAP);
        chart.setInverted(true);
        chart.setHeight("80%");

        chart.getTitle().setText("U.S. states by population in 2016");
        chart.getSubtitle().setText("Source:<a href=\"https://simple.wikipedia.org/wiki/List_of_U.S._states_by_population\">Wikipedia</a>");
        chart.getXAxis().setVisible(false);
        chart.getYAxis().setVisible(false);

        ColorAxis ca = chart.getColorAxis();
        ca.setDataClasses(
                initDataClass("< 1M", 0, 1000000, "#F9EDB3"),
                initDataClass("1M - 5M", 1000000, 5000000, "#FFC428"),
                initDataClass("5M - 20M", 5000000, 20000000, "#FF7987"),
                initDataClass("> 20M", 20000000, null, "#FF2371")
        );

        Tooltip tooltip = chart.getTooltip();
        tooltip.setHeaderFormat("");
        tooltip.setPointFormat("The population of <b> {point.name}</b> is <b>{point.value}</b>");
        DataLabels labels = chart.getPlotOptions().getSeries().getDataLabels();
        labels.setEnabled(true);
        labels.setFormat("{point.label}");
        labels.setUseHTML(true);

        Series series = chart.getSeries();
        series.setName("");
        series.setData(TilemapData.getData());
    }

    private DataClass initDataClass(String name, Number from, Number to, String color) {
        DataClass dataClass = new DataClass();
        dataClass.setName(name);
        dataClass.setFrom(from);
        dataClass.setTo(to);
        dataClass.setColor(color);
        return dataClass;
    }
}