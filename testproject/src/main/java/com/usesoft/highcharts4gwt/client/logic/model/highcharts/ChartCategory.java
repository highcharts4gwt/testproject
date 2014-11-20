package com.usesoft.highcharts4gwt.client.logic.model.highcharts;

public enum ChartCategory
{
    Line {
        @Override
        public String getCategoryDescription()
        {
            return "LINE CHARTS";
        }
    },
    ColumnAndBar {
        @Override
        public String getCategoryDescription()
        {
            return "COLUMN AND BAR CHARTS";
        }
    },
    Chart3D {
        @Override
        public String getCategoryDescription()
        {
            return "3D CHARTS";
        }
    },
    Combinations {
        @Override
        public String getCategoryDescription()
        {
            return "COMBINATIONS";
        }
    },
    Debug {
        @Override
        public String getCategoryDescription()
        {
            return "DEBUG";
        }
    };
    
    
    public abstract String getCategoryDescription();
    
    
}   
