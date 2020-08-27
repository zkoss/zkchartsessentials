package org.zkoss.zkcharts.essentials.model;

import org.zkoss.chart.Point;

public class TilemapData {
    private static Point[] data;

    static {
        data = new Point[] {
                initDataPoint("AL", "Alabama", 6, 7, 4849377),
                initDataPoint("AK", "Alaska", 0, 0, 737732),
                initDataPoint("AZ", "Arizona", 5, 3, 6745408),
                initDataPoint("AR", "Arkansas", 5, 6, 2994079),
                initDataPoint("CA", "California", 5, 2, 39250017),
                initDataPoint("CO", "Colorado", 4, 3, 5540545),
                initDataPoint("CT", "Connecticut", 3, 11, 3596677),
                initDataPoint("DE", "Delaware", 4, 9, 935614),
                initDataPoint("DC", "District of Columbia", 4, 10, 7288000),
                initDataPoint("FL", "Florida", 8, 8, 20612439),
                initDataPoint("GA", "Georgia", 7, 8, 10310371),
                initDataPoint("HI", "Hawaii", 8, 0, 1419561),
                initDataPoint("ID", "Idaho", 3, 2, 1634464),
                initDataPoint("IL", "Illinois", 3, 6, 12801539),
                initDataPoint("IN", "Indiana", 3, 7, 6596855),
                initDataPoint("IA", "Iowa", 3, 5, 3107126),
                initDataPoint("KS", "Kansas", 5, 5, 2904021),
                initDataPoint("KY", "Kentucky", 4, 6, 4413457),
                initDataPoint("LA", "Louisiana", 6, 5, 4649676),
                initDataPoint("ME", "Maine", 0, 11, 1330089),
                initDataPoint("MD", "Maryland", 4, 8, 6016447),
                initDataPoint("MA", "Massachusetts", 2, 10, 6811779),
                initDataPoint("MI", "Michigan", 2, 7, 9928301),
                initDataPoint("MN", "Minnesota", 2, 4, 5519952),
                initDataPoint("MS", "Mississippi", 6, 6, 2984926),
                initDataPoint("MO", "Missouri", 4, 5, 6093000),
                initDataPoint("MT", "Montana", 2, 2, 1023579),
                initDataPoint("NE", "Nebraska", 4, 4, 1881503),
                initDataPoint("NV", "Nevada", 4, 2, 2839099),
                initDataPoint("NH", "New Hampshire", 1, 11, 1326813),
                initDataPoint("NJ", "New Jersey", 3, 10, 8944469),
                initDataPoint("NM", "New Mexico", 6, 3, 2085572),
                initDataPoint("NY", "New York", 2, 9, 19745289),
                initDataPoint("NC", "North Carolina", 5, 9, 10146788),
                initDataPoint("ND", "North Dakota", 2, 3, 739482),
                initDataPoint("OH", "Ohio", 3, 8, 11614373),
                initDataPoint("OK", "Oklahoma", 6, 4, 3878051),
                initDataPoint("OR", "Oregon", 4, 1, 3970239),
                initDataPoint("PA", "Pennsylvania", 3, 9, 12784227),
                initDataPoint("RI", "Rhode Island", 2, 11, 1055173),
                initDataPoint("SC", "South Carolina", 6, 8, 4832482),
                initDataPoint("SD", "South Dakota", 3, 4, 853175),
                initDataPoint("TN", "Tennessee", 5, 7, 6651194),
                initDataPoint("TX", "Texas", 7, 4, 27862596),
                initDataPoint("UT", "Utah", 5, 4, 2942902),
                initDataPoint("VT", "Vermont", 1, 10, 626011),
                initDataPoint("VA", "Virginia", 5, 8, 8411808),
                initDataPoint("WA", "Washington", 2, 1, 7288000),
                initDataPoint("WV", "West Virginia", 4, 7, 1850326),
                initDataPoint("WI", "Wisconsin", 2, 5, 5778708),
                initDataPoint("WY", "Wyoming", 3, 3, 584153)
        };
    }

    private static Point initDataPoint(String label, String name, Number x, Number y, Number value) {
        Point point = new Point(name, y, x);
        point.setLabel(label);
        point.setValue(value);
        return point;
    }

    public static Point[] getData() {
        return data;
    }
}
