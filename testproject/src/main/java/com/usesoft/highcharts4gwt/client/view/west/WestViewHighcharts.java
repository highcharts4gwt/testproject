package com.usesoft.highcharts4gwt.client.view.west;

import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;

public interface WestViewHighcharts extends IsWidget
{
    void addLink(Chart chart);
    
    void setPresenter(Presenter presenter);
    
    public interface Presenter
    {
        void navigateTo(Chart chart);
    }
}
