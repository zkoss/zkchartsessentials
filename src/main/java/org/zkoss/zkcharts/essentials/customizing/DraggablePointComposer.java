package org.zkoss.zkcharts.essentials.customizing;

import java.util.Map;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Point;
import org.zkoss.json.JSONObject;
import org.zkoss.json.JavaScriptValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkcharts.essentials.FirstChartComposer;

public class DraggablePointComposer extends FirstChartComposer {
    @Wire
    private Charts chart;
    

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        enableDraggablePoints();
    }

    /**
     * https://api.highcharts.com/highcharts/plotOptions.series.dragDrop
     */
    private void enableDraggablePoints() {
        //enable drag and drop for a specific series
        chart.getSeries().getDragDrop().setDraggableY(true);
        //create an object to hold the point value
        JSONObject pointValue = new JSONObject();
        //create an object to hold the point.events value
        JSONObject eventsValue = new JSONObject();
        //set the content of the point.events.drop callback
        eventsValue.put("drop", new JavaScriptValue("function(e){zAu.send(new zk.Event(zk.$('#"+chart.getUuid()+"'), \"onPointDrop\", {pointData: e.newPoint, serieIndex: e.origin.points[e.newPointId].point.series.index, pointIndex:e.origin.points[e.newPointId].point.index}, {toServer:true}));}"));
		pointValue.put("events", eventsValue);
		chart.getPlotOptions().getSeries().addExtraAttr("point", pointValue);
        //enable drag and drop for all series
//        chart.getPlotOptions().getSeries().getDragDrop().setDraggableX(true);
		
		
    }

    @Listen("onPointDrop=#chart")
    public void handleDrop(Event event) {
    	Map data = (Map) event.getData();
    	Map pointData = (Map) data.get("pointData");
    	Double y = (Double) pointData.get("y");
    	int serieIndex = (int) data.get("serieIndex");
    	int pointIndex = (int) data.get("pointIndex");
    	Clients.log("new point data: " + y + " series (" +serieIndex+"), point (" +pointIndex+ ")");
    }
}
