package demo;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.File;
import java.io.IOException;

/**
 * 页眉、页脚
 *
 * @author demain_lee
 * @since 2022/12/30
 */
public class StampHeader {
    public static final String DEST = "./target/sandbox/stamper/stamp_header.pdf";
    public static final String SRC = "./target/sandbox/images/watermarked_images.pdf";


    /**
     * 设置字体样式
     */
    private static final String SIMSUN = "./itext7-demo/src/main/resources/fonts/simsun.ttf";

    /**
     * 自定义字体
     */
    static PdfFont simsumFont;

    static {
        try {
            simsumFont = PdfFontFactory.createFont(SIMSUN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new StampHeader().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Paragraph header = new Paragraph(new Text("我是header")
                .setFont(simsumFont)
                .setFontSize(8)
                .setFontColor(ColorConstants.GRAY))
                .setHeight(15)
                .setBorderBottom(new SolidBorder(ColorConstants.GRAY, 0.1f));

        Paragraph footer = new Paragraph(new Text("我是footer")
                .setFont(simsumFont)
                .setFontSize(8)
                .setFontColor(ColorConstants.GRAY))
                .setHeight(15)
                .setBorderBottom(new SolidBorder(ColorConstants.GRAY, 0.1f));

        for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
            Rectangle pageSize = pdfDoc.getPage(i).getPageSize();
            float x = pageSize.getWidth() / 2;
            float y = pageSize.getTop() - 20;
            float fy = pageSize.getBottom() + 20;
            // p – 要放置到页面的文本段落。默认情况下，它没有前导，并且以单行形式书写。设置宽度以写入多行文本。
            // x – 文本将围绕其对齐和旋转的点
            // y – 文本将围绕其对齐和旋转的点
            // pageNumber – 写入文本的页码
            // textAlign – 关于指定点的水平对齐方式
            // vertAlign – 关于指定点的垂直对齐
            // radAngle – 应用于文本的旋转角度，以弧度为单位
            doc.showTextAligned(header, x, y, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);

            doc.showTextAligned(footer, x, fy, i, TextAlignment.CENTER, VerticalAlignment.BOTTOM, 0);
        }

        doc.close();
    }
}
