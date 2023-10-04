package org.zkoss.zkcharts.essentials.customizing;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkcharts.essentials.model.SampleModel;

public class ColorComposer extends SelectorComposer {
    @Wire
    private Charts charts;
    String[] colors = {
            "red",
            "blue",
            "green",
            "yellow",
            "purple",
            "orange",
            "pink",
            "brown",
            "gray",
            "teal",
            "black"
    };
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        CategoryModel model = new SampleModel().getCategoryModel();
        charts.setModel(model);
        charts.setColors(colors); //provide a list of default colors

        charts.getSeries().setColor("#aabbcc"); //change a specific series
    }
}
