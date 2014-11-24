package com.usesoft.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;
import com.usesoft.highcharts4gwt.client.model.highcharts.Chart;
import com.usesoft.highcharts4gwt.client.model.highcharts.ChartOptionsVisitor;
import com.usesoft.highcharts4gwt.client.view.center.CenterViewHighcharts;

public class CenterActivityHighcharts extends BaseActivity<CenterViewHighcharts> implements CenterViewHighcharts.Presenter
{
    @Inject
    ChartOptionsVisitor chartOptions;
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
        getView().renderChart(chart.accept(chartOptions, null));
    }

    @Override
    protected void onDispose()
    {
    }

}
