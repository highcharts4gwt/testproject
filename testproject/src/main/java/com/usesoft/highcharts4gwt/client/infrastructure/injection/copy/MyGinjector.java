package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.center.CenterActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.east.EastActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.north.NorthActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.south.SouthActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.west.WestActivityMapper;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;

@GinModules(MyModule.class)
public interface MyGinjector extends Ginjector
{
    RootView.Presenter getRootPresenter();

    PlaceControllerHolder getPlaceControllerHolder();

    AppPlaceHistoryMapper getAppPlaceHistoryMapper();

    NorthActivityMapper getNorthActivityMapper();

    WestActivityMapper getWestActivityMapper();

    EastActivityMapper getEastActivityMapper();

    SouthActivityMapper getSouthActivityMapper();

    CenterActivityMapper getCenterActivityMapper();
}
