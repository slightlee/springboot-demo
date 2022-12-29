package com.demain.test;

import org.icepear.echarts.Line;
import org.icepear.echarts.charts.line.LineAreaStyle;
import org.icepear.echarts.charts.line.LineSeries;
import org.icepear.echarts.components.coord.cartesian.CategoryAxis;
import org.icepear.echarts.render.Engine;

/**
 * 生成html代码
 *
 * @author demain_lee
 * @since 2022/12/29
 */
public class EchartData2Html {

    public static void main(String[] args) {
        getLine();
    }

    static void getLine() {

        Line line = new Line()
                .addXAxis(new CategoryAxis()
                        .setData(new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"})
                        .setBoundaryGap(false))
                .addYAxis()
                .addSeries(new LineSeries()
                        .setData(new Number[]{820, 932, 901, 934, 1290, 1330, 1320})
                        .setType("bar")
                        .setAreaStyle(new LineAreaStyle()));
        Engine engine = new Engine();
        // return the full html of the echarts, used in iframes in your own template
        String json = engine.renderHtml(line);
        System.out.println(json);
    }

}
