package com.usesoft.highcharts4gwt.client.view.center;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;

public class HighchartsCenterViewImpl extends Composite implements HighchartsCenterView
{
    private Presenter presenter;
    
    @Inject
    @UiField
    HighchartsLayoutPanel chartPanel;
    
    @Inject
    public HighchartsCenterViewImpl(WestViewUiBinder binder)
    {
        initWidget(binder.createAndBindUi(this));
    }

    @UiTemplate("HighchartsCenterView.ui.xml")
    interface WestViewUiBinder extends UiBinder<Widget, HighchartsCenterViewImpl>
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
