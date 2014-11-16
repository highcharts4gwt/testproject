package com.usesoft.highcharts4gwt.client.view.west;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class WestViewHighchartsImpl extends SimpleLayoutPanel implements WestViewHighcharts
{
    public WestViewHighchartsImpl()
    {
        Label l = new Label("West Activity for highcharts wrapper");
        this.add(l);
    }
}
