package com.usesoft.highcharts4gwt.client.view.north;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HeaderViewImpl extends Composite implements HeaderView
{
    private Presenter presenter;

    @Inject
    public HeaderViewImpl(WestViewUiBinder binder)
    {
        initWidget(binder.createAndBindUi(this));
    }

    @UiTemplate("HeaderView.ui.xml")
    interface WestViewUiBinder extends UiBinder<Widget, HeaderViewImpl>
    {

    }

    @UiHandler("place1Button")
    void click1(ClickEvent event)
    {
        presenter.navigateToHighcharts();
    }

    @UiHandler("place2Button")
    void click2(ClickEvent event)
    {
        presenter.navigateToHighMaps();
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

}
