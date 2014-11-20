package com.usesoft.highcharts4gwt.client.logic.model.highcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;
import com.usesoft.highcharts4gwt.model.highcharts.api.xaxis.PlotLine;

public class ChartOptionsVisitor implements ChartVisitor<Void, ChartOptions>
{

    @Override
    public ChartOptions visitChart3D(Void in)
    {
        // http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/chart/type-bar/

        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();
        options.chart().type("column");
        options.chart().margin().push(75);
        options.chart().options3d().enabled(true).alpha(15).beta(15).depth(50).viewDistance(25);

        options.subtitle().text("Subtitle 3D");
        options.title().text("Title 3D");

        options.plotOptions().column().depth(25);

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

        return options;
    }

    @Override
    public ChartOptions visitChart1(Void in)
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();
        
        options.chart().type("column");
        options.colors().insert(0, "#008dd3");
        options.chart().zoomType("x").resetZoomButton().relativeTo("plot").position("{\"verticalAlign\": \"bottom\",\"align\": \"left\"}");
        options.subtitle().text("Chart reflow is set to true");
        options.title().text("Chart reflow is set to true");

        options.legend().itemHoverStyle("{\"color\": \"#FF0000\"}");

        options.legend().borderWidth(3);

        options.legend().title().style("{\"fontWeight\":\"bold\"}");
        options.legend().title().text("Legend title");
        options.legend().borderColor("green").borderWidth(1);
        options.legend().backgroundColor("#FFFFFF");
        options.legend().shadowAsJsonString("{\"color\":\"red\",\"offsetX\":\"10\",\"offsetY\":\"10\",\"opacity\":\"0.5\",\"width\":\"5\"}");

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
        return options;
    }

    @Override
    public ChartOptions visitChart2(Void in)
    {
     // http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/chart/type-bar/

        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();
        options.chart().type("bar");

        options.legend().layout("vertical").floating(true).align("center").verticalAlign("top");

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

        return options;
    }

    @Override
    public ChartOptions visitBasicLine(Void in)
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();
        
        options.title().text("Monthly Average Temperature").x(-20);
        options.subtitle().text("Source: WorldClimate.com").x(-20);
        
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
        
        options.yAxis().title().text("Temperature (°C)");
        
        PlotLine plotLine = (PlotLine) JavaScriptObject.createObject();
        plotLine.value(0).width(1).color("#808080");
        options.yAxis().plotLines().addToEnd(plotLine);
        
        options.tooltip().valueSuffix("°C");
        options.legend().layout("vertical").align("right").verticalAlign("middle").borderWidth(0);
        
        Series series1 = (Series) JavaScriptObject.createObject();
        ArrayNumber data = series1.data();
        data.push(7.0); data.push(6.9); data.push(9.5); data.push(14.5); data.push(18.2); data.push(21.5); data.push(25.2); data.push(26.5); data.push(23.3); data.push(18.3); data.push(13.9); data.push(9.6);
        series1.name("Tokyo");
        
        Series series2 = (Series) JavaScriptObject.createObject();
        ArrayNumber data2 = series2.data();
        data2.push(-0.2); data2.push(0.8); data2.push(5.7); data2.push(11.3); data2.push(17.0); data2.push(22.0); data2.push(24.8); data2.push(24.1); data2.push(20.1); data2.push(14.1); data2.push(8.6); data2.push(2.5);
        series2.name("New York");
        
        Series series3 = (Series) JavaScriptObject.createObject();
        ArrayNumber data3 = series3.data();
        data3.push(-0.9); data3.push(0.6); data3.push(3.5); data3.push(8.4); data3.push(13.5); data3.push(17.0); data3.push(18.6); data3.push(17.9); data3.push(14.3); data3.push(9.0); data3.push(3.9); data3.push(1.0);
        series3.name("Berlin");
        
        Series series4 = (Series) JavaScriptObject.createObject();
        ArrayNumber data4 = series4.data();
        data4.push(3.9); data4.push(4.2); data4.push(5.7); data4.push(8.5); data4.push(11.9); data4.push(15.2); data4.push(17.0); data4.push(16.6); data4.push(14.2); data4.push(10.3); data4.push(6.6); data4.push(4.8);
        series4.name("London");
        
        options.series().addToEnd(series1);
        options.series().addToEnd(series2);
        options.series().addToEnd(series3);
        options.series().addToEnd(series4);
        
        return options;
    }

}
