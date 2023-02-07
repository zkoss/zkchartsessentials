package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.*;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class EventComposer extends SelectorComposer<Component> {

	@Wire
	private Charts chart;
	@Wire
	private Window logWin;
	
	private ListModelList<String> msgList = new ListModelList<String>();
	
	private MyEventListener listener = new MyEventListener();

	@Override
	public void doBeforeComposeChildren(Component comp) throws Exception {
		super.doBeforeComposeChildren(comp);
		getPage().setAttribute("msgList", msgList);
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		chart.setModel(ColumnBasicData.getCategoryModel());
		chart.setZoomType("x"); //enable onSelection event
		chart.getPlotOptions().getSeries().setAllowPointSelect(true); //enable onPlotSelect event
		
		chart.addEventListener(ChartsEvents.ON_PLOT_CLICK, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_CHECKBOX_CLICK, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_DRILL_DOWN, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_DRILL_UP, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_HIDE, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_LEGEND_ITEM_CLICK, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_MOUSE_OUT, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_MOUSE_OUT_POINT, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_MOUSE_OVER, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_MOUSE_OVER_POINT, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_SELECT, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_SHOW, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_THEME_CHANGE, listener);
		chart.addEventListener(ChartsEvents.ON_PLOT_UNSELECT, listener);

		chart.getPlotOptions().getColumn().getStates().getSelect().addExtraAttr("color", new AnyVal("red")); //change selected point color
	}
	
	class MyEventListener implements EventListener<ChartsEvent>{
		@Override
		public void onEvent(ChartsEvent event) throws Exception {
			addMessage(event.getName() + "," + event.getSeries().getName());
		}
	}
	
	@Listen("onSelection = #chart")
	public void selection(ChartsSelectionEvent e) {
			long xAxisMin = e.getXAxisMin().longValue();
			long xAxisMax = e.getXAxisMax().longValue();
			addMessage( e.getName()+":" + xAxisMin +","+xAxisMax);
	}
	
	@Listen("onClick = #chart")
	public void click(ChartsClickEvent event) {
		addMessage(event + ": "+ event.getXAxis() +","+ event.getYAxis());
	}

	@Listen("onClick = button[label='clear']")
	public void clear(){
		msgList.clear();
	}

	private void addMessage(String msg){
		msgList.add(0, msg);
		while(msgList.size()>100){
			msgList.remove(msgList.size()-1);
		}
	}
}
