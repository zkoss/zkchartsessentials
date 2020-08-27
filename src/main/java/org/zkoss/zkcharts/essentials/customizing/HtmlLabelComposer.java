package org.zkoss.zkcharts.essentials.customizing;

import org.zkoss.chart.Charts;
import org.zkoss.chart.model.*;
import org.zkoss.json.JavaScriptValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

public class HtmlLabelComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;

    private static CategoryModel model;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        model = new DefaultCategoryModel();
        model.setValue("John"
                , "<a title='great!!' href='http://www.zkoss.org' class='hastip'>Apples: an edible fruit produced by an apple tree (Malus domestica)</a>", new Integer(5000));
        model.setValue("John"
                , "<a title='great!!' href='http://www.zkoss.org' class='hastip'>Orange</a>", new Integer(7000));
        model.setValue("John"
                , "<a title='great!!' href='http://www.zkoss.org' class='hastip'>Melon</a>", new Integer(6000));
        model.setValue("John"
                , "<a title='great!!' href='http://www.zkoss.org' class='hastip'>Lemon</a>", new Integer(8000));

        chart.setModel(model);
        chart.getYAxis().setMin(0);
        chart.getYAxis().setTitle("Total fruit consumption");

        // enable html label
        chart.getXAxis().getLabels().setUseHTML(true);
        chart.getXAxis().getLabels().setStyle("word-break: break-all;text-overflow: clip;"); //break words, prevent ellipsis

        //enable data labels for all series
        chart.getPlotOptions().getSeries().getDataLabels().setEnabled(true);
        setDatalabelFormatter();
    }

    /**
     * register a JavaScript callback function to format the data label.
     */
    private void setDatalabelFormatter() {
        JavaScriptValue js = new JavaScriptValue("function(){if ( this.y > 1000 ) return Highcharts.numberFormat( this.y/1000, 1) + \"K\"; \n" +
                "else \n" +
                "          return this.y;}");
        chart.getSeries().getDataLabels().setFormatter(js);
    }
}
