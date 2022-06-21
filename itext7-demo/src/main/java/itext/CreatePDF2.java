package itext;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.properties.AreaBreakType;

import java.io.IOException;

public class CreatePDF2 {

    public static void main(String[] args) throws IOException {
        String pdfName = "invoice2.pdf";
        PdfWriter pdfWriter = new PdfWriter(pdfName);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        // 设置页面大小
        pdfDocument.setDefaultPageSize(PageSize.A4);

        Invoice2 invoice = new Invoice2();

        document.add(invoice.titleTable());

        // xxxx
        document.add(invoice.customerInfoTable());
        // xxxx
        document.add(invoice.summaryStatisticsTable());
        // xxxx
        document.add(invoice.dailyStatisticsTable());
        // xxxxx
        document.add(invoice.summaryStatisticsTable());

        document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

        // xxxx
        document.add(invoice.actionDiagramTable());

        document.close();
        System.out.println("Your PDF invoice has been created!!!");
    }

}

