package com.usesoft.highcharts4gwt.client.logic.activitymapper.south;


import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class SouthPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
  
    @Override
    public Activity visit(Highcharts place1, Void in)
    {
        return null;
    }

    @Override
    public Activity visit(HighMaps place2, Void in)
    {
        return null;
    }

}
