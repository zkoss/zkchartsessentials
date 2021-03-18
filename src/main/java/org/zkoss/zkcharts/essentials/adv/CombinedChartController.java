package org.zkoss.zkcharts.essentials.adv;

import java.util.Random;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Series;
import org.zkoss.chart.YAxis;
import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.chart.plotOptions.PiePlotOptions;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

/**
 * demonstrate how to combine multiple chart type inton one chart.
 * @author hawk
 */
public class CombinedChartController extends SelectorComposer<Component> {

	private static final long serialVersionUID = -4016316513324539800L;

	@Wire
	private Charts chart;
	private Random random = new Random();

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		chart.getYAxis(0).setMax(150);
		YAxis y2 = chart.getYAxis(1);
		y2.setTitle("Percentage");
		y2.setOpposite(true);
		y2.setMin(0);
		y2.setMax(100);
		y2.getLabels().setFormat("{value}%");

		chart.getTooltip().setShared(true);

		CategoryModel model = new DefaultCategoryModel();
		model.setValue("Series 1", "Q1", random.nextInt(100) + 1);
		model.setValue("Series 1", "Q2", random.nextInt(100) + 1);
		model.setValue("Series 1", "Q3", random.nextInt(100) + 1);
		model.setValue("Series 1", "Q4", random.nextInt(100) + 1);

		model.setValue("Series 2", "Q1", random.nextInt(100) + 1);
		model.setValue("Series 2", "Q2", random.nextInt(100) + 1);
		model.setValue("Series 2", "Q3", random.nextInt(100) + 1);
		model.setValue("Series 2", "Q4", random.nextInt(100) + 1);
		chart.setModel(model);

		//2nd type
		chart.getSeries(1).setType("line");

		//3rd type
		Series series = chart.getSeries(2);
		series.addPoint("IE", 13);
		series.addPoint("Firefox", 32);
		series.addPoint("Safari", 20);
		series.addPoint("Chrome", 35);
		series.setType("pie");
		PiePlotOptions pieOptions = new PiePlotOptions();
		pieOptions.setCenter(40, 10);
		pieOptions.setSize(100);
		pieOptions.setShowInLegend(false);
		pieOptions.getDataLabels().setEnabled(false);
		series.setPlotOptions(pieOptions);
	}

}
