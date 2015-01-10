package com.github.highcharts4gwt.client.logic.presenter;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;

public abstract class BasePresenter<T> implements Presenter<T>
{
    protected EventBus eventBus;

    @Inject
    T view;

    @Override
    public final void start(EventBus eventBus)
    {
        this.eventBus = eventBus;
        onStart();
    }

    /**
     * Empty. To be implemented by presenters to do their initialization.
     */
    protected abstract void onStart();

    /**
     * Empty. To be implemented by presenters to clean up stuff (dispose of sub-presenters, etc.) before closing.
     */
    protected abstract void onDispose();


    public EventBus getEventBus()
    {
        return eventBus;
    }
    
    @Override
    public void dispose()
    {
        onDispose();
    }

    @Override
    public T getView()
    {
        return view;
    }
}
