package com.github.highcharts4gwt.client.logic.activitymapper;

import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.logic.place.HighMapsPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ChartPlace.Tokenizer.class, HighMapsPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
