package com.usesoft.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.usesoft.highcharts4gwt.client.infrastructure.injection.copy.ApplicationContext;
import com.usesoft.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.usesoft.highcharts4gwt.client.logic.place.HighchartsPlace;
import com.usesoft.highcharts4gwt.client.view.north.HeaderView;

public class NorthSingletonActivity extends BaseActivity<HeaderView> implements HeaderView.Presenter
{
    @Inject
    ApplicationContext applicationContext;

    @Override
    public void onStop()
    {
    }

    @Override
    public void onStart()
    {
        getView().setPresenter(this);
    }

    @Override
    public void navigateToHighcharts()
    {
        applicationContext.getPlaceController().goTo(new HighchartsPlace("navigated"));
    }

    @Override
    public void navigateToHighMaps()
    {
        applicationContext.getPlaceController().goTo(new HighMapsPlace("navigated"));
    }

    @Override
    protected void onDispose()
    {
        
    }

}
