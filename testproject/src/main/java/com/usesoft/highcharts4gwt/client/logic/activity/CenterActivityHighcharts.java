package com.usesoft.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.usesoft.highcharts4gwt.client.model.highcharts.Chart;
import com.usesoft.highcharts4gwt.client.model.highcharts.ChartOptionsVisitor;
import com.usesoft.highcharts4gwt.client.model.highcharts.ChartCodeVisitor;
import com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events.ClickEventHandler;
import com.usesoft.highcharts4gwt.client.model.highcharts.jso.plotoptions.series.events.ClickGWTEvent;
import com.usesoft.highcharts4gwt.client.view.center.CenterViewHighcharts;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class CenterActivityHighcharts extends BaseActivity<CenterViewHighcharts> implements CenterViewHighcharts.Presenter, ClickEventHandler
{
    @Inject
    private ChartOptionsVisitor chartOptions;
    
    @Inject
    private ChartCodeVisitor chartCode;
    
    
    private Chart chart;

    private HandlerRegistration registration;

    @Inject
    public CenterActivityHighcharts(@Assisted Chart chart)
    {
        this.chart = chart;
    }

    @Override
    protected void onStart()
    {
        registration = getEventBus().addHandler(ClickGWTEvent.getType(), this);
        chartOptions.setEventBus(getEventBus());
        
        getView().setPresenter(this);
        getView().addCode(chart.accept(chartCode, null));
        getView().renderChart(chart.accept(chartOptions, null));
        
    }

    @Override
    protected void onDispose()
    {
        registration.removeHandler();
    }

    @Override
    public boolean onClick(ClickGWTEvent clickEvent)
    {
        Series series = clickEvent.getSeries();
        ArrayNumber dataAsArrayNumber = series.dataAsArrayNumber();
        return false;
    }

}
