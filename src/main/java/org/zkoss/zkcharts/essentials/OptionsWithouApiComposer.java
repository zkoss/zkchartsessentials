package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Series;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

public class OptionsWithouApiComposer extends SelectorComposer<Window> {

    @Wire
    Charts chart;
    private float opacity = 0.5f;

    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        chart.setSubtitle("Source: <a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">thebulletin.metapress.com</a>");
        Series series1 = chart.getSeries();
        series1.setName("USA");
        series1.setData(AreaBasicData.getUSAData());
        
        chart.getSeries().addExtraAttr("fillOpacity", new AnyVal<Float>(opacity));
    }
    
    @Listen("onClick = #increase")
    public void increase(){
    	if (opacity<1.0){
    		opacity += 0.1;
    	}
    	chart.getSeries().addExtraAttr("fillOpacity", new AnyVal<Float>(opacity));
    	chart.invalidate();
    }
    
    @Listen("onClick = #decrease")
    public void decrease(){
    	if (opacity > 0.0){
    		opacity -= 0.1;
    	}
    	chart.getSeries().addExtraAttr("fillOpacity", new AnyVal<Float>(opacity));
    	chart.invalidate();
    }
}
