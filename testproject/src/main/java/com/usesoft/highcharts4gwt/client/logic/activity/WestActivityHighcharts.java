package com.usesoft.highcharts4gwt.client.logic.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.usesoft.highcharts4gwt.client.view.west.WestViewHighcharts;

public class WestActivityHighcharts extends BaseActivity<WestViewHighcharts> implements Activity
{

    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(AcceptsOneWidget panel)
    {
        panel.setWidget(getView());
    }

}
