package org.zkoss.zkcharts.essentials.model;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

public class LineChartComposer extends SelectorComposer<Component> {
    @Wire
    Charts chart;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        CategoryModel model = new DefaultCategoryModel();
        model.setValue("1900", "Q1", new Integer(20));
        model.setValue("1900", "Q2", new Integer(55));
        model.setValue("1900", "Q3", new Integer(40));
        model.setValue("1900", "Q4", new Integer(75));
        model.setValue("1901", "Q1", new Integer(40));
        model.setValue("1901", "Q2", new Integer(75));
        model.setValue("1901", "Q3", new Integer(80));
        model.setValue("1901", "Q4", new Integer(120));

        chart.setModel(model);
    }
}