package com.github.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.model.highcharts.Chart;
import com.github.highcharts4gwt.client.model.highcharts.ChartCodeVisitor;
import com.github.highcharts4gwt.client.model.highcharts.ChartOptionsVisitor;
import com.github.highcharts4gwt.client.view.center.CenterViewHighcharts;
import com.google.inject.assistedinject.Assisted;

public class CenterActivityHighcharts extends BaseActivity<CenterViewHighcharts> implements CenterViewHighcharts.Presenter
{
    @Inject
    private ChartOptionsVisitor chartOptions;
    
    @Inject
    private ChartCodeVisitor chartCode;
    
    private Chart chart;

    @Inject
    public CenterActivityHighcharts(@Assisted Chart chart)
    {
        this.chart = chart;
    }

    @Override
    protected void onStart()
    {
        getView().setPresenter(this);
        getView().addCode(chart.accept(chartCode, null));
        getView().renderChart(chart.accept(chartOptions, null));
    }

    @Override
    protected void onDispose()
    {
    }
}
