package com.usesoft.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.usesoft.highcharts4gwt.client.infrastructure.injection.copy.ApplicationContext;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;
import com.usesoft.highcharts4gwt.client.logic.place.HighchartsPlace;
import com.usesoft.highcharts4gwt.client.view.west.WestViewHighcharts;

public class WestActivityHighcharts extends BaseActivity<WestViewHighcharts> implements WestViewHighcharts.Presenter
{
    private ApplicationContext applicationContext;

    @Inject
    public WestActivityHighcharts(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }
    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart()
    {
        getView().setPresenter(this);
        
        for (Chart chart : Chart.values())
        {
            getView().addLink(chart);
        }
    }

    @Override
    protected void onDispose()
    {
        
    }

    @Override
    public void navigateTo(Chart chart)
    {
        applicationContext.getPlaceController().goTo(new HighchartsPlace(chart.getUrlId()));
    }

}
