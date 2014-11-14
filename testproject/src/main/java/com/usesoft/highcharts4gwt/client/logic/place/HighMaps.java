package com.usesoft.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class HighMaps extends BasePlace
{
    private final String paramPlace2;

    public HighMaps(String paramPlace2)
    {
        this.paramPlace2 = paramPlace2;
    }

    public String getParamPlace2()
    {
        return paramPlace2;
    }

    public static class Tokenizer implements PlaceTokenizer<HighMaps>
    {
        @Override
        public String getToken(HighMaps place)
        {
            return place.getParamPlace2();
        }

        @Override
        public HighMaps getPlace(String token)
        {
            return new HighMaps(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
