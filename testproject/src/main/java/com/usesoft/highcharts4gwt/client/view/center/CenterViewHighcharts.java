package com.usesoft.highcharts4gwt.client.view.center;

import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;

public interface CenterViewHighcharts extends IsWidget
{
    void setPresenter(Presenter presenter);
    
    void renderChart(ChartOptions options);
    
    void addCode(String code);

    public interface Presenter
    {
    }

}
