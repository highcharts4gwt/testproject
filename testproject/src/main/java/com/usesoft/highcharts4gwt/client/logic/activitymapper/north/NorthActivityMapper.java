package com.usesoft.highcharts4gwt.client.logic.activitymapper.north;

import javax.inject.Inject;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.usesoft.highcharts4gwt.client.logic.place.BasePlace;

public class NorthActivityMapper implements ActivityMapper
{
    @Inject
    NorthPlaceToActivityVisitor visitor;

    @Override
    public Activity getActivity(Place place)
    {
        if (!(place instanceof BasePlace))
            return null;

        return ((BasePlace) place).accept(visitor, null);
    }

}
