package org.zkoss.zkcharts.essentials.exporting;

import org.zkoss.chart.*;
import org.zkoss.chart.model.*;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.json.JavaScriptValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;

import java.util.*;

/**
 * @author hawk
 *
 */
public class Export2ServerComposer extends SelectorComposer<Component> {

	@Wire
    private Charts mychart;
    @Wire
    private Button export;
	private SingleValueCategoryModel model = new DefaultSingleValueCategoryModel();
	
	@Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initDataModel();
        mychart.setModel(model);
    }

    private void initDataModel() {
        model.setValue("Mine", 32);
        model.setValue("Yours", 12);
        model.setValue("His", 20);
        model.setValue("Ours", 14);
        model.setValue("Theirs", 55);
    }

    @Listen("onExport = #mychart")
    public void export(Event event){
        Clients.log(((Map)event.getData()).get("image"));
    }
}
