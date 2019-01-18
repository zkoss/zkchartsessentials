package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Button;

/**
 * https://api.highcharts.com/highcharts/xAxis.dateTimeLabelFormats
 * @author hawk
 *
 */
public class DatetimeFormatComposer extends SelectorComposer<Component> {

    @Wire
    private Charts chart;

    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        init();
        // change the default format
        DateTimeLabelFormats oldFormat = chart.getXAxis().getDateTimeLabelFormats();
        oldFormat.setDay("%b-%e");


        // https://api.highcharts.com/highcharts/tooltip.formatter
        chart.getTooltip().setPointFormat(" {point.x}");
        chart.getTooltip().setHeaderFormat("in {series.name}");
    }

    private void init() {
        chart.getXAxis().setType("datetime");
        chart.getYAxis().setTitle("");

        Tooltip tooltip = chart.getTooltip();
        tooltip.setCrosshairs(true);
        tooltip.setShared(true);
        tooltip.setValueSuffix("°C");

        chart.setLegend(new Legend());

        Series series1 = chart.getSeries();
        series1.setName("Temperature");
        for (Double[] val : AreaRangeLineData.getAverages()) {
            series1.addPoint(val[0], val[1]);
        }
        series1.setZIndex(1);

        final String color = chart.getColors().get(0).stringValue();
        Marker marker = series1.getMarker();
        marker.setFillColor("white");
        marker.setLineWidth(2);
        marker.setLineColor(color);
    }


}
