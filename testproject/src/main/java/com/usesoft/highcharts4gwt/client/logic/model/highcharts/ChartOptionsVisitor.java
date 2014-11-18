package com.usesoft.highcharts4gwt.client.logic.model.highcharts;

import com.google.gwt.core.client.JavaScriptObject;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

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

}
