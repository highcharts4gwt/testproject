package com.github.highcharts4gwt.client.infrastructure.injection.copy;

import com.github.highcharts4gwt.model.highcharts.option.api.ChartOptions;
import com.google.gwt.core.client.JavaScriptObject;

public class JsoHighchartsFactory implements HighchartsFactory
{
    @Override
    public ChartOptions createChartOptions()
    {
        return (ChartOptions) JavaScriptObject.createObject();
    }
}
