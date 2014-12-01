package com.usesoft.highcharts4gwt.client.logic.activitymapper.west;


import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.activity.WestActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.usesoft.highcharts4gwt.client.logic.place.ChartPlace;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class WestPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<WestActivityHighcharts> provider;

    @Override
    public Activity visit(ChartPlace place1, Void in)
    {
        return provider.get();
    }

    @Override
    public Activity visit(HighMapsPlace place2, Void in)
    {
        return null;
    }

}
