package com.github.highcharts4gwt.client.view.rootlayout;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.view.region.Region;
import com.github.highcharts4gwt.client.view.region.RegionContainer;
import com.github.highcharts4gwt.client.view.region.RegionContainerGetterVisitor;
import com.github.highcharts4gwt.client.view.region.RegionVisibilityVisitor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class RootViewImpl extends Composite implements RootView
{
    @UiField
    DockLayoutPanel rootContainer;

    @Inject
    @UiField(provided = true)
    RegionContainer northRegionContainer;

    @Inject
    @UiField(provided = true)
    RegionContainer westRegionContainer;

     @Inject
     @UiField(provided = true)
     RegionContainer eastRegionContainer;
    
     @Inject
     @UiField(provided = true)
     RegionContainer southRegionContainer;

    @Inject
    @UiField(provided = true)
    RegionContainer centerRegionContainer;

    private RegionVisibilityVisitor regionVisibilityVisitor;

    private RegionContainerGetterVisitor regionContainerGetter;

    @UiTemplate("RootView.ui.xml")
    interface RootViewUiBinder extends UiBinder<Widget, RootViewImpl>
    {
    }

    @Inject
    void init(RootViewUiBinder binder)
    {
        initWidget(binder.createAndBindUi(this));
        regionVisibilityVisitor = new RegionVisibilityVisitor(northRegionContainer, southRegionContainer, eastRegionContainer, westRegionContainer,
                        centerRegionContainer, rootContainer);
        regionContainerGetter = new RegionContainerGetterVisitor(northRegionContainer, southRegionContainer, eastRegionContainer, westRegionContainer,
                        centerRegionContainer);

        northRegionContainer.setRootView(this);
        westRegionContainer.setRootView(this);
        eastRegionContainer.setRootView(this);
        southRegionContainer.setRootView(this);
        centerRegionContainer.setRootView(this);

        northRegionContainer.setRegion(Region.North);
        westRegionContainer.setRegion(Region.West);
        eastRegionContainer.setRegion(Region.East);
        southRegionContainer.setRegion(Region.South);
        centerRegionContainer.setRegion(Region.Center);
        
        
        northRegionContainer.setWidget(null);
        westRegionContainer.setWidget(null);
        eastRegionContainer.setWidget(null);
        southRegionContainer.setWidget(null);
        centerRegionContainer.setWidget(null);
    }

    @Override
    public void setRegionVisibility(Region region, boolean visible)
    {
        region.accept(regionVisibilityVisitor, visible);
    }

    @Override
    public RegionContainer getRegion(Region region)
    {
        return region.accept(regionContainerGetter, null);
    }

}
