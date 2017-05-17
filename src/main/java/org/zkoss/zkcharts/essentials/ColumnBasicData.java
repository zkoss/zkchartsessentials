package org.zkoss.zkcharts.essentials;

import org.zkoss.chart.model.*;

public class ColumnBasicData {
	private static CategoryModel model;
	static {
		model = new DefaultCategoryModel();
		model.setValue("Tokyo", "Jan", 49.9);
		model.setValue("Tokyo", "Feb", 71.5);
		model.setValue("Tokyo", "Mar", 106.4);
		model.setValue("Tokyo", "Apr", 129.2);
		model.setValue("Tokyo", "May", 144.0);
		model.setValue("Tokyo", "Jun", 176.0);
		model.setValue("Tokyo", "Jul", 135.6);
		model.setValue("Tokyo", "Aug", 148.5);
		model.setValue("Tokyo", "Sep", 216.4);
		model.setValue("Tokyo", "Oct", 194.1);
		model.setValue("Tokyo", "Nov", 95.6);
		model.setValue("Tokyo", "Dec", 54.4);
		model.setValue("New York", "Jan", 83.6);
		model.setValue("New York", "Feb", 78.8);
		model.setValue("New York", "Mar", 98.5);
		model.setValue("New York", "Apr", 93.4);
		model.setValue("New York", "May", 106.0);
		model.setValue("New York", "Jun", 84.5);
		model.setValue("New York", "Jul", 105.0);
		model.setValue("New York", "Aug", 104.3);
		model.setValue("New York", "Sep", 91.2);
		model.setValue("New York", "Oct", 83.5);
		model.setValue("New York", "Nov", 106.6);
		model.setValue("New York", "Dec", 92.3);
		model.setValue("London", "Jan", 48.9);
		model.setValue("London", "Feb", 38.8);
		model.setValue("London", "Mar", 39.3);
		model.setValue("London", "Apr", 41.4);
		model.setValue("London", "May", 47.0);
		model.setValue("London", "Jun", 48.3);
		model.setValue("London", "Jul", 59.0);
		model.setValue("London", "Aug", 59.6);
		model.setValue("London", "Sep", 52.4);
		model.setValue("London", "Oct", 65.2);
		model.setValue("London", "Nov", 59.3);
		model.setValue("London", "Dec", 51.2);
		model.setValue("Berlin", "Jan", 42.4);
		model.setValue("Berlin", "Feb", 33.2);
		model.setValue("Berlin", "Mar", 34.5);
		model.setValue("Berlin", "Apr", 39.7);
		model.setValue("Berlin", "May", 52.6);
		model.setValue("Berlin", "Jun", 75.5);
		model.setValue("Berlin", "Jul", 57.4);
		model.setValue("Berlin", "Aug", 60.4);
		model.setValue("Berlin", "Sep", 47.6);
		model.setValue("Berlin", "Oct", 39.1);
		model.setValue("Berlin", "Nov", 46.8);
		model.setValue("Berlin", "Dec", 51.1);
	}

	public static CategoryModel getCategoryModel() {
		return model;
	}
}
