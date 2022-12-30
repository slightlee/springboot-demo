package demo;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.Leading;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DocumentRenderer;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;

import java.io.File;
import java.io.IOException;

/**
 * 在单元格中添加图片
 *
 * @author demain_lee
 * @since 2022/12/30
 */
public class PositionContentInCell {
    public static final String DEST = "./target/sandbox/tables/position_content_in_cell.pdf";

    public static final String IMG = "./itext7-demo/src/main/resources/img/info.png";

    /**
     * 设置字体
     * 默认字体不支持中文
     */
    private static final String SIMSUN = "./itext7-demo/src/main/resources/fonts/simsun.ttf";

    PdfFont simsumFont = PdfFontFactory.createFont(SIMSUN);

    public PositionContentInCell() throws IOException {
    }

    public enum POSITION {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new PositionContentInCell().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {

        // 1. 创建一个包含表格的文档：
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);
        Table table = new Table(UnitValue.createPercentArray(2)).useAllAvailableWidth();
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();
        Cell cell3 = new Cell();
        Cell cell4 = new Cell();

        // 2. 在该表内，使每个单元格具有特定高度：
        cell1.setHeight(50);
        cell2.setHeight(50);
        cell3.setHeight(50);
        cell4.setHeight(50);

        // 3. 每个单元格都有相同的背景图像
        // 4. 在特定位置的图像前面添加文本
        cell1.setNextRenderer(new ImageAndPositionRenderer(cell1, new Image(ImageDataFactory.create(IMG)),
                new Text("左上").setFont(simsumFont), POSITION.TOP_LEFT));
        cell2.setNextRenderer(new ImageAndPositionRenderer(cell2, new Image(ImageDataFactory.create(IMG)),
                new Text("右上").setFont(simsumFont), POSITION.TOP_RIGHT));
        cell3.setNextRenderer(new ImageAndPositionRenderer(cell3, new Image(ImageDataFactory.create(IMG)),
                new Text("左下").setFont(simsumFont), POSITION.BOTTOM_LEFT));
        cell4.setNextRenderer(new ImageAndPositionRenderer(cell4, new Image(ImageDataFactory.create(IMG)),
                new Text("右下").setFont(simsumFont), POSITION.BOTTOM_RIGHT));

        table.addCell(cell1);
        table.addCell(cell2.setFont(simsumFont));
        table.addCell(cell3);
        table.addCell(cell4);

        doc.add(table);

        doc.close();
    }


    private static class ImageAndPositionRenderer extends CellRenderer {
        private Image img;
        private Text content;
        private POSITION position;

        public ImageAndPositionRenderer(Cell modelElement, Image img, Text content, POSITION position) {
            super(modelElement);
            this.img = img;
            this.content = content;
            this.position = position;
        }

        // 如果渲染器在下一个区域溢出，iText 使用 getNextRenderer() 方法为溢出部分创建一个新的渲染器。
        // 如果 getNextRenderer() 未被覆盖，则将使用默认方法，
        // 因此将创建默认渲染器而不是自定义渲染器
        @Override
        public IRenderer getNextRenderer() {
            return new ImageAndPositionRenderer((Cell) modelElement, img, content, position);
        }

        @Override
        public void draw(DrawContext drawContext) {
            super.draw(drawContext);

            Rectangle area = getOccupiedAreaBBox();
            img.scaleToFit(area.getWidth(), area.getHeight());

            drawContext.getCanvas().addXObjectFittedIntoRectangle(img.getXObject(), new Rectangle(
                    area.getX() + (area.getWidth() - img.getImageWidth()
                            * (float) img.getProperty(Property.HORIZONTAL_SCALING)) / 2,
                    area.getY() + (area.getHeight() - img.getImageHeight()
                            * (float) img.getProperty(Property.VERTICAL_SCALING)) / 2,
                    img.getImageWidth() * (float) img.getProperty(Property.HORIZONTAL_SCALING),
                    img.getImageHeight() * (float) img.getProperty(Property.VERTICAL_SCALING)));

            drawContext.getCanvas().stroke();

            Paragraph p = new Paragraph(content);
            Leading leading = p.getDefaultProperty(Property.LEADING);

            UnitValue defaultFontSizeUV = new DocumentRenderer(new Document(drawContext.getDocument()))
                    .getPropertyAsUnitValue(Property.FONT_SIZE);

            float defaultFontSize = defaultFontSizeUV.isPointValue() ? defaultFontSizeUV.getValue() : 12f;
            float x;
            float y;
            TextAlignment alignment;
            switch (position) {
                case TOP_LEFT: {
                    x = area.getLeft() + 3;
                    y = area.getTop() - defaultFontSize * leading.getValue();
                    alignment = TextAlignment.LEFT;
                    break;
                }

                case TOP_RIGHT: {
                    x = area.getRight() - 3;
                    y = area.getTop() - defaultFontSize * leading.getValue();
                    alignment = TextAlignment.RIGHT;
                    break;
                }

                case BOTTOM_LEFT: {
                    x = area.getLeft() + 3;
                    y = area.getBottom() + 3;
                    alignment = TextAlignment.LEFT;
                    break;
                }

                case BOTTOM_RIGHT: {
                    x = area.getRight() - 3;
                    y = area.getBottom() + 3;
                    alignment = TextAlignment.RIGHT;
                    break;
                }

                default: {
                    x = 0;
                    y = 0;
                    alignment = TextAlignment.CENTER;
                }
            }

            new Canvas(drawContext.getCanvas(), area).showTextAligned(p, x, y, alignment);
        }
    }
}
