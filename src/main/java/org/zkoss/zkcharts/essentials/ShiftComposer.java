package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Window;

/**
 * @author hawk
 *
 */
public class ShiftComposer extends SelectorComposer<Component> {
    @Wire
    Charts chart;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        // initial series data
        initPoints();
        // hide some unnecessary options
        hideOptions();
        // allow point select
        chart.getPlotOptions().getBubble().setAllowPointSelect(true);
    }
      
    @Listen("onPlotClick = #chart")
    public void shiftPoint(ChartsEvent event) {
        // retrieve the point object.
        Point point = event.getPoint();
        // shift the point by updating its x value.
        point.setX(point.getX().intValue() + random() / 10);
    }

    @Listen("onClick = #chart")
    public void movePoint(ChartsClickEvent event) {
        for (Point point: chart.getSelectedPoints()) {
            point.update(event.getXAxis(), event.getYAxis(), point.getHigh()); //doesn't work for ZKCHARTS-142
            point.setSelected(false);
        }
    }
    private void initPoints() {
        for (int i = 0; i < 10; i ++) {
            chart.getSeries(i).addPoint(random(), random(), i * 5);
        }
    }
  
    private void hideOptions() {
        // remove chart title
        chart.setTitle("");
        // remove y axis title
        chart.getYAxis().setTitle("");
        // hide the legend.
        chart.getLegend().setEnabled(false);
        // hide the tooltip.
        chart.getTooltip().setEnabled(false);
        // hide the exporting button.
        chart.getExporting().setEnabled(false);
    }
      
    private double random() {
        // returns random integer ranged from 10 to 100.
        return Math.round(((Math.random()) * 90 + 10));
    }
}
