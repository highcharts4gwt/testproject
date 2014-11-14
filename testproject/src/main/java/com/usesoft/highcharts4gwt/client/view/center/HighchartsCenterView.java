package com.usesoft.highcharts4gwt.client.view.center;

import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;

public interface HighchartsCenterView extends IsWidget
{
    void setPresenter(Presenter presenter);
    
    void renderChart(ChartOptions options);
    
    public interface Presenter
    {
    }
}
