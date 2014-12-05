package com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events;

import com.google.gwt.dom.client.NativeEvent;
import com.usesoft.highcharts4gwt.client.model.highcharts.api.plotoptions.series.events.ClickEvent;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoSeries;

public class JsoClickEvent extends NativeEvent implements ClickEvent
{
    protected JsoClickEvent()
    {
    }

    @Override
    public native final JsoSeries getSeries()/*-{
		return this.source.chart.options.series[this.source.index];
    }-*/;

}
