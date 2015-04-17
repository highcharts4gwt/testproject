package com.github.highcharts4gwt.client.model.highcharts;

import com.github.ronanquillevere.generator.ExportAnnotations.ExportMethod;

public interface ChartCodeVisitor extends ChartVisitor<Void, String>
{
    // http://www.freeformatter.com/java-dotnet-escape.html#ad-output

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitChart3D")
    @Override
    public String visitChart3D(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitBasicLine")
    @Override
    public String visitBasicLine(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitBasicArea")
    @Override
    public String visitBasicArea(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitBasicBar")
    @Override
    public String visitBasicBar(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitSolidGauge")
    @Override
    public String visitSolidGauge(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitColumnLineAndPie")
    @Override
    public String visitColumnLineAndPie(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitTreeMapWithColumnAxis")
    @Override
    public String visitPolarChart(Void in);

    @ExportMethod(type = ChartOptionsVisitor.class, marker = "visitTreeMapWithColumnAxis")
    @Override
    public String visitTreeMapWithColumnAxis(Void in);
}
