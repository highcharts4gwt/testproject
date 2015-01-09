package com.github.highcharts4gwt.client.model.highcharts;

import com.github.highcharts4gwt.model.array.api.Array;
import com.github.highcharts4gwt.model.array.api.ArrayNumber;
import com.github.highcharts4gwt.model.array.api.ArrayString;
import com.github.highcharts4gwt.model.highcharts.option.api.ChartOptions;
import com.github.highcharts4gwt.model.highcharts.option.api.Series;
import com.github.highcharts4gwt.model.highcharts.option.api.labels.Item;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.column.ColumnClickEvent;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.column.ColumnClickHandler;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.pie.PieClickEvent;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.pie.PieClickHandler;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.series.SeriesClickEvent;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.series.SeriesClickHandler;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.spline.SplineClickEvent;
import com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.spline.SplineClickHandler;
import com.github.highcharts4gwt.model.highcharts.option.api.series.Data;
import com.github.highcharts4gwt.model.highcharts.option.api.yaxis.PlotLine;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

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

        options.title().text("Chart rotation demo");
        options.subtitle().text("Test options by dragging the sliders below");

        options.plotOptions().column().depth(25);

        Series series = (Series) JavaScriptObject.createObject();

        ArrayNumber data = series.dataAsArrayNumber();
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
        
        options.plotOptions().series().states().hover().halo().size(20);

        Series series1 = (Series) JavaScriptObject.createObject();
        ArrayNumber data = series1.dataAsArrayNumber();
        data.push(7.0);
        data.push(6.9);
        data.push(9.5);
        data.push(14.5);
        data.push(18.2);
        data.push(21.5);
        data.push(25.2);
        data.push(26.5);
        data.push(23.3);
        data.push(18.3);
        data.push(13.9);
        data.push(9.6);
        series1.name("Tokyo");

        Series series2 = (Series) JavaScriptObject.createObject();
        ArrayNumber data2 = series2.dataAsArrayNumber();
        data2.push(-0.2);
        data2.push(0.8);
        data2.push(5.7);
        data2.push(11.3);
        data2.push(17.0);
        data2.push(22.0);
        data2.push(24.8);
        data2.push(24.1);
        data2.push(20.1);
        data2.push(14.1);
        data2.push(8.6);
        data2.push(2.5);
        series2.name("New York");

        Series series3 = (Series) JavaScriptObject.createObject();
        ArrayNumber data3 = series3.dataAsArrayNumber();
        data3.push(-0.9);
        data3.push(0.6);
        data3.push(3.5);
        data3.push(8.4);
        data3.push(13.5);
        data3.push(17.0);
        data3.push(18.6);
        data3.push(17.9);
        data3.push(14.3);
        data3.push(9.0);
        data3.push(3.9);
        data3.push(1.0);
        series3.name("Berlin");

        Series series4 = (Series) JavaScriptObject.createObject();
        ArrayNumber data4 = series4.dataAsArrayNumber();
        data4.push(3.9);
        data4.push(4.2);
        data4.push(5.7);
        data4.push(8.5);
        data4.push(11.9);
        data4.push(15.2);
        data4.push(17.0);
        data4.push(16.6);
        data4.push(14.2);
        data4.push(10.3);
        data4.push(6.6);
        data4.push(4.8);
        series4.name("London");

        options.series().addToEnd(series1);
        options.series().addToEnd(series2);
        options.series().addToEnd(series3);
        options.series().addToEnd(series4);
        
        options.plotOptions().series().addSeriesClickHandler(new SeriesClickHandler()
        {
            
            @Override
            public void onSeriesClick(SeriesClickEvent seriesClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = seriesClickEvent.getSeries();
                String name = series.name();
                Window.alert("Series " + name + " clicked");
            }
        });

        return options;
    }

    @Override
    public ChartOptions visitBasicArea(Void in)
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();

        options.chart().type("area");
        options.title().text("US and USSR nuclear stockpiles");
        options.subtitle().text("Source: <a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">thebulletin.metapress.com</a>");

        // TODO add formater when available
        options.xAxis().allowDecimals(false);

        // TODO add formater when available
        options.yAxis().title().text("Nuclear weapon states");

        options.tooltip().pointFormat("{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}");

        options.plotOptions().area().pointStart(1940).marker().enabled(false).symbol("circle").radius(2).states().hover().enabled(true);

        Series series1 = (Series) JavaScriptObject.createObject();

        // TODO replace 0 by null ...
        ArrayNumber data = series1.dataAsArrayNumber();
        data.setValue(0, 0);
        data.setValue(1, 0);
        data.setValue(2, 0);
        data.setValue(3, 0);
        data.setValue(4, 0);
        int i = 4;
        data.setValue(++i, 6);
        data.setValue(++i, 11);
        data.setValue(++i, 32);
        data.setValue(++i, 110);
        data.setValue(++i, 235);
        data.setValue(++i, 369);
        data.setValue(++i, 640);
        data.setValue(++i, 1005);
        data.setValue(++i, 1436);
        data.setValue(++i, 2063);
        data.setValue(++i, 3057);
        data.setValue(++i, 4618);
        data.setValue(++i, 6444);
        data.setValue(++i, 9822);
        data.setValue(++i, 15468);
        data.setValue(++i, 20434);
        data.setValue(++i, 24126);
        data.setValue(++i, 27387);
        data.setValue(++i, 29459);
        data.setValue(++i, 31056);
        data.setValue(++i, 31982);
        data.setValue(++i, 32040);
        data.setValue(++i, 31233);
        data.setValue(++i, 29224);
        data.setValue(++i, 27342);
        data.setValue(++i, 26662);
        data.setValue(++i, 26956);
        data.setValue(++i, 27912);
        data.setValue(++i, 28999);
        data.setValue(++i, 28965);
        data.setValue(++i, 27826);
        data.setValue(++i, 25579);
        data.setValue(++i, 25722);
        data.setValue(++i, 24826);
        data.setValue(++i, 24605);
        data.setValue(++i, 24304);
        data.setValue(++i, 23464);
        data.setValue(++i, 23708);
        data.setValue(++i, 24099);
        data.setValue(++i, 24357);
        data.setValue(++i, 24237);
        data.setValue(++i, 24401);
        data.setValue(++i, 24344);
        data.setValue(++i, 23586);
        data.setValue(++i, 22380);
        data.setValue(++i, 21004);
        data.setValue(++i, 17287);
        data.setValue(++i, 14747);
        data.setValue(++i, 13076);
        data.setValue(++i, 12555);
        data.setValue(++i, 12144);
        data.setValue(++i, 11009);
        data.setValue(++i, 10950);
        data.setValue(++i, 10871);
        data.setValue(++i, 10824);
        data.setValue(++i, 10577);
        data.setValue(++i, 10527);
        data.setValue(++i, 10475);
        data.setValue(++i, 10421);
        data.setValue(++i, 10358);
        data.setValue(++i, 10295);
        data.setValue(++i, 10104);

        series1.name("USA");

        Series series2 = (Series) JavaScriptObject.createObject();
        ArrayNumber data2 = series2.dataAsArrayNumber();

        // TODO replace 0 by null ...
        data2.setValue(0, 0);
        data2.setValue(1, 0);
        data2.setValue(2, 0);
        data2.setValue(3, 0);
        data2.setValue(4, 0);
        data2.setValue(5, 0);
        data2.setValue(6, 0);
        data2.setValue(7, 0);
        data2.setValue(8, 0);
        data2.setValue(9, 0);

        int j = 9;
        data2.setValue(++j, 5);
        data2.setValue(++j, 25);
        data2.setValue(++j, 50);
        data2.setValue(++j, 120);
        data2.setValue(++j, 150);
        data2.setValue(++j, 200);
        data2.setValue(++j, 426);
        data2.setValue(++j, 660);
        data2.setValue(++j, 869);
        data2.setValue(++j, 1060);
        data2.setValue(++j, 1605);
        data2.setValue(++j, 2471);
        data2.setValue(++j, 3322);
        data2.setValue(++j, 4238);
        data2.setValue(++j, 5221);
        data2.setValue(++j, 6129);
        data2.setValue(++j, 7089);
        data2.setValue(++j, 8339);
        data2.setValue(++j, 9399);
        data2.setValue(++j, 10538);
        data2.setValue(++j, 11643);
        data2.setValue(++j, 13092);
        data2.setValue(++j, 14478);
        data2.setValue(++j, 15915);
        data2.setValue(++j, 17385);
        data2.setValue(++j, 19055);
        data2.setValue(++j, 21205);
        data2.setValue(++j, 23044);
        data2.setValue(++j, 25393);
        data2.setValue(++j, 27935);
        data2.setValue(++j, 30062);
        data2.setValue(++j, 32049);
        data2.setValue(++j, 33952);
        data2.setValue(++j, 35804);
        data2.setValue(++j, 37431);
        data2.setValue(++j, 39197);
        data2.setValue(++j, 45000);
        data2.setValue(++j, 43000);
        data2.setValue(++j, 41000);
        data2.setValue(++j, 39000);
        data2.setValue(++j, 37000);
        data2.setValue(++j, 35000);
        data2.setValue(++j, 33000);
        data2.setValue(++j, 31000);
        data2.setValue(++j, 29000);
        data2.setValue(++j, 27000);
        data2.setValue(++j, 25000);
        data2.setValue(++j, 24000);
        data2.setValue(++j, 23000);
        data2.setValue(++j, 22000);
        data2.setValue(++j, 21000);
        data2.setValue(++j, 20000);
        data2.setValue(++j, 19000);
        data2.setValue(++j, 18000);
        data2.setValue(++j, 18000);
        data2.setValue(++j, 17000);
        data2.setValue(++j, 16000);

        series2.name("USSR/Russia");

        options.series().addToEnd(series1);
        options.series().addToEnd(series2);
        return options;
    }

    @Override
    public ChartOptions visitBasicBar(Void in)
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();

        options.chart().type("bar");
        options.title().text("Historic World Population by Region");
        options.subtitle().text("Source: Wikipedia.org");

        ArrayString categories = options.xAxis().categories();
        categories.push("Africa");
        categories.push("America");
        categories.push("Asia");
        categories.push("Oceania");

        options.xAxis().title().text(null);

        options.yAxis().min(0).title().text("Population (millions)").align("high");
        options.yAxis().labels().overflow("justify");

        options.tooltip().valueSuffix(" millions");

        options.plotOptions().bar().dataLabels().enabled(true);

        options.legend().layout("vertical").align("right").verticalAlign("top").x(-40).y(100).floating(true).borderWidth(1).backgroundColor("#FFFFFF")
                        .shadowAsBoolean(true);

        options.credits().enabled(false);

        Series series1 = (Series) JavaScriptObject.createObject();
        ArrayNumber data1 = series1.dataAsArrayNumber();
        data1.push(107);
        data1.push(31);
        data1.push(635);
        data1.push(203);
        data1.push(2);
        series1.name("Year 1800");

        Series series2 = (Series) JavaScriptObject.createObject();
        ArrayNumber data2 = series2.dataAsArrayNumber();
        data2.push(133);
        data2.push(156);
        data2.push(947);
        data2.push(408);
        data2.push(6);
        series2.name("Year 1900");

        Series series3 = (Series) JavaScriptObject.createObject();
        ArrayNumber data3 = series3.dataAsArrayNumber();
        data3.push(973);
        data3.push(914);
        data3.push(4054);
        data3.push(732);
        data3.push(34);
        series3.name("Year 2008");

        options.series().addToEnd(series1);
        options.series().addToEnd(series2);
        options.series().addToEnd(series3);

        return options;
    }

    @Override
    public ChartOptions visitSolidGauge(Void in)
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();

        options.chart().type("solidgauge");

        options.title(null);

        ArrayString center = options.pane().centerAsArrayString();
        center.push("50%");
        center.push("85%");

        options.pane().sizeAsString("100%").startAngle(-90).endAngle(90)
                .background("{" + "\"backgroundColor\": \"#EEE\"," + "\"innerRadius\": \"60%\"," + "\"outerRadius\": \"100%\","
                                + "\"shape\": \"arc\"" + "}");

        options.tooltip().enabled(false);

        // TODO add stops
        // TODO options.yAxis.title.y not documented ? contact highcharts

        options.yAxis().lineWidth(0).tickPixelInterval(400).tickWidth(0).labels().y(16);

        // TODO minorTickInterval double to null ? how to do that ?

        options.plotOptions().solidgauge().dataLabels().borderWidth(0).y(5).useHTML(true);

        options.yAxis().min(0).max(200).title().text("Speed");

        options.credits().enabled(false);

        Series series = (Series) JavaScriptObject.createObject();
        Array<Data> dataList = series.dataAsArrayObject();

        Data data = (Data) JavaScriptObject.createObject();
        data.name("Speed");
        data.y(80);
        data.dataLabels("{\r\n    \"format\": \"<divstyle=\\\"text-align: center\\\"><span style=\\\"font-size: 25px;color: black\\\">{y}</span><br/><span style=\\\"font-size: 12px;color: silver\\\">km/h</span></div>\"\r\n}");
        dataList.addToEnd(data);


        options.plotOptions().series().tooltip().valueSuffix(" km/h");
        
        options.series().addToEnd(series);

        return options;
    }

    @Override
    public ChartOptions visitColumnLineAndPie(Void in)
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();

        options.title().text("Combination chart");

        ArrayString categories = options.xAxis().categories();
        categories.push("Apples");
        categories.push("Oranges");
        categories.push("Pears");
        categories.push("Bananas");
        categories.push("Plums");

        Array<Item> items = options.labels().items();
        Item item = (Item) JavaScriptObject.createObject();
        item.html("Total fruit consumption").style("{" + "\"left\": \"50px\"," + "\"top\": \"18px\"," + "\"color\": \"black\"" + "}");
        items.addToEnd(item);
        
        Series series1 = (Series) JavaScriptObject.createObject();
        ArrayNumber data1 = series1.dataAsArrayNumber();
        data1.push(3);
        data1.push(2);
        data1.push(1);
        data1.push(3);
        data1.push(4);
        series1.name("Jane");
        series1.type("column");

        Series series2 = (Series) JavaScriptObject.createObject();
        ArrayNumber data2 = series2.dataAsArrayNumber();
        data2.push(2);
        data2.push(3);
        data2.push(5);
        data2.push(7);
        data2.push(6);
        series2.name("John");
        series2.type("column");

        Series series3 = (Series) JavaScriptObject.createObject();
        ArrayNumber data3 = series3.dataAsArrayNumber();
        data3.push(4);
        data3.push(3);
        data3.push(3);
        data3.push(9);
        data3.push(0);
        series3.name("Joe");
        series3.type("column");
        
        Series series4 = (Series) JavaScriptObject.createObject();
        ArrayNumber data4 = series4.dataAsArrayNumber();
        data4.push(3);
        data4.push(2.67);
        data4.push(3);
        data4.push(6.33);
        data4.push(3.33);
        series4.name("Average");
        series4.type("spline");
        
        options.plotOptions().spline().marker().lineWidth(3).lineColor("#f7a35c").fillColor("white");

        
        Series series5 = (Series) JavaScriptObject.createObject();
        Array<Data> dataList = series5.dataAsArrayObject();
        
        Data d1 = (Data) JavaScriptObject.createObject();
        d1.y(13).name("Jane").color("#7cb5ec");
        dataList.addToEnd(d1);
        
        Data d2 = (Data) JavaScriptObject.createObject();
        d2.y(23).name("John").color("#434348");
        dataList.addToEnd(d2);
        
        Data d3 = (Data) JavaScriptObject.createObject();
        d3.y(19).name("Joe").color("#90ed7d");
        dataList.addToEnd(d3);

        series5.name("Total consumption");
        series5.type("pie");

        ArrayNumber centerAsArrayNumber = options.plotOptions().pie().centerAsArrayNumber();
        centerAsArrayNumber.setValue(0, 100);
        centerAsArrayNumber.setValue(1, 80);

        options.plotOptions().pie().sizeAsNumber(100).showInLegend(false).dataLabels().enabled(false);

        options.series().addToEnd(series1);
        options.series().addToEnd(series2);
        options.series().addToEnd(series3);
        options.series().addToEnd(series4);
        options.series().addToEnd(series5);
        
        options.plotOptions().column().addColumnClickHandler(new ColumnClickHandler()
        {
            
            @Override
            public void onColumnClick(ColumnClickEvent columnClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = columnClickEvent.getSeries();
                String name = series.name();
                Window.alert("Column  " + name + " clicked");
            }
        });
        
        
        options.plotOptions().spline().addSplineClickHandler(new SplineClickHandler()
        {
            
            @Override
            public void onSplineClick(SplineClickEvent splineClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = splineClickEvent.getSeries();
                String name = series.name();
                Window.alert("Sline " + name + " clicked");
            }
        });
        
        
        options.plotOptions().pie().addPieClickHandler(new PieClickHandler()
        {
            
            @Override
            public void onPieClick(PieClickEvent pieClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = pieClickEvent.getSeries();
                String name = series.name();
                Window.alert("Pie " + name + " clicked");
            }
        });
      

        return options;
    }
}
