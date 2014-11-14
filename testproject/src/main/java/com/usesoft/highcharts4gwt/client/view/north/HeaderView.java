package com.usesoft.highcharts4gwt.client.view.north;

import com.google.gwt.user.client.ui.IsWidget;

public interface HeaderView extends IsWidget
{
    void setPresenter(Presenter presenter);

    interface Presenter
    {
        void navigateToHighcharts();

        void navigateToHighMaps();
    }
}
