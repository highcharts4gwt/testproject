package com.usesoft.highcharts4gwt.client.logic.activitymapper.center;


import javax.inject.Inject;
import javax.inject.Provider;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.activity.CenterActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class CenterPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    Provider<CenterActivityHighcharts> provider;
    
    @Override
    public Activity visit(Highcharts place1, Void in)
    {
        return provider.get();
    }

    @Override
    public Activity visit(HighMaps place2, Void in)
    {
        return null;
    }

}
