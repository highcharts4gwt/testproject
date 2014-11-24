package com.usesoft.highcharts4gwt.client.model.highcharts;

public interface ChartVisitor<IN, OUT>
{
    OUT visitChart3D (IN in);
    
    OUT visitBasicLine (IN in);

    OUT visitBasicArea (IN in);
    
    OUT visitBasicBar (IN in);
    
    OUT visitSolidGauge (IN in);
}
