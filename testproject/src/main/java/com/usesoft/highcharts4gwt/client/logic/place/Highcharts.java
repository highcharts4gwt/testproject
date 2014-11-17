package com.usesoft.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class Highcharts extends BasePlace
{
    private final String chartName;

    public Highcharts(String chartName)
    {
        this.chartName = chartName;
    }

    public String getChartName()
    {
        return chartName;
    }

    public static class Tokenizer implements PlaceTokenizer<Highcharts> {
        @Override
        public String getToken(Highcharts place) {
            return place.getChartName();
        }

        @Override
        public Highcharts getPlace(String token) {
            return new Highcharts(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
