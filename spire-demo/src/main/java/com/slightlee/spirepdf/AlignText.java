package com.slightlee.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.*;

import java.awt.*;

public class AlignText {

    public static void main(String[] args) {

        String path = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/pdf/";

        //创建PdfDocument对象
        PdfDocument doc = new PdfDocument();
        
        //添加一页
        PdfPageBase page = doc.getPages().add();

        //创建CJK字体
        PdfCjkStandardFont cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Sino_Type_Song_Light, 15f);


        //创建画刷
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        //使用PdfStringFormat创建左对齐
        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left);
        
        //使用drawSting方法绘制文字，并在方法中传入左对齐参数
        page.getCanvas().drawString("靠左", cjkFont , brush, 0, 20, leftAlignment);

        //绘制右对齐文字
        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right);
        page.getCanvas().drawString("靠右", cjkFont , brush, page.getCanvas().getClientSize().getWidth(), 20, rightAlignment);

        //绘制居中文字
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("居中", cjkFont , brush, page.getCanvas().getClientSize().getWidth() / 2, 20, centerAlignment);

        //保存文档
        doc.saveToFile(path + "AlignText.pdf");
    }
}