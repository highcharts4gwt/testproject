package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.usesoft.highcharts4gwt.client.logic.activity.NorthActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.activity.WestSingletonActivity;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.NorthPlaceToActivityVisitor;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.WestPlaceToActivityVisitor;
import com.usesoft.highcharts4gwt.client.logic.presenter.RootPresenter;
import com.usesoft.highcharts4gwt.client.view.north.NorthView1;
import com.usesoft.highcharts4gwt.client.view.north.NothView1Impl;
import com.usesoft.highcharts4gwt.client.view.region.RegionContainer;
import com.usesoft.highcharts4gwt.client.view.region.SimpleLayoutPanelRegionContainer;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootViewImpl;
import com.usesoft.highcharts4gwt.client.view.west.WestView;
import com.usesoft.highcharts4gwt.client.view.west.WestViewImpl;

public class MyModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        // Views
        bind(RootView.class).to(RootViewImpl.class).in(Singleton.class);
        bind(RegionContainer.class).to(SimpleLayoutPanelRegionContainer.class);

        bind(NorthView1.class).to(NothView1Impl.class);
        bind(WestView.class).to(WestViewImpl.class);

        // Presenters
        bind(RootView.Presenter.class).to(RootPresenter.class).in(Singleton.class);

        bind(AppPlaceHistoryMapper.class);
        bind(PlaceControllerHolder.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class);

        bind(NorthPlaceToActivityVisitor.class);
        bind(NorthActivityHighcharts.class);

        bind(WestPlaceToActivityVisitor.class);
        // Make this activity a singleton to always use the same activity in west region
        bind(WestSingletonActivity.class).in(Singleton.class);
    }

}
