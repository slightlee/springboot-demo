package demo;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.File;
import java.io.IOException;

/**
 * 简单的表格 自定义单元格颜色以及字体颜色
 *
 * @author demain_lee
 * @since 2022/12/30
 */
public class SimpleTable2 {
    public static final String DEST = "./target/sandbox/tables/simple_table2.pdf";

    /**
     * 设置字体
     * 默认字体不支持中文
     */
    private static final String SIMSUN = "./itext7-demo/src/main/resources/fonts/simsun.ttf";

    PdfFont simsumFont = PdfFontFactory.createFont(SIMSUN);

    public SimpleTable2() throws IOException {
    }


    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new SimpleTable2().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(4)).useAllAvailableWidth();

        Cell sn = new Cell(2, 1).setFont(simsumFont).add(new Paragraph("序号"));
        sn.setBackgroundColor(ColorConstants.YELLOW);
        table.addCell(sn);

        Cell name = new Cell(1, 2).setFont(simsumFont).add(new Paragraph("名字"));
        name.setBackgroundColor(ColorConstants.CYAN);
        table.addCell(name);

        Cell age = new Cell(2, 1).setFont(simsumFont).add(new Paragraph("年龄"));
        age.setBackgroundColor(ColorConstants.GRAY);
        table.addCell(age);

        Cell surname = new Cell().setFont(simsumFont).setFontColor(ColorConstants.ORANGE).add(new Paragraph("姓氏"));
        table.addCell(surname);

        Cell firstname = new Cell().setFont(simsumFont).add(new Paragraph("名字"));
        firstname.setBackgroundColor(ColorConstants.RED);
        table.addCell(firstname);

        Cell f1 = new Cell().add(new Paragraph("1"));
        f1.setBackgroundColor(ColorConstants.PINK);
        table.addCell(f1);

        Cell f2 = new Cell().setFont(simsumFont).add(new Paragraph("张"));
        f2.setBackgroundColor(ColorConstants.MAGENTA);
        table.addCell(f2);

        Cell f3 = new Cell().setFont(simsumFont).add(new Paragraph("三丰"));
        f3.setBackgroundColor(ColorConstants.ORANGE);
        table.addCell(f3);

        Cell f4 = new Cell().add(new Paragraph("18"));
        f4.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addCell(f4);

        doc.add(table);

        doc.close();
    }
}
