package org.zkoss.zkcharts.essentials.usecase;

import org.zkoss.chart.*;
import org.zkoss.chart.model.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class LinkedYAxisComposer extends SelectorComposer<Component> {
    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        // Create a predefined implementation category model
        CategoryModel model = new DefaultCategoryModel();

        // Set value to the model
        model.setValue("Tokyo", "Spring", new Integer(11));
        model.setValue("Tokyo", "Summer", new Integer(8));
        model.setValue("Tokyo", "Fall", new Integer(-2));
        model.setValue("Tokyo", "Winter", new Integer(-10));

        model.setValue("New York", "Spring", new Integer(30));
        model.setValue("New York", "Summer", new Integer(18));
        model.setValue("New York", "Fall", new Integer(20));
        model.setValue("New York", "Winter", new Integer(22));

        // Set model to the chart
        chart.setModel(model);
        chart.getYAxis().setMin(-10);

        //right y-axis
        YAxis yAxisRight = chart.getYAxis(1);
        //When an axis is linked to a master axis, it will take the same extremes as the master, but as assigned by min or max or by setExtremes. It can be used to show additional info, or to ease reading the chart by duplicating the scales.
        yAxisRight.setLinkedTo(0);
        yAxisRight.setOpposite(true);
        yAxisRight.getLabels().setEnabled(true);
        yAxisRight.setTitle("Different Values");
    }
}
