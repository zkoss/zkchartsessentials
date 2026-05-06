package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class FirstChartComposer extends SelectorComposer<Component> {
    @Wire
    Charts chart;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        // Create a predefined implementation category model
        CategoryModel model = new DefaultCategoryModel();

        // Set value to the model
        model.setValue("Tokyo", "Spring", 11);
        model.setValue("Tokyo", "Summer", 20);
        model.setValue("Tokyo", "Fall", 16);
        model.setValue("Tokyo", "Winter", -2);
        model.setValue("New York", "Spring", 6);
        model.setValue("New York", "Summer", 12);
        model.setValue("New York", "Fall", 10);
        model.setValue("New York", "Winter", 2);
        
        // Set model to the chart
        chart.setModel(model);
        chart.getTitle().setMargin(0);
    }
}
