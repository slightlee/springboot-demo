package com.slightlee.spirepdf;

import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class CreatePDFTable {
    public static void main(String[] args) {

        String path = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/pdf/";

        //创建PDF文档
        PdfDocument doc = new PdfDocument();
        //设置margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // 添加一页
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        //添加表格
        PdfTable table = new PdfTable();
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));
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
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("宋体",Font.PLAIN, 12));
        table.getStyle().getHeaderStyle().setFont(font);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        PdfTrueTypeFont fontBody = new PdfTrueTypeFont(new Font("宋体", Font.PLAIN,10));
        //设置偶数行字体
        table.getStyle().getDefaultStyle().setFont(fontBody);
        //设置奇数行字体
        table.getStyle().getAlternateStyle().setFont(fontBody);

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

        //保存文档
        doc.saveToFile(path + "addTable.pdf", FileFormat.PDF);
    }
}