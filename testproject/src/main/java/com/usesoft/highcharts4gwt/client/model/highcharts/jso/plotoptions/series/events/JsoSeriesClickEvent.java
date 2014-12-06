package com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events;

import com.google.gwt.dom.client.NativeEvent;
import com.usesoft.highcharts4gwt.client.model.highcharts.api.plotoptions.series.events.SeriesClickEvent;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class JsoSeriesClickEvent extends NativeEvent implements SeriesClickEvent
{
    protected JsoSeriesClickEvent()
    {
    }

    @Override
    public native final Series getSeries()/*-{
		return this.source.chart.options.series[this.source.index];
    }-*/;

}
