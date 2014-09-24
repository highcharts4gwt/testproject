package com.usesoft.highcharts4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoChartOptions;

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

        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();
        
        options.subtitle().text("Chart reflow is set to true");
        options.title().text("Chart reflow is set to true");

        Series series = (Series) JavaScriptObject.createObject();
        
        ArrayNumber data = series.data();
		data.push(29.9);
        data.push(71.5);
        data.push(106.4);
        data.push(129.2);
        data.push(144.0);
        data.push(176.0);
        data.push(135.6);
        data.push(148.5);
        data.push(216.4);
        data.push(194.1);
        data.push(95.6);
        data.push(54.4);

        options.series().addToEnd(series);
        
        ArrayString categories = options.xAxis().categories();
		categories.push("Jan");
        categories.push("Feb");
        categories.push("Mar");
        categories.push("Apr");
        categories.push("May");
        categories.push("Jun");
        categories.push("Jul");
        categories.push("Aug");
        categories.push("Sep");
        categories.push("Oct");
        categories.push("Nov");
        categories.push("Dec");
 
        container.renderChart(options);

    }
}
