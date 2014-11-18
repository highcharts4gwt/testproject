package com.usesoft.highcharts4gwt.client.logic.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.usesoft.highcharts4gwt.client.logic.presenter.BasePresenter;

public abstract class BaseActivity<T extends IsWidget> extends BasePresenter<T> implements Activity
{
    @Override
    public String mayStop()
    {
        return null;
    }

    @Override
    public void onCancel()
    {
    }
    
    @Override
    public void onStop()
    {
        dispose();
    }

    /*
     * Adapter between the old EventBus and the new one
     */
    @Override
    @Deprecated
    public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus)
    {
       start(panel, ((com.google.web.bindery.event.shared.EventBus) eventBus));
    }
    
    protected final void start(AcceptsOneWidget containerWidget, com.google.web.bindery.event.shared.EventBus eventBus)
    {
       containerWidget.setWidget(getView());
       start(eventBus);
    }
}
