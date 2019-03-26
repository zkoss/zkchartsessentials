package org.zkoss.zkcharts.essentials.exporting;

import org.zkoss.chart.*;
import org.zkoss.chart.model.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.select.*;
import org.zkoss.zk.ui.select.annotation.*;

public class ExportOptionComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;
	private CategoryModel categoryModel;

	@Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initModel();
		chart.setModel(categoryModel);
		//solution 1
//		chart.getExporting().setSourceWidth(1500); //uncomment this line to fix the difference between exported and on screen.
		//solution 2
//        chart.getYAxis().setTickInterval(10); //specify explicit chart options to avoid zk chart calculating automatically
    }

    private void initModel() {
        categoryModel = new DefaultCategoryModel();
        categoryModel.setValue("Tainan", "09/2017", 10.0);
        categoryModel.setValue("Tainan", "08/2017", 0.0);
        categoryModel.setValue("Tainan", "07/2017", 0.0);
        categoryModel.setValue("Tainan", "06/2017", 0.0);
        categoryModel.setValue("Tainan", "05/2017", 0.0);
        categoryModel.setValue("Tainan", "04/2017", 15.0);
        categoryModel.setValue("Tainan", "03/2017", 10.0);
        categoryModel.setValue("Tainan", "02/2017", 20.5);
        categoryModel.setValue("Tainan", "01/2017", 30.3);
        categoryModel.setValue("Tainan", "12/2016", 10.5);
        categoryModel.setValue("Tainan", "11/2016", 0.0);
        categoryModel.setValue("Tainan", "10/2016", 0.0);
    }
}