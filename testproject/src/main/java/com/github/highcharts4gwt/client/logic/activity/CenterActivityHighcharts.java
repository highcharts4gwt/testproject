package com.github.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.model.event.ChartRenderedEvent;
import com.github.highcharts4gwt.client.model.highcharts.ChartCodeVisitor;
import com.github.highcharts4gwt.client.model.highcharts.ChartExample;
import com.github.highcharts4gwt.client.model.highcharts.ChartOptionsVisitor;
import com.github.highcharts4gwt.client.view.center.CenterViewHighcharts;
import com.github.highcharts4gwt.model.highcharts.object.api.Chart;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.HandlerRegistration;

public class CenterActivityHighcharts extends BaseActivity<CenterViewHighcharts> implements CenterViewHighcharts.Presenter, ChartRenderedEvent.Handler
{
    @Inject
    private ChartOptionsVisitor chartOptions;
    
    @Inject
    private ChartCodeVisitor chartCode;
    
    private ChartExample chartExample;

    private HandlerRegistration registration;

    @Inject
    public CenterActivityHighcharts(@Assisted ChartExample chartExample)
    {
        this.chartExample = chartExample;
    }

    @Override
    protected void onStart()
    {
        registration = getEventBus().addHandler(ChartRenderedEvent.getType(), this);
        
        getView().setPresenter(this);
        getView().addCode(chartExample.accept(chartCode, null));
        getView().renderChart(chartExample.accept(chartOptions, null));
    }

    @Override
    protected void onDispose()
    {
        registration.removeHandler();
        registration = null;
    }

    @Override
    public void onChartRendered(Chart chart)
    {
        //Window.alert("Chart Rendered");
    }
}
