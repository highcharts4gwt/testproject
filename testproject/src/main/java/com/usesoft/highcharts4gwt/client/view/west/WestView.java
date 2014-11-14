package com.usesoft.highcharts4gwt.client.view.west;

import com.google.gwt.user.client.ui.IsWidget;

public interface WestView extends IsWidget
{
    void setPresenter(Presenter presenter);

    interface Presenter
    {
        void navigateToHighcharts();

        void navigateToHighMaps();
    }
}
