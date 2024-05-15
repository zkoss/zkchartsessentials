package org.zkoss.zkcharts.essentials.customizing;

import org.zkoss.chart.*;
import org.zkoss.chart.util.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;

import java.util.Arrays;

/**
 * A simple example of customizing menu items.
 */
public class MenuItemsComposer extends SelectorComposer<Component> {

    @Wire
    Charts chart;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initData();

        chart.getTooltip().setValueSuffix("%");
        determineFullScreen();
        changeLang();
    }

    static String[] defaultMenuItems = {
            "printChart",
            "separator",
            "downloadPNG",
            "downloadJPEG",
            "downloadPDF",
            "downloadSVG"
    };
    private void determineFullScreen() {
        Exporting exporting = chart.getExporting();
        OptionsList<String> menuItems = new OptionsList<>();
        menuItems.addAll(Arrays.asList(defaultMenuItems));
        exporting.getButtons().addExtraAttr("menuItems", menuItems);
        if (!isSafari()){
            menuItems.add("viewFullscreen");
        }
    }

    private void changeLang() {
        Options options = new Options();
        Lang lang = options.getLang();
        lang.addExtraAttr("viewFullscreen", new AnyVal<>("全螢幕"));
        chart.setOptions(options);
    }

    private boolean isSafari(){
        Execution execution = Executions.getCurrent();
        Double safariVersion = execution.getBrowser("safari");
        return safariVersion != null;
    }

    private void initData() {
        Series series = chart.getSeries();
        series.setName("Percentage");
        series.setColorByPoint(true);
        series.addPoint("Water", 35.02);
        series.addPoint(new Point("Fat", 20.71));
        series.addPoint("Carbohydrates", 1.09);
        series.addPoint("Protein", 15.5);
        series.addPoint("Ash", 1.68);
        series.addPoint("AAA", 5.0);
        series.addPoint("BBB", 5.0);
        series.addPoint("CCC", 5.0);
        series.addPoint("DDD", 5.0);
        series.addPoint("Eeeee", 3.0);
        series.addPoint("Fffff", 3.0);
    }
}
