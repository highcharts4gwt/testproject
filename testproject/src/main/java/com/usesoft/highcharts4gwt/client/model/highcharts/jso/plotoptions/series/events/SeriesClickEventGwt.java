package com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.web.bindery.event.shared.Event;
import com.usesoft.highcharts4gwt.client.model.highcharts.api.plotoptions.series.events.EventWithSeries;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class SeriesClickEventGwt extends Event<SeriesClickEventHandler> implements HasNativeEvent
{

    private EventWithSeries event;

    private static Type<SeriesClickEventHandler> TYPE;

    public static Type<SeriesClickEventHandler> getType()
    {
        if (TYPE == null)
            TYPE = new Type<SeriesClickEventHandler>();
        return TYPE;
    }

    public SeriesClickEventGwt(EventWithSeries nativeEvent)
    {
        this.event = nativeEvent;
    }

    @Override
    public Type<SeriesClickEventHandler> getAssociatedType()
    {
        return getType();
    }

    public Series getSeries()
    {
        return event.getSeries();
    }
    
    @Override
    public NativeEvent getNativeEvent () {
      return (NativeEvent) event;
    }

    @Override
    protected void dispatch(SeriesClickEventHandler handler) {
        handler.onSeriesClick (this);
    }

}
