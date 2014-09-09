package com.usesoft.highcharts4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.generated.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.generated.highcharts.jso.JsoChartOptions;

public class testproject implements EntryPoint
{

    public void onModuleLoad()
    {
        DockLayoutPanel dlp = new DockLayoutPanel(Unit.PX);

        HighchartsLayoutPanel container = new HighchartsLayoutPanel();

        dlp.addNorth(new Label("North"), 100);
        dlp.addWest(new Label("West"), 100);
        dlp.addSouth(new Label("South"), 100);

        dlp.add(container);

        RootLayoutPanel.get().add(dlp);

        // OptionsFactory factory = new OptionsFactoryJso();

        ChartOptions options = (JsoChartOptions) JavaScriptObject.createObject();

        options.subtitle().text("sub ronan");
        options.title().text("Title");

        // Options options = factory.create();
        // options.title().text("Test Ronan 2");

        container.renderChart(options);

        // Timer timer = new Timer() {
        //
        // @Override
        // public void run() {
        // chart.options().title().text("update");
        //
        // }
        // };
        //
        // timer.schedule(5000);
    }
}
