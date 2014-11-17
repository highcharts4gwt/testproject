package com.usesoft.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.assistedinject.Assisted;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.ChartOptionsVisitor;
import com.usesoft.highcharts4gwt.client.view.center.CenterViewHighcharts;

public class CenterActivityHighcharts extends BaseActivity<CenterViewHighcharts> implements Activity, CenterViewHighcharts.Presenter
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
    public void onStop()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(AcceptsOneWidget panel)
    {
        panel.setWidget(getView());
        getView().setPresenter(this);
        getView().renderChart(chart.accept(chartOptions, null));
    }

}
