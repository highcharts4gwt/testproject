package com.usesoft.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class Highcharts extends BasePlace
{
    private final String paramPlace1;

    public Highcharts(String paramPlace1)
    {
        this.paramPlace1 = paramPlace1;
    }

    public String getParamPlace1()
    {
        return paramPlace1;
    }

    public static class Tokenizer implements PlaceTokenizer<Highcharts> {
        @Override
        public String getToken(Highcharts place) {
            return place.getParamPlace1();
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
