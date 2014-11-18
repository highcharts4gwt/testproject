package com.usesoft.highcharts4gwt.client.logic.place;

public interface PlaceVisitor<IN, OUT>
{
    OUT visit(HighchartsPlace place, IN in);

    OUT visit(HighMapsPlace place, IN in);
}
