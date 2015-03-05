package com.github.highcharts4gwt.client.model.highcharts;

public interface ChartVisitor<IN, OUT>
{
    OUT visitChart3D (IN in);
    
    OUT visitBasicLine (IN in);

    OUT visitBasicArea (IN in);
    
    OUT visitBasicBar (IN in);
    
    OUT visitSolidGauge (IN in);

    OUT visitColumnLineAndPie (IN in);
    
    OUT visitPolarChart (IN in);
}
