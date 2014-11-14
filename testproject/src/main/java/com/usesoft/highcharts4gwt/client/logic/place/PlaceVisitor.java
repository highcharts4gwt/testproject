package com.usesoft.highcharts4gwt.client.logic.place;

public interface PlaceVisitor<IN, OUT>
{
    OUT visit(Highcharts place, IN in);

    OUT visit(HighMaps place, IN in);
}
