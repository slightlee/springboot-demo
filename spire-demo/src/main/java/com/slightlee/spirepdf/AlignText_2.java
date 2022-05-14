package com.slightlee.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.*;

import java.awt.*;

public class AlignText_2 {

    public static void main(String[] args) {

        String path = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/pdf/";

        //创建PdfDocument对象
        PdfDocument doc = new PdfDocument();

        //创建画刷
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        //初始化y坐标
        float y = 30;

        //添加一页
        PdfPageBase page = doc.getPages().add();

        //使用宋体字体绘制文字
        String fontFileName = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/font/simsun.ttc";
        PdfTrueTypeFont simsunFont = new PdfTrueTypeFont(fontFileName, 14f);

        page.getCanvas().drawString("Private Font - simsun 宋体", simsunFont, brush, 0, (y = y + 30f));


        //使用PdfStringFormat创建左对齐
        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left);
        
        //使用drawSting方法绘制文字，并在方法中传入左对齐参数
        page.getCanvas().drawString("靠左", simsunFont , brush, 0, 20, leftAlignment);

        //绘制右对齐文字
        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right);
        page.getCanvas().drawString("靠右", simsunFont , brush, page.getCanvas().getClientSize().getWidth(), 20, rightAlignment);

        //绘制居中文字
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("居中", simsunFont , brush, page.getCanvas().getClientSize().getWidth() / 2, 20, centerAlignment);

        //保存文档
        doc.saveToFile(path + "AlignText_2.pdf");
    }
}