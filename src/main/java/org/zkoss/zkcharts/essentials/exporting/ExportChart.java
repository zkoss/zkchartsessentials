package org.zkoss.zkcharts.essentials.exporting;

import org.zkoss.chart.Charts;
import org.zkoss.chart.ChartsEngine;
import org.zkoss.chart.model.DefaultPieModel;
import org.zkoss.chart.model.PieModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Purpose: export a chart into an image under offline (without network).
 * Notice: requires <a href="https://www.highcharts.com/docs/export-module/setting-up-the-server">Highcharts export server</a>.
 * @author Robert
 */
public class ExportChart {
    public static void main(String[] args) throws IOException, InterruptedException {
        PieModel model = new DefaultPieModel();
        model.setValue("A", 70);
        model.setValue("B", 20);
        model.setValue("C", 10);

        ChartsEngine chart = new ChartsEngine();
        chart.setType(Charts.PIE);
        chart.setTitle("My Export Chart");
        chart.setModel(model);

        Path infile = Files.createTempFile("chartconfig", ".json");
        Path outfile = Files.createTempFile("chartexport", ".png");
        Files.write(infile, chart.toJSON().getBytes());

        System.out.println("Temp charts config file:  " + infile);

        // run highcharts export server command to export a chart image
        Process export = new ProcessBuilder()
                .command("/home/bin/highcharts-export-server",  //specify your path
                        "-infile", infile.toString(),
                        "-outfile", outfile.toString())
                .start();

        if(export.waitFor() == 0) {
            System.out.println("Successfully exported to: " + outfile);
        } else {
            System.err.println("Error exporting chart:    " + outfile);
        }

        //TODO: cleanup temp files
    }
}
