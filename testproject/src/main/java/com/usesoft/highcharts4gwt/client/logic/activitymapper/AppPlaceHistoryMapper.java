package com.usesoft.highcharts4gwt.client.logic.activitymapper;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.usesoft.highcharts4gwt.client.logic.place.ChartPlace;
import com.usesoft.highcharts4gwt.client.logic.place.HighMapsPlace;

@WithTokenizers({ ChartPlace.Tokenizer.class, HighMapsPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
