package org.zkoss.zkcharts.essentials.model;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class PieChartComposer extends SelectorComposer<Component> {
    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        PieModel model = new DefaultPieModel();
        model.setValue("C/C++", new Double(12.5));
        model.setValue("Java", new Double(50.2));
        model.setValue("VB", new Double(20.5));
        model.setValue("PHP", new Double(15.5));

        chart.setModel(model);
    }
}
