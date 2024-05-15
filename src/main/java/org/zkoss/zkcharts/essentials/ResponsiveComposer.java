package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

/**
 * An example of responsive chart
 * https://api.highcharts.com/highcharts/responsive
 */
public class ResponsiveComposer extends SelectorComposer<Component> {

	@Wire
	private Charts chart;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		chart.setModel(ColumnBasicData.getCategoryModel());
		applyResponsiveRule();
	}

	private void applyResponsiveRule() {
		Responsive.Condition condition = new Responsive.Condition();
		condition.setMaxWidth(800);

		//shrink font-size to 10px when width < 800
		Responsive.Rule rule = new Responsive.Rule();
		rule.setCondition(condition);
		PlotData plotData = new PlotData(chart);
		AxisLabels labels = new AxisLabels();
		labels.setStyle("font-size:10px");
		plotData.getXAxis().setLabels(labels);
		rule.setChartOptions(plotData);

		Responsive responsive = new Responsive();
		responsive.addRule(rule);
		chart.setResponsive(responsive);
	}
}
