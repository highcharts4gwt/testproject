package com.usesoft.highcharts4gwt.client.logic.activitymapper;


import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.activity.NorthActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class NorthPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<NorthActivityHighcharts> provider;

    @Override
    public Activity visit(Highcharts place, Void in)
    {
        return provider.get();
    }

    @Override
    public Activity visit(HighMaps place, Void in)
    {
        return null;
    }

}
