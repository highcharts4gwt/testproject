package com.github.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.Place;


public abstract class BasePlace extends Place
{
    public abstract <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in);
}
