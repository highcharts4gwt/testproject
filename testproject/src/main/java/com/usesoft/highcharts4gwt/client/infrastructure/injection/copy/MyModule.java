package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import javax.inject.Singleton;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.usesoft.highcharts4gwt.client.logic.activity.WestActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.activity.NorthSingletonActivity;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.north.NorthPlaceToActivityVisitor;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.west.WestPlaceToActivityVisitor;
import com.usesoft.highcharts4gwt.client.logic.presenter.RootPresenter;
import com.usesoft.highcharts4gwt.client.view.center.HighchartsCenterView;
import com.usesoft.highcharts4gwt.client.view.center.HighchartsCenterViewImpl;
import com.usesoft.highcharts4gwt.client.view.north.HeaderView;
import com.usesoft.highcharts4gwt.client.view.north.HeaderViewImpl;
import com.usesoft.highcharts4gwt.client.view.region.RegionContainer;
import com.usesoft.highcharts4gwt.client.view.region.SimpleLayoutPanelRegionContainer;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootViewImpl;
import com.usesoft.highcharts4gwt.client.view.west.WestView1;
import com.usesoft.highcharts4gwt.client.view.west.WestView1Impl;

public class MyModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        // Views
        bind(RootView.class).to(RootViewImpl.class).in(Singleton.class);
        bind(RegionContainer.class).to(SimpleLayoutPanelRegionContainer.class);

        bind(WestView1.class).to(WestView1Impl.class);
        bind(HeaderView.class).to(HeaderViewImpl.class);
        bind(HighchartsCenterView.class).to(HighchartsCenterViewImpl.class);

        // Presenters
        bind(RootView.Presenter.class).to(RootPresenter.class).in(Singleton.class);

        bind(AppPlaceHistoryMapper.class);
        bind(PlaceControllerHolder.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class);

        bind(NorthPlaceToActivityVisitor.class);
        bind(WestActivityHighcharts.class);

        bind(WestPlaceToActivityVisitor.class);
        // Make this activity a singleton to always use the same activity in west region
        bind(NorthSingletonActivity.class).in(Singleton.class);
        
        
    }

}
