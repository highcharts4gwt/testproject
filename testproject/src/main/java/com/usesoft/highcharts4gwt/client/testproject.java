package com.usesoft.highcharts4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.array.api.Array;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.array.jso.JsoArrayNumber;
import com.usesoft.highcharts4gwt.model.array.jso.JsoArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Lang;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.Subtitle;
import com.usesoft.highcharts4gwt.model.highcharts.api.Title;
import com.usesoft.highcharts4gwt.model.highcharts.api.XAxis;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoLang;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoSeries;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoSubtitle;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoTitle;
import com.usesoft.highcharts4gwt.model.highcharts.jso.JsoXAxis;

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
        
        Subtitle subTitle = (JsoSubtitle) JavaScriptObject.createObject();
        subTitle.text("Chart reflow is set to true");

        Title title = (JsoTitle) JavaScriptObject.createObject();
        title.text("When resizing the window or the frame, the chart should resize");
        
        options.subtitle(subTitle);
        options.title(title);

        ArrayString months = (JsoArrayString) JsArrayString.createArray();
        months.push("janvier");
        months.push("fev");
        months.push("mars");
        months.push("avril");
        
        Lang lang = (JsoLang) JavaScriptObject.createObject();
        lang.months(months);
        options.lang(lang);

        // Options options = factory.create();
        // options.title().text("Test Ronan 2");

        Series value = (JsoSeries) JavaScriptObject.createObject();
        
        ArrayNumber data = (JsoArrayNumber) JsArrayNumber.createArray();
        
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
        
        
        value.data(data);

        Array<Series> series = (Array<Series>) JsArray.createArray();
        
        series.addToEnd(value);
        
        XAxis xAxis = (JsoXAxis) JavaScriptObject.createObject();
        
        ArrayString categories = (JsoArrayString) JsArrayString.createArray();
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
        
		xAxis.categories(categories);
		
		options.xAxis(xAxis);
		options.series(series);
		
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
