package com.slightlee.spirepdf;

import com.spire.doc.core.HeaderType;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.PdfPageSize;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.PdfColumn;
import com.spire.pdf.tables.PdfHeaderSource;
import com.spire.pdf.tables.PdfTable;

import java.awt.*;
import java.awt.geom.Point2D;

public class ReportDemo {
    public static void main(String[] args) {

        String path = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/pdf/";

        //创建文档
        PdfDocument pdf = new PdfDocument();

        //创建画刷 黑色
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        //初始化y坐标
        float y = 30;

        //设置margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        //添加一页
        PdfPageBase page = pdf.getPages().add(PdfPageSize.A4, margin);


        //使用宋体字体绘制文字
        String fontFileName = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/font/simsun.ttc";
        PdfTrueTypeFont font14 = new PdfTrueTypeFont(fontFileName, 14f);
        PdfTrueTypeFont font12 = new PdfTrueTypeFont(fontFileName, 12f);
        PdfTrueTypeFont font10 = new PdfTrueTypeFont(fontFileName, 10f);
        PdfTrueTypeFont font7 = new PdfTrueTypeFont(fontFileName, 7f);

        //使用PdfStringFormat创建左对齐
        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left);
        //创建PdfStringFormat对象 设置文字居中
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center);

        System.out.println("====================标题=====================");

        //标题文字
        String title = "睡眠监测报告";
        String des = "报告生成时间 2022-05-10";

        //使用drawString方法绘制标题文字
        page.getCanvas().drawString(title, font14, brush, new Point2D.Float((float) page.getActualBounds(true).getWidth() / 2, 0), centerAlignment);

        page.getCanvas().drawString(des, font7 , brush, new Point2D.Float((float) page.getActualBounds(true).getWidth() / 2, 20), centerAlignment);


        System.out.println("====================表格开始=====================");

        //添加表格
        PdfTable table = new PdfTable();
        table.getStyle().setBorderPen(new PdfPen(brush, 0.5f));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        table.getStyle().setHeaderRowCount(1);
        table.getStyle().setShowHeader(true);
        table.getStyle().setCellPadding(2);
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        table.getStyle().setHeaderRowCount(1);
        table.getStyle().setShowHeader(true);

        //设置表头字体和样式
        table.getStyle().getHeaderStyle().setFont(font12);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getWhite());
        //设置偶数行字体
        table.getStyle().getDefaultStyle().setFont(font10);
        //设置奇数行字体
        table.getStyle().getAlternateStyle().setFont(font10);


        //定义数据
        String[] data = {"洲;国家;人口;世界人口占比;备注",
                "亚洲;中国;1,391,190,000;18.2%; ",
                "亚洲;日本;126,490,000;1.66%; ",
                "欧洲;英国;65,648,054;0.86%; ",
                "欧洲;德国;82,665,600;1.08%; ",
                "北美洲;加拿大;37,119,000;0.49%; ",
                "北美洲;美国;327,216,000;4.29%; "
        };
        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split("[;]", -1);
        }

        table.setDataSource(dataSource);
        for(int i = 0; i < table.getColumns().getCount();i++)
        {
            PdfColumn column= table.getColumns().get(i);
            column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        }

        //添加表格
        table.draw(page, new Point2D.Float(0, 50));


        System.out.println("====================表格结束=====================");

        //使用drawSting方法绘制文字，并在方法中传入左对齐参数
        page.getCanvas().drawString("动作图", font14 , brush, 0, 200, leftAlignment);

        /**
         * 图片
         */
        //加载图片，并获取图片高宽
        PdfImage image1 = PdfImage.fromFile("/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/ToHtml_1_images/ToHtml_1_img1.png");
        int width1 = image1.getWidth()/2;
        int height1 = image1.getHeight()/2;
        PdfImage image2 = PdfImage.fromFile("/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/ToHtml_1_images/ToHtml_1_img2.png");
        int width2 = image2.getWidth()/2;
        int height2 = image2.getHeight()/2;
        PdfImage image3 = PdfImage.fromFile("/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/ToHtml_1_images/ToHtml_1_img3.png");
        int width3 = image3.getWidth()/2;
        int height3 = image3.getHeight()/2;

        //绘制图片到PDF
        page.getCanvas().drawImage(image1,50,210,width1, height1);
        int imageHeight2 = 210  + height1;
        page.getCanvas().drawImage(image2,50,imageHeight2,width2, height2);
        int imageHeight3 = imageHeight2 + height2;
        page.getCanvas().drawImage(image3,50,imageHeight3,width3, height3);

        //保存文档
        pdf.saveToFile(path + "report.pdf");
        pdf.dispose();
    }
}