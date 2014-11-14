package com.usesoft.highcharts4gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.highcharts4gwt.client.infrastructure.injection.copy.MyGinjector;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.view.region.Region;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class testproject implements EntryPoint
{ 
    private final MyGinjector injector = GWT.create(MyGinjector.class);
    
    public void onModuleLoad()
    {
        RootView.Presenter rootPresenter = injector.getRootPresenter();

        PlaceControllerHolder placeControllerHolder = injector.getPlaceControllerHolder();

        // Initialize a manager per region
        ActivityManager northActivityManager = new ActivityManager(injector.getNorthActivityMapper(), placeControllerHolder.getEventBus());
        northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));

        ActivityManager westActivityManager = new ActivityManager(injector.getWestActivityMapper(), placeControllerHolder.getEventBus());
        westActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.West));
        
        ActivityManager southActivityManager = new ActivityManager(injector.getSouthActivityMapper(), placeControllerHolder.getEventBus());
        southActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.South));
        
        ActivityManager eastActivityManager = new ActivityManager(injector.getEastActivityMapper(), placeControllerHolder.getEventBus());
        eastActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.East));
        
        ActivityManager centerActivityManager = new ActivityManager(injector.getCenterActivityMapper(), placeControllerHolder.getEventBus());
        centerActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.Center));
        

        // Do the same for center, south ...


        AppPlaceHistoryMapper historyMapper= injector.getAppPlaceHistoryMapper();
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeControllerHolder.getPlaceController(), placeControllerHolder.getEventBus(), new Highcharts("test"));

        RootLayoutPanel.get().add(rootPresenter.getView().asWidget());

        // Activate navigation history and go to default place
        historyHandler.handleCurrentHistory();
    }

   
}
