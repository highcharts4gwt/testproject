package com.github.highcharts4gwt.client.logic.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class HighMapsPlace extends BasePlace
{
    private final String paramPlace2;

    public HighMapsPlace(String paramPlace2)
    {
        this.paramPlace2 = paramPlace2;
    }

    public String getParamPlace2()
    {
        return paramPlace2;
    }

    public static class Tokenizer implements PlaceTokenizer<HighMapsPlace>
    {
        @Override
        public String getToken(HighMapsPlace place)
        {
            return place.getParamPlace2();
        }

        @Override
        public HighMapsPlace getPlace(String token)
        {
            return new HighMapsPlace(token);
        }
    }

    @Override
    public <IN, OUT> OUT accept(PlaceVisitor<IN, OUT> visitor, IN in)
    {
        return visitor.visit(this, in);
    }
}
