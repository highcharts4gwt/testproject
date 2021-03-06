package com.github.highcharts4gwt.client.view.region;

public interface RegionVisitor<IN, OUT>
{
    OUT visitNorth(IN in);

    OUT visitSouth(IN in);

    OUT visitEast(IN in);

    OUT visitWest(IN in);

    OUT visitCenter(IN in);
}
