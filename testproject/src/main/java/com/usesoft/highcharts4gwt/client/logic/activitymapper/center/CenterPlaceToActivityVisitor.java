package com.usesoft.highcharts4gwt.client.logic.activitymapper.center;


import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.usesoft.highcharts4gwt.client.logic.activity.CenterActivityHighchartsFactory;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;
import com.usesoft.highcharts4gwt.client.logic.place.HighMaps;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.logic.place.PlaceVisitor;

public class CenterPlaceToActivityVisitor implements PlaceVisitor<Void, Activity>
{
    @Inject
    CenterActivityHighchartsFactory factory;
    
    @Override
    public Activity visit(Highcharts place1, Void in)
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
    public Activity visit(HighMaps place2, Void in)
    {
        return null;
    }

}
