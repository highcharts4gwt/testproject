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
        public String toUrlParam()
        {
            return toString();
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
        public String toUrlParam()
        {
            return toString();
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
        public String toUrlParam()
        {
            return toString();
        }
    };

    public abstract <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in);

    public abstract String toUrlParam();
}
