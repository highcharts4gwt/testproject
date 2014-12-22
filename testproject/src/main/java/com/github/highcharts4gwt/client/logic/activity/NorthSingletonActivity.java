package com.github.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.infrastructure.injection.copy.ApplicationContext;
import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.github.highcharts4gwt.client.view.north.HeaderView;
import com.google.gwt.user.client.Window;

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
        applicationContext.getPlaceController().goTo(new ChartPlace("navigated"));
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

    @Override
    public void navigateGithub()
    {
        Window.Location.assign("http://highcharts4gwt.github.io/");
    }

}
