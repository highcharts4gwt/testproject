package com.github.highcharts4gwt.client.view.west;

import com.github.highcharts4gwt.client.model.highcharts.ChartExample;
import com.github.highcharts4gwt.client.model.highcharts.ChartCategory;
import com.google.gwt.user.client.ui.IsWidget;

public interface WestViewHighcharts extends IsWidget
{
    void addLink(ChartExample chart);
    
    void addCategory(ChartCategory category);
    
    void setPresenter(Presenter presenter);
    
    public interface Presenter
    {
        void navigateTo(ChartExample chart);
    }

}
