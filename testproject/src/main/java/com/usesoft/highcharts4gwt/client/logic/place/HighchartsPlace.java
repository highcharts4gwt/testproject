package com.usesoft.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.usesoft.highcharts4gwt.client.model.highcharts.Chart;

public class HighchartsPlace extends BasePlace
{
    private final String chartName;
    
    public HighchartsPlace()
    {
       this(Chart.Chart3DColumn.getUrlId());
    }
    
    public HighchartsPlace(String chartName)
    {
        this.chartName = chartName;
    }

    public String getChartName()
    {
        return chartName;
    }

    public static class Tokenizer implements PlaceTokenizer<HighchartsPlace> {
        @Override
        public String getToken(HighchartsPlace place) {
            return place.getChartName();
        }

        @Override
        public HighchartsPlace getPlace(String token) {
            return new HighchartsPlace(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
