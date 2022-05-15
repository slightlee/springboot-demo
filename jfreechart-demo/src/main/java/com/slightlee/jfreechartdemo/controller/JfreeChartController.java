package com.slightlee.jfreechartdemo.controller;

import com.slightlee.jfreechartdemo.util.GenerateChartUtil;
import com.slightlee.jfreechartdemo.util.GeneratePieChartUtil;
import com.slightlee.jfreechartdemo.util.JFreeChartUtil;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JfreeChartController {

    /**
     * 饼图
     *
     * @param response
     */
    @GetMapping("/pieChart")
    public void pieChart(HttpServletResponse response) throws Exception {
        //图例名称列表
        List<String> legendNameList = new ArrayList<>(Arrays.asList("一级", "二级", "三级", "四级", "五级"));
        //数据列表
        List<Object> dataList = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2));
        //图例背景颜色列表
        List<Color> legendColorList = new ArrayList<>(Arrays.asList(Color.YELLOW, Color.GRAY, Color.green, Color.cyan, Color.ORANGE));
        //偏离百分比数据
        List<Double> explodePercentList = new ArrayList<>(Arrays.asList(0.1, 0.1, 0.1, 0.1, 0.1));
        GeneratePieChartUtil.createPieChart(response.getOutputStream(), "各级占比情况", legendNameList, dataList
                , 300, 400, JFreeChartUtil.createChartTheme("宋体"), legendColorList, explodePercentList);
    }

    /**
     * 3D饼图
     *
     * @param response
     */
    @GetMapping("/pie3DChart")
    public void pie3DChart(HttpServletResponse response) throws Exception {
        //图例名称列表
        List<String> legendNameList = new ArrayList<>(Arrays.asList("一级", "二级", "三级", "四级", "五级"));
        //数据列表
        List<Object> dataList = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2));
        //图例背景颜色列表
        List<Color> legendColorList = new ArrayList<>(Arrays.asList(Color.YELLOW, Color.GRAY, Color.green, Color.cyan, Color.ORANGE));
        GeneratePieChartUtil.create3DPieChart(response.getOutputStream(), "各级占比情况", legendNameList, dataList
                , 300, 400, JFreeChartUtil.createChartTheme("宋体"), 1f, legendColorList);
    }

    /**
     * 柱状图
     *
     * @param response
     */
    @GetMapping("/barChart")
    public void barChart(HttpServletResponse response) throws Exception {
        //x轴名称列表
        List<String> xAxisNameList = new ArrayList<>(Arrays.asList("一级", "二级", "三级", "四级", "五级"));
        //图例名称列表
        List<String> legendNameList = new ArrayList<>(Arrays.asList("李四", "张三"));
        //数据列表
        List<List<Object>> dataList = new ArrayList<>();
        dataList.add(new ArrayList<>(Arrays.asList(100, 90, 5, 6, 2)));
        dataList.add(new ArrayList<>(Arrays.asList(2, 0, 3, 4, 5)));
        //图例背景颜色
        List<Color> legendColorList = new ArrayList<>(Arrays.asList(new Color(65, 105, 225)));
        GenerateChartUtil.createBarChart(response.getOutputStream(), "各级变化图", legendNameList, xAxisNameList
                , dataList, JFreeChartUtil.createChartTheme("宋体"), "y轴", "x轴"
                , 600, 400, 0d, 100d, legendColorList, true, "{2}%");
    }

    /**
     * 堆叠柱状图
     *
     * @param response
     */
    @GetMapping("/stackedBarChart")
    public void stackedBarChart(HttpServletResponse response) throws Exception {
        //x轴名称列表
        List<String> xAxisNameList = new ArrayList<>(Arrays.asList("一级", "二级", "三级", "四级", "五级"));
        //图例名称列表
        List<String> legendNameList = new ArrayList<>(Arrays.asList("李四", "张三"));
        //数据列表
        List<List<Object>> dataList = new ArrayList<>();
        dataList.add(new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2)));
        dataList.add(new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5)));
        GenerateChartUtil.createStackedBarChart(response.getOutputStream(), "各级变化图", legendNameList, xAxisNameList
                , dataList, JFreeChartUtil.createChartTheme("宋体"), "y轴", "x轴", 600, 400);
    }

    /**
     * 折线图
     *
     * @param response
     */
    @GetMapping("/lineChart")
    public void lineChart(HttpServletResponse response) throws Exception {
        //x轴名称列表
        List<String> xAxisNameList = new ArrayList<>(Arrays.asList("一级", "二级", "三级", "四级", "五级"));
        //图例名称列表
        List<String> legendNameList = new ArrayList<>(Arrays.asList("李四", "张三"));
        //数据列表
        List<List<Object>> dataList = new ArrayList<>();
        dataList.add(new ArrayList<>(Arrays.asList(1, 3, 5, 6, 2)));
        dataList.add(new ArrayList<>(Arrays.asList(2, 1, 3, 4, 5)));
        GenerateChartUtil.createLineChart(response.getOutputStream(), "各级变化图", legendNameList, xAxisNameList
                , dataList, JFreeChartUtil.createChartTheme("宋体"), "y轴", "x轴", 600, 400);
    }

    /**
     * 散点图
     *
     * @param response
     */
    @GetMapping("/scatterPlot")
    public void scatterPlot(HttpServletResponse response) throws Exception {
        //设置散点图数据集
        //设置第一个
        XYSeries firefox = new XYSeries("Firefox");
        firefox.add(1.0, 1.0);
        firefox.add(2.0, 4.0);
        firefox.add(3.0, 3.0);
        //设置第二个
        XYSeries chrome = new XYSeries("Chrome");
        chrome.add(1.0, 4.0);
        chrome.add(2.0, 5.0);
        chrome.add(3.0, 6.0);
        //设置第三个
        XYSeries ie = new XYSeries("IE");
        ie.add(3.0, 4.0);
        ie.add(4.0, 5.0);
        ie.add(5.0, 4.0);
        //添加到数据集
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(firefox);
        dataset.addSeries(chrome);
        dataset.addSeries(ie);
        GenerateChartUtil.createScatterPlot(response.getOutputStream(), "各级变化图", dataset
                , JFreeChartUtil.createChartTheme("宋体"), "y轴", "x轴", 600, 400);
    }
}
