package com.github.highcharts4gwt.client.logic.activitymapper.east;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.logic.place.BasePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class EastActivityMapper implements ActivityMapper
{
    @Inject
    EastPlaceToActivityVisitor visitor;

    @Override
    public Activity getActivity(Place place)
    {
        if (!(place instanceof BasePlace))
            return null;

        return ((BasePlace) place).accept(visitor, null);
    }

}
