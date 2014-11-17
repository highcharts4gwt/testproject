package com.usesoft.highcharts4gwt.client.logic.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.inject.assistedinject.Assisted;
import com.usesoft.highcharts4gwt.client.logic.model.highcharts.Chart;

public interface CenterActivityHighchartsFactory
{
    Activity create(@Assisted Chart chart);
}
