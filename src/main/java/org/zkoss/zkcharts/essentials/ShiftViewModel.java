package org.zkoss.zkcharts.essentials;

import org.zkoss.bind.annotation.*;
import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.*;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Window;

/**
 * @author hawk
 */
public class ShiftViewModel {
    @Wire
    Charts chart;

    //http://books.zkoss.org/zk-mvvm-book/8.0/advanced/wire_components.html
    @AfterCompose
    public void doAfterCompose(@ContextParam(ContextType.VIEW) Component view) throws Exception {
        Selectors.wireComponents(view, this, false);
        // initial series data
        initPoints();
        // hide some unnecessary options
        hideOptions();
    }

    /** You can pass {@link Charts} object as a command binding parameter and receive with @BindingParam
     */
    @Command
    public void shiftPoint(@ContextParam(ContextType.TRIGGER_EVENT) ChartsEvent event) {
        // retrieve the point object.
        Point point = event.getPoint();
        // shift the point by updating its x value.
        point.setX(point.getX().intValue() + random() / 10);
    }

    private void initPoints() {
        for (int i = 0; i < 10; i++) {
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
