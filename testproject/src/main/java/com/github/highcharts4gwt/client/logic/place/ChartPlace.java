package com.github.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class ChartPlace extends BasePlace
{
    private final String chartName;
    
    public ChartPlace(String chartName)
    {
        this.chartName = chartName;
    }

    public String getChartName()
    {
        return chartName;
    }

    public static class Tokenizer implements PlaceTokenizer<ChartPlace> {
        @Override
        public String getToken(ChartPlace place) {
            return place.getChartName();
        }

        @Override
        public ChartPlace getPlace(String token) {
            return new ChartPlace(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
