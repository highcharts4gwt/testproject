package com.github.highcharts4gwt.client.view.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MyResources extends ClientBundle
{
    @Source("css/style.css")
    MyStyle myStyle();
    
    @Source("gfx/h4gwt.png")
    ImageResource logo();
}
