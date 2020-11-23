package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;

import java.util.*;


public class AutomaticPointColorComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initData();
        chart.getXAxis().setType("category");
        // enable automatic point color
        //https://api.highcharts.com/highcharts/plotOptions.column.colorByPoint
        chart.getPlotOptions().getSeries().setColorByPoint(true);
    }

    private void initData() {
        Series series = chart.getSeries();
        series.setData(new Point("apples", 2), new Point("pears", 1),
                new Point("oranges", 3), new Point("banannas", 5),
                new Point("grapes", 9));
        series.setName("Peter");
    }
}
