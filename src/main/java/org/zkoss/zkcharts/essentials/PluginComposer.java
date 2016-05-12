package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.DefaultSingleValueCategoryModel;
import org.zkoss.chart.model.SingleValueCategoryModel;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

/**
 * @author hawk
 *
 */
public class PluginComposer extends SelectorComposer<Component> {

	@Wire
    private Charts mychart;
    
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
    }
}
