package com.usesoft.highcharts4gwt.client.view.region;

import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;

public interface RegionContainer extends HasOneWidget, IsWidget
{
    void setVisible(boolean visibility);

    void setStyleName(String style);

    RootView getRootView();

    void setRootView(RootView rootView);

    void setRegion(Region region);

    Region getRegion();
}
