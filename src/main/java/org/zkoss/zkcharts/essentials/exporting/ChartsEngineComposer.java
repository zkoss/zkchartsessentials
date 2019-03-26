package org.zkoss.zkcharts.essentials.exporting;

import org.zkoss.chart.*;
import org.zkoss.chart.model.*;
import org.zkoss.chart.util.AnyVal;
import org.zkoss.json.JavaScriptValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.util.Clients;

import java.util.*;

/**
 * an example of ChartsEngine.
 * @author hawk
 *
 */
public class ChartsEngineComposer extends SelectorComposer<Component> {

	private SingleValueCategoryModel model = new DefaultSingleValueCategoryModel();
    private ChartsEngine chart = new ChartsEngine();

	@Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        model.setValue("Mine",32);
        model.setValue("Yours",12);
        model.setValue("His",20);
        model.setValue("Ours",14);
        model.setValue("Theirs",55);


        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //call setters without an Execution
                chart.setType("pie");
                chart.setTitle("my pie chart at " + Calendar.getInstance().getTime() );
                chart.setModel(model);
                System.out.println(chart.toJSON());
            }
        };
        new Thread(runnable).start();
    }
}
