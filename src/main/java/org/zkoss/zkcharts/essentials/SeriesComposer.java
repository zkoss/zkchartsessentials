package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;


public class SeriesComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;
    
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initData();
    }

	private void initData() {
		chart.getXAxis().setType("category");
		Series series0 = chart.getSeries(0);
		series0.setData(new Point("apples", 5), new Point("pears", 9), new Point("oragnes", 4), new Point("bannas", 8), new Point("grapes", 10));
		series0.setType("area");
		series0.setName("John");
		
		Series series1 = chart.getSeries(1);
		series1.setData(new Point("apples", 2),  new Point("pears", 1),new Point("oragnes", 3), new Point("bannas", 5), new Point("grapes", 9));
		series1.setType("column");
		series1.setName("Peter");
	}
}
