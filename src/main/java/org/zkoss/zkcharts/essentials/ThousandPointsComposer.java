package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.Window;

public class ThousandPointsComposer extends SelectorComposer<Window> {

	@Wire
	Charts chart;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);
		// uncomment the line to free threshold limit
//		chart.getPlotOptions().getSeries().setTurboThreshold(0);
	}

	@Listen("onClick = #addThousand")
	public void addThousandPoints() {
		Series series = chart.getSeries(0);
		for (int i =0 ; i < 1005 ; i++){
			series.addPoint("a", i);
		}
	}
	// no threshold limit
	@Listen("onClick = #addNumber")
	public void add1000Number(){
		Series series1 = chart.getSeries(1);
		for (int i = 0; i < 1005; i++) {
			series1.addPoint(i);
		}
	}
}