package com.usesoft.highcharts4gwt.client.logic.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.usesoft.highcharts4gwt.client.view.north.NorthView1;

public class NorthActivityHighcharts extends BaseActivity<NorthView1> implements Activity
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
