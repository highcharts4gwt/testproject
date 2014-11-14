package com.usesoft.highcharts4gwt.client.logic.activitymapper.north;


import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.activity.NorthSingletonActivity;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class NorthPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<NorthSingletonActivity> provider;

    @Override
    public Activity visit(Highcharts place, Void in)
    {
        return provider.get();
    }

    @Override
    public Activity visit(HighMaps place, Void in)
    {
        return provider.get();
    }

}
