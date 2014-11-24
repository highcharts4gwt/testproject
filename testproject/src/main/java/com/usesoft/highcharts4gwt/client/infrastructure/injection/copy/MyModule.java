package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import javax.inject.Singleton;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.usesoft.highcharts4gwt.client.logic.activity.CenterActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.activity.CenterActivityHighchartsFactory;
import com.usesoft.highcharts4gwt.client.logic.activity.NorthSingletonActivity;
import com.usesoft.highcharts4gwt.client.logic.activity.WestActivityHighcharts;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.center.CenterActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.east.EastActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.north.NorthActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.north.NorthPlaceToActivityVisitor;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.south.SouthActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.west.WestActivityMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.west.WestPlaceToActivityVisitor;
import com.usesoft.highcharts4gwt.client.logic.presenter.RootPresenter;
import com.usesoft.highcharts4gwt.client.view.center.CenterViewHighcharts;
import com.usesoft.highcharts4gwt.client.view.center.CenterViewHighchartsImpl;
import com.usesoft.highcharts4gwt.client.view.north.HeaderView;
import com.usesoft.highcharts4gwt.client.view.north.HeaderViewImpl;
import com.usesoft.highcharts4gwt.client.view.region.RegionContainer;
import com.usesoft.highcharts4gwt.client.view.region.SimpleLayoutPanelRegionContainer;
import com.usesoft.highcharts4gwt.client.view.resources.MyResources;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootViewImpl;
import com.usesoft.highcharts4gwt.client.view.west.WestViewHighcharts;
import com.usesoft.highcharts4gwt.client.view.west.WestViewHighchartsImpl;

public class MyModule extends AbstractGinModule
{
    @Override
    protected void configure()
    {
        bind(MyResources.class).in(Singleton.class);
        
        // Views
        bind(RootView.class).to(RootViewImpl.class).in(Singleton.class);
        bind(RegionContainer.class).to(SimpleLayoutPanelRegionContainer.class);

        bind(WestViewHighcharts.class).to(WestViewHighchartsImpl.class);
        bind(HeaderView.class).to(HeaderViewImpl.class);
        bind(CenterViewHighcharts.class).to(CenterViewHighchartsImpl.class);
        

        // Presenters
        bind(RootView.Presenter.class).to(RootPresenter.class).in(Singleton.class);
        
        bind(NorthActivityMapper.class).in(Singleton.class);
        bind(SouthActivityMapper.class).in(Singleton.class);
        bind(EastActivityMapper.class).in(Singleton.class);
        bind(WestActivityMapper.class).in(Singleton.class);
        bind(CenterActivityMapper.class).in(Singleton.class);

        bind(PlaceHistoryMapper.class).to(AppPlaceHistoryMapper.class);
        //bind(AppPlaceHistoryMapper.class);
        bind(ApplicationContext.class).to(ApplicationContextImpl.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class);

        bind(NorthPlaceToActivityVisitor.class);
        bind(WestActivityHighcharts.class);

        bind(WestPlaceToActivityVisitor.class);
        // Make this activity a singleton to always use the same activity in west region
        bind(NorthSingletonActivity.class).in(Singleton.class);
        
        install(new GinFactoryModuleBuilder().implement(Activity.class, CenterActivityHighcharts.class).build(CenterActivityHighchartsFactory.class));
    
    }

}
