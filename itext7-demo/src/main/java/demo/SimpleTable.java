package demo;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;

import java.io.File;
import java.io.IOException;

/**
 * 简单的表格
 *
 * @author demain_lee
 * @since 2022/12/30
 */
public class SimpleTable {


    public static final String DEST = "./target/sandbox/tables/simple_table.pdf";

    /**
     * 设置字体
     * 默认字体不支持中文
     */
    private static final String SIMSUN = "./itext7-demo/src/main/resources/fonts/simsun.ttf";

    PdfFont simsumFont = PdfFontFactory.createFont(SIMSUN);

    public SimpleTable() throws IOException {
    }

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new SimpleTable().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(8)).useAllAvailableWidth();
        // 表格除了字体之外，也可设置别的属性
        table.setFont(simsumFont);

        for (int i = 0; i < 16; i++) {
            table.addCell("我是测试数据");
        }

        doc.add(table);

        doc.close();
    }
}
