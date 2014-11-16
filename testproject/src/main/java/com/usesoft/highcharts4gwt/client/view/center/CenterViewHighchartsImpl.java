package com.usesoft.highcharts4gwt.client.view.center;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;

public class CenterViewHighchartsImpl extends Composite implements CenterViewHighcharts
{
    private Presenter presenter;
    
    @UiField
    HighchartsLayoutPanel chartPanel;
    
    @Inject
    public CenterViewHighchartsImpl(Binder binder)
    {
        initWidget(binder.createAndBindUi(this));
        this.addStyleName("composite-ronan");
        chartPanel.addStyleName("cahrtpanel-ronan");
    }

    @UiTemplate("CenterViewHighcharts.ui.xml")
    interface Binder extends UiBinder<Widget, CenterViewHighchartsImpl>
    {

    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void renderChart(ChartOptions options)
    {
        chartPanel.renderChart(options);
    }

}
