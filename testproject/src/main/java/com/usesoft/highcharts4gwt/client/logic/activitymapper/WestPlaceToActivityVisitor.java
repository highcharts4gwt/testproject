package com.usesoft.highcharts4gwt.client.logic.activitymapper;


import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.activity.WestSingletonActivity;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class WestPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<WestSingletonActivity> provider;

    @Override
    public Activity visit(Highcharts place1, Void in)
    {
        return provider.get();
    }

    @Override
    public Activity visit(HighMaps place2, Void in)
    {
        return provider.get();
    }

}
