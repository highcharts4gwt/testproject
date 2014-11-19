package com.usesoft.highcharts4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.usesoft.highcharts4gwt.client.infrastructure.injection.copy.ApplicationContext;
import com.usesoft.highcharts4gwt.client.infrastructure.injection.copy.MyGinjector;
import com.usesoft.highcharts4gwt.client.view.resources.MyResources;

public class testproject implements EntryPoint
{ 
    
    
    public void onModuleLoad()
    {
        final MyGinjector injector = GWT.create(MyGinjector.class);
        
        injectStyles(injector);
        //to initialize appCtx
        final ApplicationContext appCtx = injector.getApplicationContext();
        
        appCtx.getHistoryHandler().handleCurrentHistory();
    }

    private void injectStyles(MyGinjector injector)
    {
       MyResources resources = injector.getResources();
       resources.myStyle().ensureInjected();
    }
   
}
