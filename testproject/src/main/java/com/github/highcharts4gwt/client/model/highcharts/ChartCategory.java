package com.github.highcharts4gwt.client.model.highcharts;

public enum ChartCategory
{
    Line
    {
        @Override
        public String getCategoryDescription()
        {
            return "LINE CHARTS";
        }
    },
    Area
    {
        @Override
        public String getCategoryDescription()
        {
            return "AREA CHARTS";
        }
    },
    ColumnAndBar
    {
        @Override
        public String getCategoryDescription()
        {
            return "COLUMN AND BAR CHARTS";
        }
    },
    Chart3DColumn
    {
        @Override
        public String getCategoryDescription()
        {
            return "3D CHARTS";
        }
    },
    Combinations
    {
        @Override
        public String getCategoryDescription()
        {
            return "COMBINATIONS";
        }
    },
    Debug
    {
        @Override
        public String getCategoryDescription()
        {
            return "DEBUG";
        }
    },
    Gauges
    {
        @Override
        public String getCategoryDescription()
        {
            return "GAUGES";
        }
    },
    HeatAndTreeMap
    {
        @Override
        public String getCategoryDescription()
        {
            return "HEAT AND TREE MAPS ";
        }
    },
    ScatterAndBubbleCharts {
        @Override
        public String getCategoryDescription()
        {
            return "SCATTER AND BUBBLE CHARTS";
        }
    },
    MoreChartTypes {
        @Override
        public String getCategoryDescription()
        {
            return "MORE CHART TYPES";
        }
    };

    public abstract String getCategoryDescription();

}
