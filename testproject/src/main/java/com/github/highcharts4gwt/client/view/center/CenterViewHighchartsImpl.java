package com.github.highcharts4gwt.client.view.center;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.github.highcharts4gwt.model.highcharts.option.api.ChartOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class CenterViewHighchartsImpl extends Composite implements CenterViewHighcharts
{
    private Presenter presenter;
    
    @UiField
    HighchartsLayoutPanel chartPanel;
    
    @UiField
    SimpleLayoutPanel codePanel;
    
    @Inject
    public CenterViewHighchartsImpl(Binder binder)
    {
        initWidget(binder.createAndBindUi(this));
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

    @Override
    public void addCode(String code)
    {
        TextArea textArea = new TextArea();
        textArea.setReadOnly(true);
        textArea.setWidth("100%");
        textArea.setHeight("100%");
        textArea.setText(code);
        codePanel.add(textArea);
    }

}
