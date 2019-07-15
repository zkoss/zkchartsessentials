package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.util.Composer;

import java.util.HashMap;
import java.util.stream.IntStream;

public class DrilldownOnDemandComposer implements Composer<Charts> {
    private HashMap<String, Point[]> drilldownCache = new HashMap<>();

    @Override
    public void doAfterCompose(Charts chart) throws Exception {
        chart.setType(Charts.PIE);
        //tooltips styles taken from: https://www.highcharts.com/demo/pie-drilldown
        chart.getTooltip().setHeaderFormat("<span style=\"font-size:11px\">{series.name}</span><br>");
        chart.getTooltip().setPointFormat("<span style=\"color:{point.color}\">{point.name}</span>: <b>{point.y:.3f}%</b> of total<br/>");

        chart.getDrilldown().setSeries(); //WORKAROUND (https://tracker.zkoss.org/browse/ZKCHARTS-80)
        chart.getSeries().setName("Root series");
        chart.getSeries().setData(loadPoints("point", 100, 5));
        chart.addEventListener(ChartsEvents.ON_PLOT_DRILL_DOWN, (ChartsEvent e) -> {
            Point parent = e.getPoint();
            Point[] childPoints = loadPoints(parent.getName(), parent.getY().doubleValue(), (int) (Math.random() * 4) + 3);
            Series series = new Series(parent.getDrilldown(), childPoints);
            series.setName("Details of " + parent.getName());
            chart.addSeriesAsDrilldown(parent, series);
        });
        chart.addEventListener(ChartsEvents.ON_PLOT_DRILL_UP, e -> { /*NOOP*/ }); //WORKAROUND (https://tracker.zkoss.org/browse/ZKCHARTS-81)
    }

    private Point[] loadPoints(String prefix, double total, int seriesLength) {
        //lazy load/cache drilldown points
        return drilldownCache.computeIfAbsent(prefix + "_dd", key -> IntStream.range(0, seriesLength).boxed()
                .map(i -> {
                    double sliceValue = total / seriesLength * (1 - ((double) i / (seriesLength - 1) - 0.5));
                    Point p = new Point(prefix + "-" + i, sliceValue);
                    p.setDrilldown(p.getName() + "_dd");
                    return p;
                })
                .toArray(Point[]::new));
    }
}
