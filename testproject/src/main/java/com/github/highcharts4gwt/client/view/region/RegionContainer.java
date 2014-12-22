package com.github.highcharts4gwt.client.view.region;

import com.github.highcharts4gwt.client.view.rootlayout.RootView;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface RegionContainer extends HasOneWidget, IsWidget
{
    void setVisible(boolean visibility);

    void setStyleName(String style);

    RootView getRootView();

    void setRootView(RootView rootView);

    void setRegion(Region region);

    Region getRegion();
}
