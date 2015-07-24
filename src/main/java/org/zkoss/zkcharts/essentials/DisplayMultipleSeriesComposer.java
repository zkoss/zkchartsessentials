package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.Charts;
import org.zkoss.chart.ChartsEvent;
import org.zkoss.chart.model.DefaultCategoryModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

/**
 * An example to demonstrate drilldown manually by listening "onPlotClick"<br/>
 * Listening "onPlotDrillDown" is a possible solution, but it will throw an exception when there are multiple series.
 * @author hawk
 *
 */
public class DisplayMultipleSeriesComposer extends SelectorComposer<Component> {

    @Wire
    private Charts chart;
    @Wire("#back")
    private Button backButton;
    
    private DefaultCategoryModel model = new DefaultCategoryModel();
    private String DRILLDOWN_LEVEL = "LEVEL"; 
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        chart.getYAxis().setTitle("Values");
        initModel();
        chart.setModel(model);
        chart.setAttribute(DRILLDOWN_LEVEL, new Integer(0)); 
        updateDrilldownStatus();
    }
    
    private void updateDrilldownStatus(){
    	Integer level = (Integer)chart.getAttribute(DRILLDOWN_LEVEL);
    	if (level == 0){
    		chart.getPlotOptions().getSeries().setCursor("pointer");
    		backButton.setVisible(false);
    	}else{
    		chart.getPlotOptions().getSeries().setCursor("normal");
    		backButton.setVisible(true);
    	}
    }
    
    enum TRADE{INVOICE_AMOUNT, GROSS_AMOUNT, TOTAL_AMOUNT}
    
    String MARKET1 = "California 1";
    String MARKET2 = "California 2";

    private void initModel(){
    	model.setValue(TRADE.TOTAL_AMOUNT, MARKET1, 32000);
    	model.setValue(TRADE.TOTAL_AMOUNT,MARKET2, 51000);
    	model.setValue("test", MARKET1, 32000);
    	model.setValue("test", MARKET2, 51000);
    }
    
    /**
     * Switch the chart's model with corresponding data.  
     */
    @Listen("onPlotClick = charts")
    public void drilldown(ChartsEvent e){
    	Integer level = (Integer)chart.getAttribute(DRILLDOWN_LEVEL);
    	level++;
    	chart.setAttribute(DRILLDOWN_LEVEL, level);
    	if (level == 1){
	    	model.clear();
	    	if (MARKET1.equals(e.getCategory())){
	    		loadDrilldownModel1();
	    	}else{
	    		loadDrilldownModel2();
	    	}
	    	updateDrilldownStatus();
    	}
    }
    
    @Listen("onClick = #back")
    public void reloadMarket(){
    	Integer level = (Integer)chart.getAttribute(DRILLDOWN_LEVEL);
    	level--;
    	chart.setAttribute(DRILLDOWN_LEVEL, level);
    	if (level == 0){
    		model.clear();
    		initModel();
    		updateDrilldownStatus();
    	}
    }
    
    public void loadDrilldownModel1(){
        model.setValue(TRADE.INVOICE_AMOUNT, "Harbor", 1000);
        model.setValue(TRADE.INVOICE_AMOUNT, "Bakersfield", 3000);
        model.setValue(TRADE.INVOICE_AMOUNT, "Sacramento", 2000);
        model.setValue(TRADE.INVOICE_AMOUNT, "Yuba", 4000);
        
        model.setValue(TRADE.GROSS_AMOUNT, "Harbor", 5000);
        model.setValue(TRADE.GROSS_AMOUNT, "Bakersfield", 6000);
        model.setValue(TRADE.GROSS_AMOUNT, "Sacramento", 7000);
        model.setValue(TRADE.GROSS_AMOUNT, "Yuba", 4000);
    }
    
    public void loadDrilldownModel2(){
        model.setValue(TRADE.INVOICE_AMOUNT, "Merced", 7000);
        model.setValue(TRADE.INVOICE_AMOUNT, "Fresno", 4000);
        model.setValue(TRADE.INVOICE_AMOUNT, "Medford", 9000);
        model.setValue(TRADE.INVOICE_AMOUNT, "Redding", 8000);
        
        model.setValue(TRADE.GROSS_AMOUNT, "Merced", 5000);
        model.setValue(TRADE.GROSS_AMOUNT, "Fresno", 7000);
        model.setValue(TRADE.GROSS_AMOUNT, "Medford", 5000);
        model.setValue(TRADE.GROSS_AMOUNT, "Redding", 6000);
    }
 
    /* Doesn't work when there are multiple series
    private void enableDrilldown(){
    	for (int i = 0 ; i< chart.getSeriesSize() ; i++){
    		Series s = chart.getSeries(i);
    		for (Point p : s.getData()){
    			p.setDrilldown(true);
    		}
    	}
    	chart.getDrilldown().setSeries(new Series()); //avoid an exception when drill down
    }
    
    @Listen("onPlotDrillDown = charts")
    public void drillDown(ChartsEvent e){
    	model.clear();
    	if (MARKET1.equals(e.getCategory())){
    		loadDrilldownModel1();
    	}else{
    		loadDrilldownModel2();
    	}
    	backButton.setVisible(true);
    	//store drilldown level
    	// chart.setAttribute("drilldown", "level"); 
    }
    */    
}
