package com.github.highcharts4gwt.client.infrastructure.injection.copy;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.logic.activitymapper.center.CenterActivityMapper;
import com.github.highcharts4gwt.client.logic.activitymapper.east.EastActivityMapper;
import com.github.highcharts4gwt.client.logic.activitymapper.north.NorthActivityMapper;
import com.github.highcharts4gwt.client.logic.activitymapper.south.SouthActivityMapper;
import com.github.highcharts4gwt.client.logic.activitymapper.west.WestActivityMapper;
import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.model.highcharts.Chart;
import com.github.highcharts4gwt.client.view.region.Region;
import com.github.highcharts4gwt.client.view.rootlayout.RootView;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class ApplicationContextImpl implements ApplicationContext
{

    private final PlaceHistoryHandler historyHandler;
    private final PlaceController placeController;
    private final EventBus defaultBus;

    @Inject
    public ApplicationContextImpl(EventBus eventBus, PlaceHistoryMapper phMapper, RootView.Presenter rootPresenter, NorthActivityMapper northActivityMapper,
            EastActivityMapper eastActivityMapper, WestActivityMapper westActivityMapper, CenterActivityMapper centerActivityMapper,
            SouthActivityMapper southActivityMapper)
    {
        this.defaultBus = eventBus;
        historyHandler = new PlaceHistoryHandler(phMapper);
        placeController = new PlaceController(eventBus);
        historyHandler.register(placeController, defaultBus, new ChartPlace(Chart.ColumnLineAndPie.getUrlId()));

        rootPresenter.start(eventBus);

        // @rqu this must be called after root presenter starts -> creates the
        // regions
        // Cannot inject appContext inside ActivityProviders because they are
        // created here -> infinite loop creating appContex.
        initializeManagers(rootPresenter, defaultBus, northActivityMapper, eastActivityMapper, westActivityMapper, centerActivityMapper, southActivityMapper);

        RootLayoutPanel.get().add(rootPresenter.getView().asWidget());
    }

    @Override
    public PlaceController getPlaceController()
    {
        return placeController;
    }

    @Override
    public PlaceHistoryHandler getHistoryHandler()
    {
        return historyHandler;
    }

    private void initializeManagers(RootView.Presenter rootPresenter, EventBus eventBus, NorthActivityMapper northActivityMapper,
            EastActivityMapper eastActivityMapper, WestActivityMapper westActivityMapper, CenterActivityMapper centerActivityMapper,
            SouthActivityMapper southActivityMapper)
    {
        // Initialize a manager per region
        ActivityManager northActivityManager = new ActivityManager(northActivityMapper, eventBus);
        northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));

        ActivityManager westActivityManager = new ActivityManager(westActivityMapper, eventBus);
        westActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.West));

        ActivityManager southActivityManager = new ActivityManager(southActivityMapper, eventBus);
        southActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.South));

        ActivityManager eastActivityManager = new ActivityManager(eastActivityMapper, eventBus);
        eastActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.East));

        ActivityManager centerActivityManager = new ActivityManager(centerActivityMapper, eventBus);
        centerActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.Center));
    }

}
