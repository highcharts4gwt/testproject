package com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events;

import com.google.gwt.event.shared.EventHandler;

public interface SeriesClickEventHandler extends EventHandler
{
    public boolean onSeriesClick(SeriesClickEventGwt clickEvent);
}