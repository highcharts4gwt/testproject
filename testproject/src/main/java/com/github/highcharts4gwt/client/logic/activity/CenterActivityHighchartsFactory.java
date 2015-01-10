package com.github.highcharts4gwt.client.logic.activity;

import com.github.highcharts4gwt.client.model.highcharts.ChartExample;
import com.google.gwt.activity.shared.Activity;
import com.google.inject.assistedinject.Assisted;

public interface CenterActivityHighchartsFactory
{
    Activity create(@Assisted ChartExample chart);
}
