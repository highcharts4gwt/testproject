package com.usesoft.highcharts4gwt.client.infrastructure.injection.copy;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.usesoft.highcharts4gwt.client.view.resources.MyResources;

@GinModules(MyModule.class)
public interface MyGinjector extends Ginjector
{
    ApplicationContext getApplicationContext();
    
    MyResources getResources();
}
