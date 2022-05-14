package com.slightlee.spirepdf;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.*;

public class PdfFonts {

    public static void main(String[] args) {

        String path = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/pdf/";

        //创建PdfDocument对象
        PdfDocument doc = new PdfDocument();

        //添加一页
        PdfPageBase page = doc.getPages().add();

        //创建画刷
        PdfBrush brush = PdfBrushes.getBlack();

        //初始化y坐标
        float y = 30;

        //使用standard字体绘制文字
        PdfFont standardFont = new PdfFont(PdfFontFamily.Helvetica, 14f);
        page.getCanvas().drawString("Standard Font - Helvetica", standardFont, brush, 0, y);
        standardFont = new PdfFont(PdfFontFamily.Times_Roman, 14f);
        page.getCanvas().drawString("Standard Font - Times_Roman", standardFont, brush, 0, (y = y + 16));
        standardFont = new PdfFont(PdfFontFamily.Courier, 14f);
        page.getCanvas().drawString("Standard Font - Courier", standardFont, brush, 0, (y = y + 16));

        //使用true type字体绘制文字
        java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 14);
        PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);
        page.getCanvas().drawString("TrueType Font - Arial", trueTypeFont, brush, 0, (y = y + 30f));

        //使用私有字体绘制文字
        String fontFileName = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/font/simsun.ttc";
        trueTypeFont = new PdfTrueTypeFont(fontFileName, 14f);
        page.getCanvas().drawString("Private Font - simsun 宋体", trueTypeFont, brush, 0, (y = y + 30f));

        //使用cjk字体绘制文字
        PdfCjkStandardFont cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Monotype_Hei_Medium, 14f);
        page.getCanvas().drawString("How to say 'Font' in Chinese? \u5B57\u4F53", cjkFont, brush, 0, (y = y + 30f));
        cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Gothic_Medium, 14f);
        page.getCanvas().drawString("How to say 'Font' in Japanese? \u30D5\u30A9\u30F3\u30C8", cjkFont, brush, 0, (y = y + 16f));
        cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Shin_Myeong_Jo_Medium, 14f);
        page.getCanvas().drawString("How to say 'Font' in Korean? \uAE00\uAF34", cjkFont, brush, 0, (y = y + 16f));

        //保存文档
        doc.saveToFile(path + "Fonts1.pdf");
        doc.close();
    }
}