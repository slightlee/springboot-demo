package demo;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;
import java.io.IOException;

/**
 * 为图像添加水印
 *
 * @author demain_lee
 * @since 2022/12/30
 */
public class WatermarkedImages {
    public static final String DEST = "./target/sandbox/images/watermarked_images.pdf";

    public static final String IMAGE = "./itext7-demo/src/main/resources/img/bake.jpeg";


    String watermarked_eg = "watermarked";
    String watermarked_ch = "我是中文水印";


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

        new WatermarkedImages().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

//        Image image = getWatermarkedImage(pdfDoc, new Image(ImageDataFactory.create(IMAGE)), watermarked);
        Image image = getWatermarkedImage(pdfDoc, new Image(ImageDataFactory.create(IMAGE)), watermarked_ch);
        doc.add(image);

        doc.close();
    }

    private static Image getWatermarkedImage(PdfDocument pdfDoc, Image img, String watermark) {
        float width = img.getImageScaledWidth();
        float height = img.getImageScaledHeight();
        PdfFormXObject template = new PdfFormXObject(new Rectangle(width, height));
        new Canvas(template, pdfDoc)
                .add(img)
                // 设置字体
                .setFont(simsumFont)
                // 设置字体大小
                .setFontSize(30)
                // 设置字体颜色
                .setFontColor(DeviceGray.WHITE)
                //  text – 要放置在页面上的文本   x – 文本将围绕其对齐和旋转的点   y – 文本将围绕其对齐和旋转的点
                //  textAlign – 关于指定点的水平对齐方式 angle – 应用于文本的旋转角度，以弧度为单位
                .showTextAligned(watermark, width / 2, height / 2, TextAlignment.CENTER, (float) Math.PI / 6)
                .close();
        return new Image(template);
    }
}
