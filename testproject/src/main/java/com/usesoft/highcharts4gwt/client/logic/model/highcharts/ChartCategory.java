package com.usesoft.highcharts4gwt.client.logic.model.highcharts;

public enum ChartCategory
{
    Column {
        @Override
        public String getCategoryDescription()
        {
            return "Column charts";
        }
    },
    Bar {
        @Override
        public String getCategoryDescription()
        {
            return "Bar charts";
        }
    },
    Chart3D {
        @Override
        public String getCategoryDescription()
        {
            return "3D charts";
        }
    },
    MultipleAxes {
        @Override
        public String getCategoryDescription()
        {
            return "Charts with multiple axes";
        }
    };
    
    
    public abstract String getCategoryDescription();
    
    
}   
