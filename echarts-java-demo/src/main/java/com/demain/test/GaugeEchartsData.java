package com.demain.test;

import org.icepear.echarts.Gauge;
import org.icepear.echarts.charts.gauge.*;
import org.icepear.echarts.components.coord.AxisLine;
import org.icepear.echarts.components.coord.CategoryAxisLabel;
import org.icepear.echarts.components.coord.CategoryAxisTick;
import org.icepear.echarts.components.coord.SplitLine;
import org.icepear.echarts.components.series.ItemStyle;
import org.icepear.echarts.components.series.LineStyle;
import org.icepear.echarts.render.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成json数据 以及 本地html文件
 *
 * @author demain_lee
 * @since 2022/12/28
 */
public class GaugeEchartsData {

    public static void main(String[] args) {

        getGauge();

    }

    /**
     * 仪表盘
     * 使用 {@link Gauge} 构建
     * ref: <a href="https://echarts.apache.org/examples/zh/editor.html?c=gauge-ring">...</a>
     */
    static void getGauge() {

        List<ObjectData> list = new ArrayList<>();

        Detail detail1 = Detail.builder().valueAnimation(true).offsetCenter(new String[]{"0%25", "-10%25"}).build();
        Detail detail2 = Detail.builder().valueAnimation(true).offsetCenter(new String[]{"0%25", "30%25"}).build();
        Detail detail3 = Detail.builder().valueAnimation(true).offsetCenter(new String[]{"0%25", "70%25"}).build();

        Title title1 = Title.builder().offsetCenter(new String[]{"0%25", "-30%25"}).build();
        Title title2 = Title.builder().offsetCenter(new String[]{"0%25", "10%25"}).build();
        Title title3 = Title.builder().offsetCenter(new String[]{"0%25", "50%25"}).build();

        ObjectData objectData1 = ObjectData.builder().name("数据测试1").value(20).title(title1).detail(detail1).build();
        ObjectData objectData2 = ObjectData.builder().name("数据测试2").value(40).title(title2).detail(detail2).build();
        ObjectData objectData3 = ObjectData.builder().name("数据测试3").value(60).title(title3).detail(detail3).build();

        list.add(objectData1);
        list.add(objectData2);
        list.add(objectData3);

        //仪表盘
        Gauge gauge = new Gauge()
                .addSeries(new GaugeSeries()
                        .setType("gauge")
                        .setStartAngle(90)
                        .setEndAngle(-270)
                        .setPointer(new GaugePointer().setShow(false))
                        .setProgress(new GaugeProgress().setShow(true)
                                .setOverlap(false)
                                .setRoundCap(true)
                                .setClip(false)
                                .setItemStyle(new ItemStyle().setBorderWidth(1)
                                        .setBorderColor("#464646")))
                        .setAxisLine(new AxisLine().setLineStyle(new LineStyle().setWidth(40)))
                        .setSplitLine(new SplitLine().setShow(false))
                        .setAxisTick(new CategoryAxisTick().setShow(false))
                        .setAxisLabel(new CategoryAxisLabel().setShow(false))
                        .setData(list)
                        .setTitle(new GaugeTitle().setFontSize(12))
                        .setDetail(new GaugeDetail()
                                        .setWidth(40).setHeight(8).setFontSize(10)
                                        .setColor("auto").setBorderColor("auto").setBorderRadius(20).setBorderWidth(1)
//                                .setFormatter("{value}%")
                                        .setFormatter("{value}分")
                        ));

        Engine engine = new Engine();
        engine.render("demo-gauge.html", gauge);

    }



    /**
     * 仪表盘数据
     */
    public static class ObjectData {
        private String name;
        private Integer value;
        private Title title;
        private Detail detail;

        public ObjectData(ObjectDataBuilder objectDataBuilder) {
            this.name = objectDataBuilder.name;
            this.value = objectDataBuilder.value;
            this.title = objectDataBuilder.title;
            this.detail = objectDataBuilder.detail;
        }

        public static ObjectDataBuilder builder() {
            return new ObjectDataBuilder();
        }

        public static class ObjectDataBuilder {
            private String name;
            private Integer value;
            private Title title;
            private Detail detail;

            public ObjectDataBuilder name(String name) {
                this.name = name;
                return this;
            }

            public ObjectDataBuilder value(Integer value) {
                this.value = value;
                return this;
            }

            public ObjectDataBuilder title(Title title) {
                this.title = title;
                return this;
            }

            public ObjectDataBuilder detail(Detail detail) {
                this.detail = detail;
                return this;
            }

            public ObjectData build() {
                return new ObjectData(this);
            }

        }

    }


    public static class Title {
        private String[] offsetCenter;

        public Title(TitleBuilder titleBuilder) {
            this.offsetCenter = titleBuilder.offsetCenter;
        }

        public static TitleBuilder builder() {
            return new TitleBuilder();
        }

        public static class TitleBuilder {
            private String[] offsetCenter;

            public TitleBuilder offsetCenter(String[] offsetCenter) {
                this.offsetCenter = offsetCenter;
                return this;
            }

            public Title build() {
                return new Title(this);
            }
        }

    }

    public static class Detail {
        private boolean valueAnimation;
        private String[] offsetCenter;

        public Detail(DetailBuilder detailBuilder) {
            this.valueAnimation = detailBuilder.valueAnimation;
            this.offsetCenter = detailBuilder.offsetCenter;
        }

        public static DetailBuilder builder() {
            return new DetailBuilder();
        }

        public static class DetailBuilder {
            private boolean valueAnimation;
            private String[] offsetCenter;

            public DetailBuilder valueAnimation(boolean valueAnimation) {
                this.valueAnimation = valueAnimation;
                return this;
            }

            public DetailBuilder offsetCenter(String[] offsetCenter) {
                this.offsetCenter = offsetCenter;
                return this;
            }

            public Detail build() {
                return new Detail(this);
            }
        }
    }

}





