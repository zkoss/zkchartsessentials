package org.zkoss.zkcharts.essentials.exporting;

import org.zkoss.chart.*;
import org.zkoss.chart.model.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

import java.util.*;

/**
 * an example of ChartsEngine.
 * @author hawk
 *
 */
public class ChartsEngineComposer extends SelectorComposer<Component> {

	private SingleValueCategoryModel model = new DefaultSingleValueCategoryModel();
    private ChartsEngine chartsEngine = new ChartsEngine();

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
                //call setters without an Execution
                chartsEngine.setType("pie");
                chartsEngine.setTitle("my pie chart at " + Calendar.getInstance().getTime() );
                chartsEngine.setModel(model);
                System.out.println(chartsEngine.toJSON());
            }
        };
        new Thread(runnable).start();
    }
}
