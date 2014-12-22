package com.github.highcharts4gwt.client.logic.activitymapper.north;


import javax.inject.Inject;
import javax.inject.Provider;

import com.github.highcharts4gwt.client.logic.activity.NorthSingletonActivity;
import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.github.highcharts4gwt.client.logic.place.PlaceVisitor;
import com.google.gwt.activity.shared.Activity;

public class NorthPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<NorthSingletonActivity> provider;

    @Override
    public Activity visit(ChartPlace place, Void in)
    {
        return provider.get();
    }

    @Override
    public Activity visit(HighMapsPlace place, Void in)
    {
        return provider.get();
    }

}
