package com.usesoft.highcharts4gwt.client.logic.model.highcharts;

public interface ChartVisitor<IN, OUT>
{
    OUT visitChart3D (IN in);
    
    OUT visitChart1 (IN in);
    
    OUT visitChart2 (IN in);
}
