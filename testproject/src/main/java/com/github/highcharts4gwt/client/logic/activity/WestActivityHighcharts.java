package com.github.highcharts4gwt.client.logic.activity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.infrastructure.injection.copy.ApplicationContext;
import com.github.highcharts4gwt.client.logic.place.ChartPlace;
import com.github.highcharts4gwt.client.model.highcharts.ChartExample;
import com.github.highcharts4gwt.client.model.highcharts.ChartCategory;
import com.github.highcharts4gwt.client.view.west.WestViewHighcharts;

public class WestActivityHighcharts extends BaseActivity<WestViewHighcharts> implements WestViewHighcharts.Presenter
{
    private ApplicationContext applicationContext;

    @Inject
    public WestActivityHighcharts(ApplicationContext applicationContext)
    {
        this.applicationContext = applicationContext;
    }
    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart()
    {
        getView().setPresenter(this);
        
        for (ChartCategory category : ChartCategory.values())
        {
            List<ChartExample> linksToAdd  = new ArrayList<>();
            for (ChartExample chart : ChartExample.values())
            {
                if (chart.getCategory() == category)
                    linksToAdd.add(chart);
            }
            
            if (linksToAdd.size()>0)
                getView().addCategory(category);
            for (ChartExample chart : linksToAdd)
            {
                getView().addLink(chart);
            }
        }
    }

    @Override
    protected void onDispose()
    {
        
    }

    @Override
    public void navigateTo(ChartExample chart)
    {
        applicationContext.getPlaceController().goTo(new ChartPlace(chart.getUrlId()));
    }

}
