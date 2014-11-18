package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

public interface ApplicationContext
{
    PlaceController getPlaceController();

    PlaceHistoryHandler getHistoryHandler();
}
