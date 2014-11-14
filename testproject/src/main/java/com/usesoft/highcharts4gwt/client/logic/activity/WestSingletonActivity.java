package com.usesoft.highcharts4gwt.client.logic.activity;

import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.view.west.WestView;

public class WestSingletonActivity extends BaseActivity<WestView> implements Activity, WestView.Presenter
{
    @Inject
    PlaceControllerHolder placeControllerHolder;

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
    }

    @Override
    public void navigateToHighcharts()
    {
        placeControllerHolder.getPlaceController().goTo(new Highcharts("navigated"));
    }

    @Override
    public void navigateToHighMaps()
    {
        placeControllerHolder.getPlaceController().goTo(new HighMaps("navigated"));
    }

}
