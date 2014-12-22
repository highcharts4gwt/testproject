package com.github.highcharts4gwt.client.logic.activitymapper.center;


import javax.inject.Inject;

import com.github.highcharts4gwt.client.logic.activity.CenterActivityHighchartsFactory;
import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.github.highcharts4gwt.client.logic.place.PlaceVisitor;
import com.github.highcharts4gwt.client.model.highcharts.Chart;
import com.google.gwt.activity.shared.Activity;

public class CenterPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    CenterActivityHighchartsFactory factory;
    
    @Override
    public Activity visit(ChartPlace place1, Void in)
    {
        String chartName = place1.getChartName();
        
        try
        {
            Chart chart = Chart.valueOf(chartName);
            return factory.create(chart);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Activity visit(HighMapsPlace place2, Void in)
    {
        return null;
    }

}
