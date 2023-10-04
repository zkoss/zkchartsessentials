package org.zkoss.zkcharts.essentials.model;

import org.zkoss.chart.model.*;

import java.util.Random;

public class SampleModel {

    public CategoryModel categoryModel = new DefaultCategoryModel();
    static private Random rand = new Random();
    public SampleModel() {
        initCategoryModel();
    }

    private void initCategoryModel() {
        categoryModel.setValue("2000", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2001", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2002", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2003", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2004", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2005", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2006", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2007", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2008", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2009", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
        categoryModel.setValue("2010", "A", rand.nextDouble() * (rand.nextInt(100) + 1));
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }
}
