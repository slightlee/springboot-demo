package itext;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.properties.AreaBreakType;

import java.io.IOException;

public class CreatePDF {

    public static void main(String[] args) throws IOException {
        String pdfName = "invoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(pdfName);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        // 设置页面大小
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Invoice invoice = new Invoice();

        document.add(invoice.titleTable());
        // 在表之间添加空格
//        document.add(new Paragraph("\n"));
        // 个人信息
        document.add(invoice.customerInfoTable());
        // xxxx
        document.add(invoice.physicalQualityTable());
        // xxxx
        document.add(invoice.psychologicalQualityTable());
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        // xxxx
        document.add(invoice.attackAttributesTable());
        // xxx
        document.add(invoice.defensiveAttributesTable());
        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
        // xxxx
        document.add(invoice.willQualityTable());
        // xxxx
        document.add(invoice.adviceTable());

        document.close();
        System.out.println("Your PDF invoice has been created!!!");
    }

}

