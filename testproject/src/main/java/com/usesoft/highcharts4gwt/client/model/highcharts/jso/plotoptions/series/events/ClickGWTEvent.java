package com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events;

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.shared.GwtEvent;
import com.usesoft.highcharts4gwt.client.model.highcharts.api.plotoptions.series.events.ClickEvent;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class ClickGWTEvent extends GwtEvent<ClickEventHandler> implements HasNativeEvent
{

    private ClickEvent event;

    private static Type<ClickEventHandler> TYPE;

    public static Type<ClickEventHandler> getType()
    {
        if (TYPE == null)
            TYPE = new Type<ClickEventHandler>();
        return TYPE;
    }

    public ClickGWTEvent(ClickEvent nativeEvent)
    {
        this.event = nativeEvent;
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<ClickEventHandler> getAssociatedType()
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
    protected void dispatch(ClickEventHandler handler) {
        handler.onClick (this);
    }

}
