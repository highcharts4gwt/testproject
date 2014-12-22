package com.github.highcharts4gwt.client.view.rootlayout;

import com.github.highcharts4gwt.client.view.region.Region;
import com.github.highcharts4gwt.client.view.region.RegionContainer;
import com.google.gwt.user.client.ui.IsWidget;

public interface RootView extends IsWidget
{
    void setRegionVisibility(Region region, boolean visible);

    RegionContainer getRegion(Region region);

    interface Presenter extends com.github.highcharts4gwt.client.logic.presenter.Presenter<RootView>
    {

    }
}
