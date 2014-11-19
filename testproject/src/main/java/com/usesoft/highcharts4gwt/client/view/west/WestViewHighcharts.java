package com.usesoft.highcharts4gwt.client.view.west;

import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.ChartCategory;

public interface WestViewHighcharts extends IsWidget
{
    void addLink(Chart chart);
    
    void addCategory(ChartCategory category);
    
    void setPresenter(Presenter presenter);
    
    public interface Presenter
    {
        void navigateTo(Chart chart);
    }

}
