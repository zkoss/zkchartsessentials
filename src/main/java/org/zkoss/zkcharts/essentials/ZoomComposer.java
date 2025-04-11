package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class ZoomComposer extends SelectorComposer<Component> {

	@Wire
	private Charts chart;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		chart.setModel(ColumnBasicData.getCategoryModel());
		chart.setZoomType("x"); //enable onSelection event
	}
	

}
