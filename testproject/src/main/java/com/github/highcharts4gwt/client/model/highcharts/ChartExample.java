package com.github.highcharts4gwt.client.model.highcharts;


public enum ChartExample
{
    Chart3DColumn
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
            return ChartCategory.Chart3DColumn;
        }

        @Override
        public String getLinkText()
        {
            return "3D Column";
        }
    },
    BasicLine
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitBasicLine(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Line;
        }

        @Override
        public String getLinkText()
        {
            return "Basic line";
        }
    },
    BasicArea
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitBasicArea(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Area;
        }

        @Override
        public String getLinkText()
        {
            return "Basic area";
        }
    },
    BasicBar
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitBasicBar(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.ColumnAndBar;
        }

        @Override
        public String getLinkText()
        {
            return "Basic bar";
        }
    },
    SolidGauge
    {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitSolidGauge(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Gauges;
        }

        @Override
        public String getLinkText()
        {
            return "Solid gauge";
        }
    },
    ColumnLineAndPie {
        @Override
        public <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitColumnLineAndPie(in);
        }

        @Override
        public String getUrlId()
        {
            return toString();
        }

        @Override
        public ChartCategory getCategory()
        {
            return ChartCategory.Combinations;
        }

        @Override
        public String getLinkText()
        {
            return "Column, line and pie";
        }
    };
    
    public abstract <IN, OUT> OUT accept(ChartVisitor<IN, OUT> visitor, IN in);

    public abstract String getUrlId();
    
    public abstract ChartCategory getCategory();
    
    public abstract String getLinkText();
    
}
