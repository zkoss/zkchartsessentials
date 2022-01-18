package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.chart.Series;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;


public class AreaMissingComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initData();
    }

	private void initData() {
		chart.getXAxis().setType("category");
		Series series0 = chart.getSeries(0);
		series0.setData(new Point("apples", 5), new Point("pears", 9), new Point("oragnes", 4), new Point("Bannas", 8), new Point("Grapes", 9));
		series0.setType("area");
		series0.setName("John");
		
		Series series1 = chart.getSeries(1);

		series1.setData(new Point("apples", 2),  new Point("pears", 1)
				, new Point("oragnes", (Number)null) //missing value on purpose
				, new Point("Bannas", 5), new Point("Grapes", 9));
		series1.setType("area");
		series1.setName("Peter");
	}
}
