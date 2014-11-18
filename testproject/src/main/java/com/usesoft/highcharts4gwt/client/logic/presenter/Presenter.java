package com.usesoft.highcharts4gwt.client.logic.presenter;

import com.google.web.bindery.event.shared.EventBus;

public interface Presenter<T>
{
    void start(EventBus eventBus);

    T getView();
    
    void dispose();
}
