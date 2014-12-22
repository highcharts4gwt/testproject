package com.github.highcharts4gwt.client.logic.activitymapper.west;


import javax.inject.Inject;
import javax.inject.Provider;

import com.github.highcharts4gwt.client.logic.activity.WestActivityHighcharts;
import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.github.highcharts4gwt.client.logic.place.PlaceVisitor;
import com.google.gwt.activity.shared.Activity;

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
