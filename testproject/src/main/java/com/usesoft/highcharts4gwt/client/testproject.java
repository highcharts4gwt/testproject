package com.usesoft.highcharts4gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.usesoft.highcharts4gwt.client.infrastructure.injection.copy.MyGinjector;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.AppPlaceHistoryMapper;
import com.usesoft.highcharts4gwt.client.logic.activitymapper.PlaceControllerHolder;
import com.usesoft.highcharts4gwt.client.logic.place.Highcharts;
import com.usesoft.highcharts4gwt.client.view.region.Region;
import com.usesoft.highcharts4gwt.client.view.rootlayout.RootView;
import com.usesoft.highcharts4gwt.client.view.widget.HighchartsLayoutPanel;
import com.usesoft.highcharts4gwt.model.array.api.ArrayNumber;
import com.usesoft.highcharts4gwt.model.array.api.ArrayString;
import com.usesoft.highcharts4gwt.model.highcharts.api.ChartOptions;
import com.usesoft.highcharts4gwt.model.highcharts.api.Series;

public class testproject implements EntryPoint
{ 
    private final MyGinjector injector = GWT.create(MyGinjector.class);
    
    public void onModuleLoad()
    {
        RootView.Presenter rootPresenter = injector.getRootPresenter();

        PlaceControllerHolder placeControllerHolder = injector.getPlaceControllerHolder();

        // Initialize a manager per region
        ActivityManager northActivityManager = new ActivityManager(injector.getNorthActivityMapper(), placeControllerHolder.getEventBus());
        northActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.North));

        ActivityManager westActivityManager = new ActivityManager(injector.getWestActivityMapper(), placeControllerHolder.getEventBus());
        westActivityManager.setDisplay(rootPresenter.getView().getRegion(Region.West));

        // Do the same for center, south ...


        AppPlaceHistoryMapper historyMapper= injector.getAppPlaceHistoryMapper();
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeControllerHolder.getPlaceController(), placeControllerHolder.getEventBus(), new Highcharts("test"));

        RootLayoutPanel.get().add(rootPresenter.getView().asWidget());

        // Activate navigation history and go to default place
        historyHandler.handleCurrentHistory();
    }

    private void renderChart()
    {
        DockLayoutPanel dlp = new DockLayoutPanel(Unit.PX);

        HighchartsLayoutPanel container = new HighchartsLayoutPanel();

        dlp.addNorth(new Label("North"), 100);
        dlp.addWest(new Label("West"), 100);
        dlp.addSouth(new Label("South"), 100);

        dlp.add(container);

        RootLayoutPanel.get().add(dlp);

        // OptionsFactory factory = new OptionsFactoryJso();

        ChartOptions options = chart3D();

        // JSONObject test = new JSONObject((JavaScriptObject)options);
        // System.out.println(test.toString());

        container.renderChart(options);
    }

    private ChartOptions chart2()
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

    private ChartOptions chart3D()
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

    private ChartOptions chart1()
    {
        ChartOptions options = (ChartOptions) JavaScriptObject.createObject();

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
}
