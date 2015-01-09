package com.github.highcharts4gwt.client.view.center;

import com.github.highcharts4gwt.model.highcharts.option.api.ChartOptions;
import com.google.gwt.user.client.ui.IsWidget;

public interface CenterViewHighcharts extends IsWidget
{
    void setPresenter(Presenter presenter);
    
    void renderChart(ChartOptions options);
    
    void addCode(String code);

    public interface Presenter
    {
    }

}
