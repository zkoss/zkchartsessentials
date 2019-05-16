package org.zkoss.zkcharts.essentials.exporting;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.chart.Charts;
import org.zkoss.chart.Exporting;
import org.zkoss.chart.ExportingButton;
import org.zkoss.chart.MenuItem;
import org.zkoss.chart.model.DefaultSingleValueCategoryModel;
import org.zkoss.chart.model.SingleValueCategoryModel;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.json.JavaScriptValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;

/**
 * @author hawk
 *
 */
public class ExportComposer extends SelectorComposer<Component> {

	@Wire
    private Charts mychart;
	private static final String ON_MY_CUSTOM_ITEM = "onMyCustomItem";
    
	private SingleValueCategoryModel model = new DefaultSingleValueCategoryModel();
	
	@Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        model.setValue("Mine",32);
        model.setValue("Yours",12);
        model.setValue("His",20);
        model.setValue("Ours",14);
        model.setValue("Theirs",55);
       
        mychart.setModel(model);
        
        createCustomExportItems();
    }
    
    private void createCustomExportItems() {
        Exporting exporting = mychart.getExporting();
        ExportingButton buttons = exporting.getButtons();
        List<MenuItem> menuItems = new ArrayList<>();
 
        //optional rebuild the default menu items, otherwise they are replaced
        menuItems.add(defaultMenuItem("printChart", "this.print();"));
        menuItems.add(separator());
        // this.exportChart() is online exporting via export.highcharts.com
        menuItems.add(defaultMenuItem("downloadPNG", "this.exportChart();"));
        menuItems.add(defaultMenuItem("downloadJPEG", "this.exportChart({type: \"image/jpeg\"});"));
        menuItems.add(defaultMenuItem("downloadPDF", "this.exportChart({type: \"application/pdf\"});"));
        menuItems.add(defaultMenuItem("downloadSVG", "this.exportChart({type: \"image/svg+xml\"});"));
        menuItems.add(separator());
        //add custom menu items (possible at any position in the list)
        menuItems.add(customMenuItem("My Custom Item (at Client)", "alert('custem menu item clicked, handled in browser')"));
        menuItems.add(customMenuItem("My Custom Item (to Server)", fireServerEventScript(ON_MY_CUSTOM_ITEM)));
        buttons.setMenuItems(menuItems);		
	}

    private String fireServerEventScript(String eventName) {
        return  "var chartsWidget = zk(evt.target).$(); " +
                "chartsWidget.fire('" + eventName + "', null, {toServer: true});";
    }
     
    @Listen(ON_MY_CUSTOM_ITEM + " = #mychart")
    public void handleMyCustomItem() {
        Clients.showNotification("custem menu item clicked, handled on server");
    }
 
    private MenuItem customMenuItem(String text, String onclickJS) {
        MenuItem menuItem = new MenuItem();
        menuItem.setText(text);
        menuItem.setOnclick(new JavaScriptValue("function(evt) {" + onclickJS + "}"));
        return menuItem;
    }
 
    private MenuItem defaultMenuItem(String textKey, String onclickJS) {
        MenuItem menuItem = new MenuItem();
        menuItem.addExtraAttr("textKey", new AnyVal<String>(textKey));
        menuItem.setOnclick(new JavaScriptValue("function(evt) {" + onclickJS + "}"));
        return menuItem;
    }
 
    private MenuItem separator() {
        MenuItem menuItem = new MenuItem();
        menuItem.addExtraAttr("separator", new AnyVal<Boolean>(true));
        return menuItem;
    }
    
}
