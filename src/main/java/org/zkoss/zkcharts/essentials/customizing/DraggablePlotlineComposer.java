package org.zkoss.zkcharts.essentials.customizing;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkcharts.essentials.FirstChartComposer;

import java.util.*;

public class DraggablePlotlineComposer extends FirstChartComposer {
    @Wire
    private Charts chart;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        addPlotLine();        
    }

    private void addPlotLine() {
        List list = new LinkedList<>();
        PlotLine line = new PlotLine();
        line.setValue(1);
        line.setWidth(5);
        line.setColor("#FF0000");
        line.setId("myline");
        list.add(line);
        chart.getXAxis().setPlotLines(list);
    }
}
