package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.NorthActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.WestActivityMapper;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;

@GinModules(MyModule.class)
public interface MyGinjector extends Ginjector
{
    RootView.Presenter getRootPresenter();

    PlaceControllerHolder getPlaceControllerHolder();

    AppPlaceHistoryMapper getAppPlaceHistoryMapper();

    NorthActivityMapper getNorthActivityMapper();

    WestActivityMapper getWestActivityMapper();
}
