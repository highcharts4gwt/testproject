package com.usesoft.highcharts4gwt.client.logic.activitymapper.south;


import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.usesoft.highcharts4gwt.client.logic.place.ChartPlace;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class SouthPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
  
    @Override
    public Activity visit(ChartPlace place1, Void in)
    {
        return null;
    }

    @Override
    public Activity visit(HighMapsPlace place2, Void in)
    {
        return null;
    }

}
