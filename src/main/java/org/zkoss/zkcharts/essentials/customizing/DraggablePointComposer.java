package org.zkoss.zkcharts.essentials.customizing;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkcharts.essentials.FirstChartComposer;

import java.util.*;

public class DraggablePointComposer extends FirstChartComposer {
    @Wire
    private Charts chart;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        enableDraggablePoints();
    }

    /**
     * https://api.highcharts.com/highcharts/plotOptions.series.dragDrop
     */
    private void enableDraggablePoints() {
        //enable drag and drop for a specific series
        chart.getSeries().getDragDrop().setDraggableY(true);
        //enable drag and drop for all series
//        chart.getPlotOptions().getSeries().getDragDrop().setDraggableX(true);
    }
}
