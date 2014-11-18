package com.usesoft.highcharts4gwt.client.logic.model.highcharts;

public enum Chart
{
    Chart3D
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitChart3D(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Chart3D;
        }

        @Override
        public String getLinkText()
        {
            return "Column 3D chart";
        }
    },
    Chart1
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitChart1(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Column;
        }

        @Override
        public String getLinkText()
        {
            return "Chart with column";
        }
    },
    Chart2
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitChart2(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Bar;
        }

        @Override
        public String getLinkText()
        {
            return "Chart with bar";
        }
    };

    public abstract <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in);

    public abstract String getUrlId();
    
    public abstract ChartCategory getCategory();
    
    public abstract String getLinkText();
}
