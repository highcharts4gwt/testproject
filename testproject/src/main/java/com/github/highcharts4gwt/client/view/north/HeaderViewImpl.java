package com.github.highcharts4gwt.client.view.north;

import javax.inject.Inject;

import com.github.highcharts4gwt.client.view.resources.MyResources;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

public class HeaderViewImpl extends Composite implements HeaderView
{
    private Presenter presenter;
    
    
    @UiField
    FocusPanel title;
    
    @Inject
    public HeaderViewImpl(WestViewUiBinder binder, MyResources resources)
    {
        initWidget(binder.createAndBindUi(this));
        
        title.addStyleName(resources.myStyle().title());
    }

    @UiTemplate("HeaderView.ui.xml")
    interface WestViewUiBinder extends UiBinder<Widget, HeaderViewImpl>
    {

    }

//    @UiHandler("place1Button")
//    void click1(ClickEvent event)
//    {
//        presenter.navigateToHighcharts();
//    }
//
//    @UiHandler("place2Button")
//    void click2(ClickEvent event)
//    {
//        presenter.navigateToHighMaps();
//    }
    
    @UiHandler("title")
    void click3(ClickEvent event)
    {
        presenter.navigateGithub();
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

}
