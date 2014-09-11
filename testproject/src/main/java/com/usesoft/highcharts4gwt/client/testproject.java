package com.usesoft.highcharts4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.array.jso.JsoArrayNumber;
import com.usesoft.highcharts4gwt.model.array.jso.JsoArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoSeries;

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

        JsoChartOptions options = (JsoChartOptions) JavaScriptObject.createObject();

        options.subtitle().text("sub ronan");
        options.title().text("Title");

        ArrayString months = (JsoArrayString) JsArrayString.createArray();
        months.push("janvier");
        months.push("fev");
        months.push("mars");
        months.push("avril");
        options.lang().months(months);

        // Options options = factory.create();
        // options.title().text("Test Ronan 2");

        JsoSeries value = (JsoSeries) JavaScriptObject.createObject();
        JsoArrayNumber data = (JsoArrayNumber) JsArrayNumber.createArray();
        data.insert(0, 10);
        data.insert(0, 20);
        data.insert(0, 30);
        data.insert(0, 40);
        data.insert(0, 50);
        value.data(data);

        Array<Series> series = options.series();

        series.addToEnd(value);

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
