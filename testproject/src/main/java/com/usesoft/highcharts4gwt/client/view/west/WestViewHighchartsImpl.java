package com.usesoft.highcharts4gwt.client.view.west;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;

public class WestViewHighchartsImpl extends VerticalPanel implements WestViewHighcharts
{
    private Presenter presenter;

    public WestViewHighchartsImpl()
    {
        
    }
    
    @Override
    public void addLink(final Chart chart)
    {
        FocusPanel focus = new FocusPanel();
        Label label = new Label(chart.getLinkText());
        label.addStyleName("link"); //TODO us css resource
        
        focus.add(label);
        
        focus.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent event)
            {
                presenter.navigateTo(chart);
            }
        });
        
        this.add(focus);
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }
}
