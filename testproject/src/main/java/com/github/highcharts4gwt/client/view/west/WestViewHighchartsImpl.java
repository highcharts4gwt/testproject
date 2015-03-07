package com.github.highcharts4gwt.client.view.west;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.model.highcharts.ChartCategory;
import com.github.highcharts4gwt.client.model.highcharts.ChartExample;
import com.github.highcharts4gwt.client.view.resources.MyResources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WestViewHighchartsImpl extends ScrollPanel implements WestViewHighcharts
{
    private Presenter presenter;
    private MyResources resources;
    private VerticalPanel container;
    
    @Inject
    public WestViewHighchartsImpl(MyResources resources)
    {
        this.resources = resources;
        container = new VerticalPanel();
        this.add(container);
    }
    
    @Override
    public void addLink(final ChartExample chart)
    {
        FocusPanel focus = new FocusPanel();
        Label label = new Label(chart.getLinkText());
        label.addStyleName(resources.myStyle().link()); 
        
        focus.add(label);
        
        focus.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                presenter.navigateTo(chart);
            }
        });
        
        container.add(focus);
    }
    
    @Override
    public void addCategory(ChartCategory category)
    {
        Label label = new Label(category.getCategoryDescription());
        label.addStyleName(resources.myStyle().category());
        container.add(label);
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
}
