package com.github.highcharts4gwt.client.model.highcharts;

import javax.inject.Inject;

import com.github.highcharts4gwt.model.array.api.Array;
import com.github.highcharts4gwt.model.array.api.ArrayNumber;
import com.github.highcharts4gwt.model.array.api.ArrayString;
import com.github.highcharts4gwt.model.factory.api.HighchartsOptionFactory;
import com.github.highcharts4gwt.model.highcharts.object.api.Point;
import com.github.highcharts4gwt.model.highcharts.option.api.ChartOptions;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesArea;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesBar;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesColumn;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesGauge;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesLine;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesPie;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesSpline;
import com.github.highcharts4gwt.model.highcharts.option.api.SeriesTreemap;
import com.github.highcharts4gwt.model.highcharts.option.api.labels.Item;
import com.github.highcharts4gwt.model.highcharts.option.api.seriesgauge.Data;
import com.github.highcharts4gwt.model.highcharts.option.api.seriesline.ClickEvent;
import com.github.highcharts4gwt.model.highcharts.option.api.seriesline.ClickHandler;
import com.github.highcharts4gwt.model.highcharts.option.api.seriesline.PointFormatterCallback;
import com.github.highcharts4gwt.model.highcharts.option.api.yaxis.PlotLine;
import com.github.ronanquillevere.generator.ExportAnnotations.ExportMaker;
import com.google.gwt.user.client.Window;

public class ChartOptionsVisitor implements ChartVisitor<Void, ChartOptions>
{
    private HighchartsOptionFactory highchartsFactory;

    @Inject
    public ChartOptionsVisitor(HighchartsOptionFactory highchartsFactory)
    {
        this.highchartsFactory = highchartsFactory;
    }

    @ExportMaker(name = "visitChart3D")
    @Override
    public ChartOptions visitChart3D(Void in)
    {
        // http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/chart/type-bar/

        ChartOptions options = highchartsFactory.createChartOptions();
        options.chart().type("column");
        options.chart().margin().push(75);
        options.chart().options3d().enabled(true).alpha(15).beta(15).depth(50).viewDistance(25);

        options.title().text("Chart rotation demo");
        options.subtitle().text("Test options by dragging the sliders below");

        options.plotOptions().column().depth(25);

        SeriesColumn series = highchartsFactory.createSeriesColumn();

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

    @ExportMaker(name = "visitBasicLine")
    @Override
    public ChartOptions visitBasicLine(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

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

        PlotLine plotLine = highchartsFactory.createYAxisPlotLine();
        plotLine.value(0).width(1).color("#808080");
        options.yAxis().plotLines().addToEnd(plotLine);

        options.tooltip().valueSuffix("°C");
        options.legend().layout("vertical").align("right").verticalAlign("middle").borderWidth(0);

        options.plotOptions().series().states().hover().halo().size(20);

        SeriesLine series1 = highchartsFactory.createSeriesLine();
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

        SeriesLine series2 = highchartsFactory.createSeriesLine();
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

        SeriesLine series3 = highchartsFactory.createSeriesLine();
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

        SeriesLine series4 = highchartsFactory.createSeriesLine();
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

        // Handler for one specific series
        series4.addClickHandler(new ClickHandler()
        {

            @Override
            public void onClick(ClickEvent clickEvent)
            {
                Window.alert("This handler is specific to London serie ");
            }
        });

        options.series().addToEnd(series1);
        options.series().addToEnd(series2);
        options.series().addToEnd(series3);
        options.series().addToEnd(series4);

        // Handler for all series
        options.plotOptions().series().addClickHandler(new com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.series.ClickHandler()
        {

            @Override
            public void onClick(com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.series.ClickEvent seriesClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = seriesClickEvent.series();
                String name = series.name();
                Array<Point> points = series.data();
                // Point point0 = points.getItem(0);
                // String name2 = point0.series().name();

                // TODO investigate this does not seems to work, why ???
                // double x = point0.x();

                Window.alert("Series " + name + " clicked" + "\nNumber of points : " + points.length());
            }
        });
        
        series1.tooltip().pointFormatter(new PointFormatterCallback()
        {
            
            @Override
            public String onCallback(Point Point)
            {
                String value = "Custom point tooltip, point " + Point.categoryAsString() + ", value: " +  Point.y();
                return value ;
            }
        });
        
        series1.point().addClickHandler(new com.github.highcharts4gwt.model.highcharts.option.api.seriesline.point.ClickHandler()
        {           
            @Override
            public void onClick(com.github.highcharts4gwt.model.highcharts.option.api.seriesline.point.ClickEvent clickEvent)
            {
                Point point = clickEvent.point();
                Window.alert("Category: " + point.categoryAsString() + ", value: " +  point.y());                
            }
        });

        return options;
    }

    @ExportMaker(name = "visitBasicArea")
    @Override
    public ChartOptions visitBasicArea(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

        options.chart().type("area");
        options.title().text("US and USSR nuclear stockpiles");
        options.subtitle().text("Source: <a href=\"http://thebulletin.metapress.com/content/c4120650912x74k7/fulltext.pdf\">thebulletin.metapress.com</a>");

        // TODO add formater when available
        options.xAxis().allowDecimals(false);

        // TODO add formater when available
        options.yAxis().title().text("Nuclear weapon states");

        options.tooltip().pointFormat("{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}");

        options.plotOptions().area().pointStart(1940).marker().enabled(false).symbol("circle").radius(2).states().hover().enabled(true);

        options.plotOptions().area().point().addClickHandler(new com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.area.point.ClickHandler()
        {

            @Override
            public void onClick(com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.area.point.ClickEvent pointClickEvent)
            {
                Point point = pointClickEvent.point();
                String seriesName = point.series().name();
                double x = point.x();
                double y = point.y();
                Window.alert("Point clicked x:" + x + " y:" + y + "\n Series:" + seriesName);

            }
        });

        SeriesArea series1 = highchartsFactory.createSeriesArea();

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

        SeriesArea series2 = highchartsFactory.createSeriesArea();
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

    @ExportMaker(name = "visitBasicBar")
    @Override
    public ChartOptions visitBasicBar(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

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

        SeriesBar series1 = highchartsFactory.createSeriesBar();
        ArrayNumber data1 = series1.dataAsArrayNumber();
        data1.push(107);
        data1.push(31);
        data1.push(635);
        data1.push(203);
        data1.push(2);
        series1.name("Year 1800");

        SeriesBar series2 = highchartsFactory.createSeriesBar();
        ArrayNumber data2 = series2.dataAsArrayNumber();
        data2.push(133);
        data2.push(156);
        data2.push(947);
        data2.push(408);
        data2.push(6);
        series2.name("Year 1900");

        SeriesBar series3 = highchartsFactory.createSeriesBar();
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

    @ExportMaker(name = "visitSolidGauge")
    @Override
    public ChartOptions visitSolidGauge(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

        options.chart().type("solidgauge");

        options.title(null);

        ArrayString center = options.pane().centerAsArrayString();
        center.push("50%");
        center.push("85%");

        options.pane().sizeAsString("100%").startAngle(-90).endAngle(90)
                .background("{" + "\"backgroundColor\": \"#EEE\"," + "\"innerRadius\": \"60%\"," + "\"outerRadius\": \"100%\"," + "\"shape\": \"arc\"" + "}");

        options.tooltip().enabled(false);

        // TODO add stops
        // TODO options.yAxis.title.y not documented ? contact highcharts

        options.yAxis().lineWidth(0).tickPixelInterval(400).tickWidth(0).labels().y(16);

        // TODO minorTickInterval double to null ? how to do that ?

        options.plotOptions().solidgauge().dataLabels().borderWidth(0).y(5).useHTML(true);

        options.yAxis().min(0).max(200).title().text("Speed");

        options.credits().enabled(false);

        SeriesGauge series = highchartsFactory.createSeriesGauge();
        Array<Data> dataList = series.dataAsArrayObject();

        Data data = highchartsFactory.createSeriesGaugeData();
        data.name("Speed");
        data.y(80);
        data.dataLabels("{\r\n    \"format\": \"<divstyle=\\\"text-align: center\\\"><span style=\\\"font-size: 25px;color: black\\\">{y}</span><br/><span style=\\\"font-size: 12px;color: silver\\\">km/h</span></div>\"\r\n}");
        dataList.addToEnd(data);

        options.plotOptions().series().tooltip().valueSuffix(" km/h");

        options.series().addToEnd(series);

        return options;
    }

    @ExportMaker(name = "visitColumnLineAndPie")
    @Override
    public ChartOptions visitColumnLineAndPie(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

        options.title().text("Combination chart");

        ArrayString categories = options.xAxis().categories();
        categories.push("Apples");
        categories.push("Oranges");
        categories.push("Pears");
        categories.push("Bananas");
        categories.push("Plums");

        Array<Item> items = options.labels().items();
        Item item = highchartsFactory.createItem();
        item.html("Total fruit consumption").style("{" + "\"left\": \"50px\"," + "\"top\": \"18px\"," + "\"color\": \"black\"" + "}");
        items.addToEnd(item);

        SeriesColumn series1 = highchartsFactory.createSeriesColumn();
        ArrayNumber data1 = series1.dataAsArrayNumber();
        data1.push(3);
        data1.push(2);
        data1.push(1);
        data1.push(3);
        data1.push(4);
        series1.name("Jane");
        series1.type("column");

        SeriesColumn series2 = highchartsFactory.createSeriesColumn();
        ArrayNumber data2 = series2.dataAsArrayNumber();
        data2.push(2);
        data2.push(3);
        data2.push(5);
        data2.push(7);
        data2.push(6);
        series2.name("John");
        series2.type("column");

        SeriesColumn series3 = highchartsFactory.createSeriesColumn();
        ArrayNumber data3 = series3.dataAsArrayNumber();
        data3.push(4);
        data3.push(3);
        data3.push(3);
        data3.push(9);
        data3.push(0);
        series3.name("Joe");
        series3.type("column");

        SeriesSpline series4 = highchartsFactory.createSeriesSpline();
        ArrayNumber data4 = series4.dataAsArrayNumber();
        data4.push(3);
        data4.push(2.67);
        data4.push(3);
        data4.push(6.33);
        data4.push(3.33);
        series4.name("Average");
        series4.type("spline");

        options.plotOptions().spline().marker().lineWidth(3).lineColor("#f7a35c").fillColor("white");

        SeriesPie series5 = highchartsFactory.createSeriesPie();
        Array<com.github.highcharts4gwt.model.highcharts.option.api.seriespie.Data> dataList = series5.dataAsArrayObject();

        com.github.highcharts4gwt.model.highcharts.option.api.seriespie.Data d1 = highchartsFactory.createSeriesPieData();
        d1.y(13).name("Jane").color("#7cb5ec");
        dataList.addToEnd(d1);

        com.github.highcharts4gwt.model.highcharts.option.api.seriespie.Data d2 = highchartsFactory.createSeriesPieData();
        d2.y(23).name("John").color("#434348");
        dataList.addToEnd(d2);

        com.github.highcharts4gwt.model.highcharts.option.api.seriespie.Data d3 = highchartsFactory.createSeriesPieData();
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

        options.plotOptions().column().addClickHandler(new com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.column.ClickHandler()
        {

            @Override
            public void onClick(com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.column.ClickEvent columnClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = columnClickEvent.series();
                String name = series.name();
                Window.alert("Column  " + name + " clicked");
            }
        });

        options.plotOptions().spline().addClickHandler(new com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.spline.ClickHandler()
        {

            @Override
            public void onClick(com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.spline.ClickEvent splineClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = splineClickEvent.series();
                String name = series.name();
                Window.alert("Sline " + name + " clicked");
            }
        });

        options.plotOptions().pie().addClickHandler(new com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.pie.ClickHandler()
        {

            @Override
            public void onClick(com.github.highcharts4gwt.model.highcharts.option.api.plotoptions.pie.ClickEvent pieClickEvent)
            {
                com.github.highcharts4gwt.model.highcharts.object.api.Series series = pieClickEvent.series();
                String name = series.name();
                Window.alert("Pie " + name + " clicked");
            }
        });

        return options;
    }

    @ExportMaker(name = "visitPolarChart")
    @Override
    public ChartOptions visitPolarChart(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

        options.chart().polar(true);

        options.title().text("Highcharts Polar Chart");

        options.pane().startAngle(0).endAngle(360);

        options.xAxis().tickInterval(45).min(0).max(360);

        options.yAxis().min(0);

        options.plotOptions().series().pointStart(0).pointInterval(45);
        options.plotOptions().column().pointPadding(0).groupPadding(0);

        // TODO missing formater

        options.plotOptions().column().pointPlacementAsString("between");
        SeriesColumn series = highchartsFactory.createSeriesColumn().type("column").name("Column");
        ArrayNumber data1 = series.dataAsArrayNumber();
        data1.push(8);
        data1.push(7);
        data1.push(6);
        data1.push(5);
        data1.push(4);
        data1.push(3);
        data1.push(2);
        data1.push(1);

        options.series().addToEnd(series);

        SeriesLine series2 = highchartsFactory.createSeriesLine().type("line").name("Line");
        ArrayNumber data2 = series2.dataAsArrayNumber();
        data2.push(1);
        data2.push(2);
        data2.push(3);
        data2.push(4);
        data2.push(5);
        data2.push(6);
        data2.push(7);
        data2.push(8);

        options.series().addToEnd(series2);

        SeriesArea series3 = highchartsFactory.createSeriesArea().type("area").name("Area");
        ArrayNumber data3 = series3.dataAsArrayNumber();
        data3.push(1);
        data3.push(8);
        data3.push(2);
        data3.push(7);
        data3.push(3);
        data3.push(6);
        data3.push(4);
        data3.push(5);

        options.series().addToEnd(series3);

        return options;
    }

    @ExportMaker(name = "visitTreeMapWithColumnAxis")
    @Override
    public ChartOptions visitTreeMapWithColumnAxis(Void in)
    {
        ChartOptions options = highchartsFactory.createChartOptions();

        options.setFieldAsJsonObject("colorAxis", "{ \"minColor\" : \"#FFFFFF\", \"maxColor\" : \"#7cb5ec\"}");

        SeriesTreemap series = highchartsFactory.createSeriesTreemap();
        series.type("treemap").setFieldAsJsonObject("layoutAlgorithm", "\"squarified\"");
        Array<com.github.highcharts4gwt.model.highcharts.option.api.seriestreemap.Data> dataList = series.dataAsArrayObject();

        dataList.addToEnd(createTreeMapDataObject("A", "6", 1));
        dataList.addToEnd(createTreeMapDataObject("B", "6", 2));
        dataList.addToEnd(createTreeMapDataObject("C", "4", 3));
        dataList.addToEnd(createTreeMapDataObject("D", "3", 4));
        dataList.addToEnd(createTreeMapDataObject("E", "2", 5));
        dataList.addToEnd(createTreeMapDataObject("F", "2", 6));
        dataList.addToEnd(createTreeMapDataObject("G", "1", 7));

        options.series().addToEnd(series);

        String function = "function () " + "{" + "return 'The value for <b>' + this.x +'</b> is <b>' + this.y + '</b>';" + "}";

        options.tooltip().setFunctionAsString("formatter", function);

        options.title().text("Highcharts Treemap");
        return options;

    }

    private com.github.highcharts4gwt.model.highcharts.option.api.seriestreemap.Data createTreeMapDataObject(String name, String value, double colorValue)
    {
        com.github.highcharts4gwt.model.highcharts.option.api.seriestreemap.Data data = highchartsFactory.createSeriesTreemapData();
        data.name(name).colorValue(colorValue);
        data.setFieldAsJsonObject("value", value);
        return data;
    }

    @ExportMaker(name = "visitTimeSeriesZoomable")
    @Override
    public ChartOptions visitTimeSeriesZoomable(Void in)
    {
        // http://jsfiddle.net/gh/get/jquery/1.9.1/highslide-software/highcharts.com/tree/master/samples/highcharts/demo/line-time-series/

        ChartOptions options = highchartsFactory.createChartOptions();
        options.chart().zoomType("x");

        options.title().text("USD to EUR exchange rate from 2006 through 2008");

        options.subtitle().text("Click and drag in the plot area to zoom in"); // TODO
                                                                               // how
                                                                               // to
                                                                               // handle
                                                                               // expressions
                                                                               // ?

        options.xAxis().type("datetime").minRange(14 * 24 * 3600000);

        options.yAxis().title().text("Exchange rate");

        options.legend().enabled(false);

        //TODO does not seem to be working
        String fillcolor = "{" + 
                "\"linearGradient\": {" 
                    + "\"x1\": 0," 
                    + "\"y1\": 0," 
                    + "\"x2\": 0," 
                    + "\"y2\": 1" 
                + "}," 
                + "\"stops\": ["
                    + "[" + "0, \"#058DC7\"" + "]," 
                    + "[" + "1, \"#FFFFFF\"" + "]" 
                + "]" 
                + "}";

        
        options.plotOptions().area()
            .setFieldAsJsonObject("fillColor", fillcolor)
            .marker().radius(2)
            .lineWidth(1)
            .states().hover().lineWidth(1);
        

        SeriesArea series1 = highchartsFactory.createSeriesArea();

        ArrayNumber data = series1.dataAsArrayNumber();
        
        data.push(0.8446);
        data.push(0.8445);
        data.push(0.8444);
        data.push(0.8451);
        data.push(0.8418);
        data.push(0.8264);
        data.push(0.8258);
        data.push(0.8232);
        data.push(0.8233);
        data.push(0.8258);
        data.push(0.8283);
        data.push(0.8278);
        data.push(0.8256);
        data.push(0.8292);
        data.push(0.8239);
        data.push(0.8239);
        data.push(0.8245);
        data.push(0.8265);
        data.push(0.8261);
        data.push(0.8269);
        data.push(0.8273);
        data.push(0.8244);
        data.push(0.8244);
        data.push(0.8172);
        data.push(0.8139);
        data.push(0.8146);
        data.push(0.8164);
        data.push(0.82);
        data.push(0.8269);
        data.push(0.8269);
        data.push(0.8269);
        data.push(0.8258);
        data.push(0.8247);
        data.push(0.8286);
        data.push(0.8289);
        data.push(0.8316);
        data.push(0.832);
        data.push(0.8333);
        data.push(0.8352);
        data.push(0.8357);
        data.push(0.8355);
        data.push(0.8354);
        data.push(0.8403);
        data.push(0.8403);
        data.push(0.8406);
        data.push(0.8403);
        data.push(0.8396);
        data.push(0.8418);
        data.push(0.8409);
        data.push(0.8384);
        data.push(0.8386);
        data.push(0.8372);
        data.push(0.839);
        data.push(0.84);
        data.push(0.8389);
        data.push(0.84);
        data.push(0.8423);
        data.push(0.8423);
        data.push(0.8435);
        data.push(0.8422);
        data.push(0.838);
        data.push(0.8373);
        data.push(0.8316);
        data.push(0.8303);
        data.push(0.8303);
        data.push(0.8302);
        data.push(0.8369);
        data.push(0.84);
        data.push(0.8385);
        data.push(0.84);
        data.push(0.8401);
        data.push(0.8402);
        data.push(0.8381);
        data.push(0.8351);
        data.push(0.8314);
        data.push(0.8273);
        data.push(0.8213);
        data.push(0.8207);
        data.push(0.8207);
        data.push(0.8215);
        data.push(0.8242);
        data.push(0.8273);
        data.push(0.8301);
        data.push(0.8346);
        data.push(0.8312);
        data.push(0.8312);
        data.push(0.8312);
        data.push(0.8306);
        data.push(0.8327);
        data.push(0.8282);
        data.push(0.824);
        data.push(0.8255);
        data.push(0.8256);
        data.push(0.8273);
        data.push(0.8209);
        data.push(0.8151);
        data.push(0.8149);
        data.push(0.8213);
        data.push(0.8273);
        data.push(0.8273);
        data.push(0.8261);
        data.push(0.8252);
        data.push(0.824);
        data.push(0.8262);
        data.push(0.8258);
        data.push(0.8261);
        data.push(0.826);
        data.push(0.8199);
        data.push(0.8153);
        data.push(0.8097);
        data.push(0.8101);
        data.push(0.8119);
        data.push(0.8107);
        data.push(0.8105);
        data.push(0.8084);
        data.push(0.8069);
        data.push(0.8047);
        data.push(0.8023);
        data.push(0.7965);
        data.push(0.7919);
        data.push(0.7921);
        data.push(0.7922);
        data.push(0.7934);
        data.push(0.7918);
        data.push(0.7915);
        data.push(0.787);
        data.push(0.7861);
        data.push(0.7861);
        data.push(0.7853);
        data.push(0.7867);
        data.push(0.7827);
        data.push(0.7834);
        data.push(0.7766);
        data.push(0.7751);
        data.push(0.7739);
        data.push(0.7767);
        data.push(0.7802);
        data.push(0.7788);
        data.push(0.7828);
        data.push(0.7816);
        data.push(0.7829);
        data.push(0.783);
        data.push(0.7829);
        data.push(0.7781);
        data.push(0.7811);
        data.push(0.7831);
        data.push(0.7826);
        data.push(0.7855);
        data.push(0.7855);
        data.push(0.7845);
        data.push(0.7798);
        data.push(0.7777);
        data.push(0.7822);
        data.push(0.7785);
        data.push(0.7744);
        data.push(0.7743);
        data.push(0.7726);
        data.push(0.7766);
        data.push(0.7806);
        data.push(0.785);
        data.push(0.7907);
        data.push(0.7912);
        data.push(0.7913);
        data.push(0.7931);
        data.push(0.7952);
        data.push(0.7951);
        data.push(0.7928);
        data.push(0.791);
        data.push(0.7913);
        data.push(0.7912);
        data.push(0.7941);
        data.push(0.7953);
        data.push(0.7921);
        data.push(0.7919);
        data.push(0.7968);
        data.push(0.7999);
        data.push(0.7999);
        data.push(0.7974);
        data.push(0.7942);
        data.push(0.796);
        data.push(0.7969);
        data.push(0.7862);
        data.push(0.7821);
        data.push(0.7821);
        data.push(0.7821);
        data.push(0.7811);
        data.push(0.7833);
        data.push(0.7849);
        data.push(0.7819);
        data.push(0.7809);
        data.push(0.7809);
        data.push(0.7827);
        data.push(0.7848);
        data.push(0.785);
        data.push(0.7873);
        data.push(0.7894);
        data.push(0.7907);
        data.push(0.7909);
        data.push(0.7947);
        data.push(0.7987);
        data.push(0.799);
        data.push(0.7927);
        data.push(0.79);
        data.push(0.7878);
        data.push(0.7878);
        data.push(0.7907);
        data.push(0.7922);
        data.push(0.7937);
        data.push(0.786);
        data.push(0.787);
        data.push(0.7838);
        data.push(0.7838);
        data.push(0.7837);
        data.push(0.7836);
        data.push(0.7806);
        data.push(0.7825);
        data.push(0.7798);
        data.push(0.777);
        data.push(0.777);
        data.push(0.7772);
        data.push(0.7793);
        data.push(0.7788);
        data.push(0.7785);
        data.push(0.7832);
        data.push(0.7865);
        data.push(0.7865);
        data.push(0.7853);
        data.push(0.7847);
        data.push(0.7809);
        data.push(0.778);
        data.push(0.7799);
        data.push(0.78);
        data.push(0.7801);
        data.push(0.7765);
        data.push(0.7785);
        data.push(0.7811);
        data.push(0.782);
        data.push(0.7835);
        data.push(0.7845);
        data.push(0.7844);
        data.push(0.782);
        data.push(0.7811);
        data.push(0.7795);
        data.push(0.7794);
        data.push(0.7806);
        data.push(0.7794);
        data.push(0.7794);
        data.push(0.7778);
        data.push(0.7793);
        data.push(0.7808);
        data.push(0.7824);
        data.push(0.787);
        data.push(0.7894);
        data.push(0.7893);
        data.push(0.7882);
        data.push(0.7871);
        data.push(0.7882);
        data.push(0.7871);
        data.push(0.7878);
        data.push(0.79);
        data.push(0.7901);
        data.push(0.7898);
        data.push(0.7879);
        data.push(0.7886);
        data.push(0.7858);
        data.push(0.7814);
        data.push(0.7825);
        data.push(0.7826);
        data.push(0.7826);
        data.push(0.786);
        data.push(0.7878);
        data.push(0.7868);
        data.push(0.7883);
        data.push(0.7893);
        data.push(0.7892);
        data.push(0.7876);
        data.push(0.785);
        data.push(0.787);
        data.push(0.7873);
        data.push(0.7901);
        data.push(0.7936);
        data.push(0.7939);
        data.push(0.7938);
        data.push(0.7956);
        data.push(0.7975);
        data.push(0.7978);
        data.push(0.7972);
        data.push(0.7995);
        data.push(0.7995);
        data.push(0.7994);
        data.push(0.7976);
        data.push(0.7977);
        data.push(0.796);
        data.push(0.7922);
        data.push(0.7928);
        data.push(0.7929);
        data.push(0.7948);
        data.push(0.797);
        data.push(0.7953);
        data.push(0.7907);
        data.push(0.7872);
        data.push(0.7852);
        data.push(0.7852);
        data.push(0.786);
        data.push(0.7862);
        data.push(0.7836);
        data.push(0.7837);
        data.push(0.784);
        data.push(0.7867);
        data.push(0.7867);
        data.push(0.7869);
        data.push(0.7837);
        data.push(0.7827);
        data.push(0.7825);
        data.push(0.7779);
        data.push(0.7791);
        data.push(0.779);
        data.push(0.7787);
        data.push(0.78);
        data.push(0.7807);
        data.push(0.7803);
        data.push(0.7817);
        data.push(0.7799);
        data.push(0.7799);
        data.push(0.7795);
        data.push(0.7801);
        data.push(0.7765);
        data.push(0.7725);
        data.push(0.7683);
        data.push(0.7641);
        data.push(0.7639);
        data.push(0.7616);
        data.push(0.7608);
        data.push(0.759);
        data.push(0.7582);
        data.push(0.7539);
        data.push(0.75);
        data.push(0.75);
        data.push(0.7507);
        data.push(0.7505);
        data.push(0.7516);
        data.push(0.7522);
        data.push(0.7531);
        data.push(0.7577);
        data.push(0.7577);
        data.push(0.7582);
        data.push(0.755);
        data.push(0.7542);
        data.push(0.7576);
        data.push(0.7616);
        data.push(0.7648);
        data.push(0.7648);
        data.push(0.7641);
        data.push(0.7614);
        data.push(0.757);
        data.push(0.7587);
        data.push(0.7588);
        data.push(0.762);
        data.push(0.762);
        data.push(0.7617);
        data.push(0.7618);
        data.push(0.7615);
        data.push(0.7612);
        data.push(0.7596);
        data.push(0.758);
        data.push(0.758);
        data.push(0.758);
        data.push(0.7547);
        data.push(0.7549);
        data.push(0.7613);
        data.push(0.7655);
        data.push(0.7693);
        data.push(0.7694);
        data.push(0.7688);
        data.push(0.7678);
        data.push(0.7708);
        data.push(0.7727);
        data.push(0.7749);
        data.push(0.7741);
        data.push(0.7741);
        data.push(0.7732);
        data.push(0.7727);
        data.push(0.7737);
        data.push(0.7724);
        data.push(0.7712);
        data.push(0.772);
        data.push(0.7721);
        data.push(0.7717);
        data.push(0.7704);
        data.push(0.769);
        data.push(0.7711);
        data.push(0.774);
        data.push(0.7745);
        data.push(0.7745);
        data.push(0.774);
        data.push(0.7716);
        data.push(0.7713);
        data.push(0.7678);
        data.push(0.7688);
        data.push(0.7718);
        data.push(0.7718);
        data.push(0.7728);
        data.push(0.7729);
        data.push(0.7698);
        data.push(0.7685);
        data.push(0.7681);
        data.push(0.769);
        data.push(0.769);
        data.push(0.7698);
        data.push(0.7699);
        data.push(0.7651);
        data.push(0.7613);
        data.push(0.7616);
        data.push(0.7614);
        data.push(0.7614);
        data.push(0.7607);
        data.push(0.7602);
        data.push(0.7611);
        data.push(0.7622);
        data.push(0.7615);
        data.push(0.7598);
        data.push(0.7598);
        data.push(0.7592);
        data.push(0.7573);
        data.push(0.7566);
        data.push(0.7567);
        data.push(0.7591);
        data.push(0.7582);
        data.push(0.7585);
        data.push(0.7613);
        data.push(0.7631);
        data.push(0.7615);
        data.push(0.76);
        data.push(0.7613);
        data.push(0.7627);
        data.push(0.7627);
        data.push(0.7608);
        data.push(0.7583);
        data.push(0.7575);
        data.push(0.7562);
        data.push(0.752);
        data.push(0.7512);
        data.push(0.7512);
        data.push(0.7517);
        data.push(0.752);
        data.push(0.7511);
        data.push(0.748);
        data.push(0.7509);
        data.push(0.7531);
        data.push(0.7531);
        data.push(0.7527);
        data.push(0.7498);
        data.push(0.7493);
        data.push(0.7504);
        data.push(0.75);
        data.push(0.7491);
        data.push(0.7491);
        data.push(0.7485);
        data.push(0.7484);
        data.push(0.7492);
        data.push(0.7471);
        data.push(0.7459);
        data.push(0.7477);
        data.push(0.7477);
        data.push(0.7483);
        data.push(0.7458);
        data.push(0.7448);
        data.push(0.743);
        data.push(0.7399);
        data.push(0.7395);
        data.push(0.7395);
        data.push(0.7378);
        data.push(0.7382);
        data.push(0.7362);
        data.push(0.7355);
        data.push(0.7348);
        data.push(0.7361);
        data.push(0.7361);
        data.push(0.7365);
        data.push(0.7362);
        data.push(0.7331);
        data.push(0.7339);
        data.push(0.7344);
        data.push(0.7327);
        data.push(0.7327);
        data.push(0.7336);
        data.push(0.7333);
        data.push(0.7359);
        data.push(0.7359);
        data.push(0.7372);
        data.push(0.736);
        data.push(0.736);
        data.push(0.735);
        data.push(0.7365);
        data.push(0.7384);
        data.push(0.7395);
        data.push(0.7413);
        data.push(0.7397);
        data.push(0.7396);
        data.push(0.7385);
        data.push(0.7378);
        data.push(0.7366);
        data.push(0.74);
        data.push(0.7411);
        data.push(0.7406);
        data.push(0.7405);
        data.push(0.7414);
        data.push(0.7431);
        data.push(0.7431);
        data.push(0.7438);
        data.push(0.7443);
        data.push(0.7443);
        data.push(0.7443);
        data.push(0.7434);
        data.push(0.7429);
        data.push(0.7442);
        data.push(0.744);
        data.push(0.7439);
        data.push(0.7437);
        data.push(0.7437);
        data.push(0.7429);
        data.push(0.7403);
        data.push(0.7399);
        data.push(0.7418);
        data.push(0.7468);
        data.push(0.748);
        data.push(0.748);
        data.push(0.749);
        data.push(0.7494);
        data.push(0.7522);
        data.push(0.7515);
        data.push(0.7502);
        data.push(0.7472);
        data.push(0.7472);
        data.push(0.7462);
        data.push(0.7455);
        data.push(0.7449);
        data.push(0.7467);
        data.push(0.7458);
        data.push(0.7427);
        data.push(0.7427);
        data.push(0.743);
        data.push(0.7429);
        data.push(0.744);
        data.push(0.743);
        data.push(0.7422);
        data.push(0.7388);
        data.push(0.7388);
        data.push(0.7369);
        data.push(0.7345);
        data.push(0.7345);
        data.push(0.7345);
        data.push(0.7352);
        data.push(0.7341);
        data.push(0.7341);
        data.push(0.734);
        data.push(0.7324);
        data.push(0.7272);
        data.push(0.7264);
        data.push(0.7255);
        data.push(0.7258);
        data.push(0.7258);
        data.push(0.7256);
        data.push(0.7257);
        data.push(0.7247);
        data.push(0.7243);
        data.push(0.7244);
        data.push(0.7235);
        data.push(0.7235);
        data.push(0.7235);
        data.push(0.7235);
        data.push(0.7262);
        data.push(0.7288);
        data.push(0.7301);
        data.push(0.7337);
        data.push(0.7337);
        data.push(0.7324);
        data.push(0.7297);
        data.push(0.7317);
        data.push(0.7315);
        data.push(0.7288);
        data.push(0.7263);
        data.push(0.7263);
        data.push(0.7242);
        data.push(0.7253);
        data.push(0.7264);
        data.push(0.727);
        data.push(0.7312);
        data.push(0.7305);
        data.push(0.7305);
        data.push(0.7318);
        data.push(0.7358);
        data.push(0.7409);
        data.push(0.7454);
        data.push(0.7437);
        data.push(0.7424);
        data.push(0.7424);
        data.push(0.7415);
        data.push(0.7419);
        data.push(0.7414);
        data.push(0.7377);
        data.push(0.7355);
        data.push(0.7315);
        data.push(0.7315);
        data.push(0.732);
        data.push(0.7332);
        data.push(0.7346);
        data.push(0.7328);
        data.push(0.7323);
        data.push(0.734);
        data.push(0.734);
        data.push(0.7336);
        data.push(0.7351);
        data.push(0.7346);
        data.push(0.7321);
        data.push(0.7294);
        data.push(0.7266);
        data.push(0.7266);
        data.push(0.7254);
        data.push(0.7242);
        data.push(0.7213);
        data.push(0.7197);
        data.push(0.7209);
        data.push(0.721);
        data.push(0.721);
        data.push(0.721);
        data.push(0.7209);
        data.push(0.7159);
        data.push(0.7133);
        data.push(0.7105);
        data.push(0.7099);
        data.push(0.7099);
        data.push(0.7093);
        data.push(0.7093);
        data.push(0.7076);
        data.push(0.707);
        data.push(0.7049);
        data.push(0.7012);
        data.push(0.7011);
        data.push(0.7019);
        data.push(0.7046);
        data.push(0.7063);
        data.push(0.7089);
        data.push(0.7077);
        data.push(0.7077);
        data.push(0.7077);
        data.push(0.7091);
        data.push(0.7118);
        data.push(0.7079);
        data.push(0.7053);
        data.push(0.705);
        data.push(0.7055);
        data.push(0.7055);
        data.push(0.7045);
        data.push(0.7051);
        data.push(0.7051);
        data.push(0.7017);
        data.push(0.7);
        data.push(0.6995);
        data.push(0.6994);
        data.push(0.7014);
        data.push(0.7036);
        data.push(0.7021);
        data.push(0.7002);
        data.push(0.6967);
        data.push(0.695);
        data.push(0.695);
        data.push(0.6939);
        data.push(0.694);
        data.push(0.6922);
        data.push(0.6919);
        data.push(0.6914);
        data.push(0.6894);
        data.push(0.6891);
        data.push(0.6904);
        data.push(0.689);
        data.push(0.6834);
        data.push(0.6823);
        data.push(0.6807);
        data.push(0.6815);
        data.push(0.6815);
        data.push(0.6847);
        data.push(0.6859);
        data.push(0.6822);
        data.push(0.6827);
        data.push(0.6837);
        data.push(0.6823);
        data.push(0.6822);
        data.push(0.6822);
        data.push(0.6792);
        data.push(0.6746);
        data.push(0.6735);
        data.push(0.6731);
        data.push(0.6742);
        data.push(0.6744);
        data.push(0.6739);
        data.push(0.6731);
        data.push(0.6761);
        data.push(0.6761);
        data.push(0.6785);
        data.push(0.6818);
        data.push(0.6836);
        data.push(0.6823);
        data.push(0.6805);
        data.push(0.6793);
        data.push(0.6849);
        data.push(0.6833);
        data.push(0.6825);
        data.push(0.6825);
        data.push(0.6816);
        data.push(0.6799);
        data.push(0.6813);
        data.push(0.6809);
        data.push(0.6868);
        data.push(0.6933);
        data.push(0.6933);
        data.push(0.6945);
        data.push(0.6944);
        data.push(0.6946);
        data.push(0.6964);
        data.push(0.6965);
        data.push(0.6956);
        data.push(0.6956);
        data.push(0.695);
        data.push(0.6948);
        data.push(0.6928);
        data.push(0.6887);
        data.push(0.6824);
        data.push(0.6794);
        data.push(0.6794);
        data.push(0.6803);
        data.push(0.6855);
        data.push(0.6824);
        data.push(0.6791);
        data.push(0.6783);
        data.push(0.6785);
        data.push(0.6785);
        data.push(0.6797);
        data.push(0.68);
        data.push(0.6803);
        data.push(0.6805);
        data.push(0.676);
        data.push(0.677);
        data.push(0.677);
        data.push(0.6736);
        data.push(0.6726);
        data.push(0.6764);
        data.push(0.6821);
        data.push(0.6831);
        data.push(0.6842);
        data.push(0.6842);
        data.push(0.6887);
        data.push(0.6903);
        data.push(0.6848);
        data.push(0.6824);
        data.push(0.6788);
        data.push(0.6814);
        data.push(0.6814);
        data.push(0.6797);
        data.push(0.6769);
        data.push(0.6765);
        data.push(0.6733);
        data.push(0.6729);
        data.push(0.6758);
        data.push(0.6758);
        data.push(0.675);
        data.push(0.678);
        data.push(0.6833);
        data.push(0.6856);
        data.push(0.6903);
        data.push(0.6896);
        data.push(0.6896);
        data.push(0.6882);
        data.push(0.6879);
        data.push(0.6862);
        data.push(0.6852);
        data.push(0.6823);
        data.push(0.6813);
        data.push(0.6813);
        data.push(0.6822);
        data.push(0.6802);
        data.push(0.6802);
        data.push(0.6784);
        data.push(0.6748);
        data.push(0.6747);
        data.push(0.6747);
        data.push(0.6748);
        data.push(0.6733);
        data.push(0.665);
        data.push(0.6611);
        data.push(0.6583);
        data.push(0.659);
        data.push(0.659);
        data.push(0.6581);
        data.push(0.6578);
        data.push(0.6574);
        data.push(0.6532);
        data.push(0.6502);
        data.push(0.6514);
        data.push(0.6514);
        data.push(0.6507);
        data.push(0.651);
        data.push(0.6489);
        data.push(0.6424);
        data.push(0.6406);
        data.push(0.6382);
        data.push(0.6382);
        data.push(0.6341);
        data.push(0.6344);
        data.push(0.6378);
        data.push(0.6439);
        data.push(0.6478);
        data.push(0.6481);
        data.push(0.6481);
        data.push(0.6494);
        data.push(0.6438);
        data.push(0.6377);
        data.push(0.6329);
        data.push(0.6336);
        data.push(0.6333);
        data.push(0.6333);
        data.push(0.633);
        data.push(0.6371);
        data.push(0.6403);
        data.push(0.6396);
        data.push(0.6364);
        data.push(0.6356);
        data.push(0.6356);
        data.push(0.6368);
        data.push(0.6357);
        data.push(0.6354);
        data.push(0.632);
        data.push(0.6332);
        data.push(0.6328);
        data.push(0.6331);
        data.push(0.6342);
        data.push(0.6321);
        data.push(0.6302);
        data.push(0.6278);
        data.push(0.6308);
        data.push(0.6324);
        data.push(0.6324);
        data.push(0.6307);
        data.push(0.6277);
        data.push(0.6269);
        data.push(0.6335);
        data.push(0.6392);
        data.push(0.64);
        data.push(0.6401);
        data.push(0.6396);
        data.push(0.6407);
        data.push(0.6423);
        data.push(0.6429);
        data.push(0.6472);
        data.push(0.6485);
        data.push(0.6486);
        data.push(0.6467);
        data.push(0.6444);
        data.push(0.6467);
        data.push(0.6509);
        data.push(0.6478);
        data.push(0.6461);
        data.push(0.6461);
        data.push(0.6468);
        data.push(0.6449);
        data.push(0.647);
        data.push(0.6461);
        data.push(0.6452);
        data.push(0.6422);
        data.push(0.6422);
        data.push(0.6425);
        data.push(0.6414);
        data.push(0.6366);
        data.push(0.6346);
        data.push(0.635);
        data.push(0.6346);
        data.push(0.6346);
        data.push(0.6343);
        data.push(0.6346);
        data.push(0.6379);
        data.push(0.6416);
        data.push(0.6442);
        data.push(0.6431);
        data.push(0.6431);
        data.push(0.6435);
        data.push(0.644);
        data.push(0.6473);
        data.push(0.6469);
        data.push(0.6386);
        data.push(0.6356);
        data.push(0.634);
        data.push(0.6346);
        data.push(0.643);
        data.push(0.6452);
        data.push(0.6467);
        data.push(0.6506);
        data.push(0.6504);
        data.push(0.6503);
        data.push(0.6481);
        data.push(0.6451);
        data.push(0.645);
        data.push(0.6441);
        data.push(0.6414);
        data.push(0.6409);
        data.push(0.6409);
        data.push(0.6428);
        data.push(0.6431);
        data.push(0.6418);
        data.push(0.6371);
        data.push(0.6349);
        data.push(0.6333);
        data.push(0.6334);
        data.push(0.6338);
        data.push(0.6342);
        data.push(0.632);
        data.push(0.6318);
        data.push(0.637);
        data.push(0.6368);
        data.push(0.6368);
        data.push(0.6383);
        data.push(0.6371);
        data.push(0.6371);
        data.push(0.6355);
        data.push(0.632);
        data.push(0.6277);
        data.push(0.6276);
        data.push(0.6291);
        data.push(0.6274);
        data.push(0.6293);
        data.push(0.6311);
        data.push(0.631);
        data.push(0.6312);
        data.push(0.6312);
        data.push(0.6304);
        data.push(0.6294);
        data.push(0.6348);
        data.push(0.6378);
        data.push(0.6368);
        data.push(0.6368);
        data.push(0.6368);
        data.push(0.636);
        data.push(0.637);
        data.push(0.6418);
        data.push(0.6411);
        data.push(0.6435);
        data.push(0.6427);
        data.push(0.6427);
        data.push(0.6419);
        data.push(0.6446);
        data.push(0.6468);
        data.push(0.6487);
        data.push(0.6594);
        data.push(0.6666);
        data.push(0.6666);
        data.push(0.6678);
        data.push(0.6712);
        data.push(0.6705);
        data.push(0.6718);
        data.push(0.6784);
        data.push(0.6811);
        data.push(0.6811);
        data.push(0.6794);
        data.push(0.6804);
        data.push(0.6781);
        data.push(0.6756);
        data.push(0.6735);
        data.push(0.6763);
        data.push(0.6762);
        data.push(0.6777);
        data.push(0.6815);
        data.push(0.6802);
        data.push(0.678);
        data.push(0.6796);
        data.push(0.6817);
        data.push(0.6817);
        data.push(0.6832);
        data.push(0.6877);
        data.push(0.6912);
        data.push(0.6914);
        data.push(0.7009);
        data.push(0.7012);
        data.push(0.701);
        data.push(0.7005);
        data.push(0.7076);
        data.push(0.7087);
        data.push(0.717);
        data.push(0.7105);
        data.push(0.7031);
        data.push(0.7029);
        data.push(0.7006);
        data.push(0.7035);
        data.push(0.7045);
        data.push(0.6956);
        data.push(0.6988);
        data.push(0.6915);
        data.push(0.6914);
        data.push(0.6859);
        data.push(0.6778);
        data.push(0.6815);
        data.push(0.6815);
        data.push(0.6843);
        data.push(0.6846);
        data.push(0.6846);
        data.push(0.6923);
        data.push(0.6997);
        data.push(0.7098);
        data.push(0.7188);
        data.push(0.7232);
        data.push(0.7262);
        data.push(0.7266);
        data.push(0.7359);
        data.push(0.7368);
        data.push(0.7337);
        data.push(0.7317);
        data.push(0.7387);
        data.push(0.7467);
        data.push(0.7461);
        data.push(0.7366);
        data.push(0.7319);
        data.push(0.7361);
        data.push(0.7437);
        data.push(0.7432);
        data.push(0.7461);
        data.push(0.7461);
        data.push(0.7454);
        data.push(0.7549);
        data.push(0.7742);
        data.push(0.7801);
        data.push(0.7903);
        data.push(0.7876);
        data.push(0.7928);
        data.push(0.7991);
        data.push(0.8007);
        data.push(0.7823);
        data.push(0.7661);
        data.push(0.785);
        data.push(0.7863);
        data.push(0.7862);
        data.push(0.7821);
        data.push(0.7858);
        data.push(0.7731);
        data.push(0.7779);
        data.push(0.7844);
        data.push(0.7866);
        data.push(0.7864);
        data.push(0.7788);
        data.push(0.7875);
        data.push(0.7971);
        data.push(0.8004);
        data.push(0.7857);
        data.push(0.7932);
        data.push(0.7938);
        data.push(0.7927);
        data.push(0.7918);
        data.push(0.7919);
        data.push(0.7989);
        data.push(0.7988);
        data.push(0.7949);
        data.push(0.7948);
        data.push(0.7882);
        data.push(0.7745);
        data.push(0.771);
        data.push(0.775);
        data.push(0.7791);
        data.push(0.7882);
        data.push(0.7882);
        data.push(0.7899);
        data.push(0.7905);
        data.push(0.7889);
        data.push(0.7879);
        data.push(0.7855);
        data.push(0.7866);
        data.push(0.7865);
        data.push(0.7795);
        data.push(0.7758);
        data.push(0.7717);
        data.push(0.761);
        data.push(0.7497);
        data.push(0.7471);
        data.push(0.7473);
        data.push(0.7407);
        data.push(0.7288);
        data.push(0.7074);
        data.push(0.6927);
        data.push(0.7083);
        data.push(0.7191);
        data.push(0.719);
        data.push(0.7153);
        data.push(0.7156);
        data.push(0.7158);
        data.push(0.714);
        data.push(0.7119);
        data.push(0.7129);
        data.push(0.7129);
        data.push(0.7049);
        data.push(0.7095);

        series1.name("USD to EUR");
        series1.pointInterval(24 * 3600 * 1000).pointStart(1136073600000d);

        options.series().addToEnd(series1);

        return options;
    }
}
