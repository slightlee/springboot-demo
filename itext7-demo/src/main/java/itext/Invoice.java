package itext;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Base64;

public class Invoice {

    float col = 280f;
    float[] headerTableColumnWidth = {col, col};
    //    float[] customerInfoTableColumnWidth = {80, 300, 100, 80};
    float[] customerInfoTableColumnWidth = {140, 140, 140, 140};

    float[] physicalQualityTableColumnWidth = {560 / 3f, 560 / 3f, 560 / 3f};

    float[] attackTableColumnWidth = {70, 35, 35, 70, 70, 35, 35, 70, 70, 70};


    public static final String IMG1 = "src/main/resources/images/test2.png";


    public Invoice() throws IOException {
    }

    /**
     * 默认字体
     */
    PdfFont defaultFont = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);

    /**
     * 设置字体样式
     */
//    private static final String SIMSUN = "src/main/resources/fonts/simsun.ttf";
//    PdfFont simsumFont = PdfFontFactory.createFont(SIMSUN);
    PdfFont simsumFont = PdfFontFactory.createFont("STSong-Light","UniGB-UCS2-H");


    /**
     * 字体大小
     */
    private static final Float FONT30 = 30f;
    private static final Float FONT25 = 25f;
    private static final Float FONT20 = 20f;
    private static final Float FONT16 = 16f;
    private static final Float FONT10 = 10f;
    private static final Float FONT8 = 8f;
    private static final Float FONT4 = 4f;

    /**
     * 线条宽度
     */
    private static final Float BORDER_WIDTH3 = 0.3f;

    /**
     * 表格高度
     */
    private static final Float TABLE_HEIGHT_FIRST = 25f;
    private static final Float TABLE_HEIGHT_SECOND = 22f;

    private static final Float TABLE_HEIGHT_25 = 25f;
    private static final Float TABLE_HEIGHT_35 = 35f;
    private static final Float TABLE_HEIGHT_44 = 44f;
    private static final Float TABLE_HEIGHT_450 = 415f;

    /**
     * 表格上边距
     */
    private static final Float TABLE_MARGIN_TOP = 15f;

    /**
     * 布局
     */
    Style topLeftRightStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3))
            .setBorderLeft(new SolidBorder(BORDER_WIDTH3))
            .setBorderRight(new SolidBorder(BORDER_WIDTH3));


    Style topStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3));


    Style topLeftStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3))
            .setBorderLeft(new SolidBorder(BORDER_WIDTH3));

    Style topRightStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3))
            .setBorderRight(new SolidBorder(BORDER_WIDTH3));

    Style topLeftBottomStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3))
            .setBorderLeft(new SolidBorder(BORDER_WIDTH3))
            .setBorderBottom(new SolidBorder(BORDER_WIDTH3));

    Style topRightBottomStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3))
            .setBorderRight(new SolidBorder(BORDER_WIDTH3))
            .setBorderBottom(new SolidBorder(BORDER_WIDTH3));

    Style topLeftRightBottomStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderTop(new SolidBorder(BORDER_WIDTH3))
            .setBorderLeft(new SolidBorder(BORDER_WIDTH3))
            .setBorderRight(new SolidBorder(BORDER_WIDTH3))
            .setBorderBottom(new SolidBorder(BORDER_WIDTH3));

    Style leftBottomStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderLeft(new SolidBorder(BORDER_WIDTH3))
            .setBorderBottom(new SolidBorder(BORDER_WIDTH3));

    Style leftRightBottomStyle = new Style()
            .setBorder(Border.NO_BORDER)
            .setBorderLeft(new SolidBorder(BORDER_WIDTH3))
            .setBorderRight(new SolidBorder(BORDER_WIDTH3))
            .setBorderBottom(new SolidBorder(BORDER_WIDTH3));


    /**
     * 标题
     */
    public Table titleTable() {

        Table headerTable = new Table(headerTableColumnWidth);
        // 背景以及字体
//        headerTable
//                .setBackgroundColor(new DeviceRgb(63, 169, 219))
//                .setFontColor(ColorConstants.WHITE);

        Style headerStyle = new Style()
                .setBorder(Border.NO_BORDER)
                .setPadding(1f);


        Text title = new Text("xxxxx报告").setFont(simsumFont);

        headerTable.addCell(new Cell(0, 2).add(new Paragraph().add(title)).setBold().addStyle(headerStyle)
                .setTextAlignment(TextAlignment.CENTER)
                // 对齐
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(20f)
                .setMarginBottom(20f)
                .setFontSize(FONT25)
        );

        return headerTable;
    }

    /**
     * xxxxx
     */
    public Table customerInfoTable() {

        Table customerInfoTable = new Table(customerInfoTableColumnWidth);

        String nameData = "张三";
        String ageData = "xx";
        String sexData = "xx";
        String nationData = "xx";

        String marriageStateData = "xx";
        String yearOfWorkingData = "xxx年";
        String workLevellData = "xxx";
        String degreeData = "xxx";

        String departmentData = "xxxx";
        String majorData = "xxxxx";

        Text cusTitle = new Text("个人信息").setFont(simsumFont);
        Text name = new Text("姓名: " + nameData).setFont(simsumFont);
        Text age = new Text("年龄: " + ageData).setFont(simsumFont);
        Text sex = new Text("性别: " + sexData).setFont(simsumFont);
        Text nation = new Text("民族: " + nationData).setFont(simsumFont);
        Text marriageState = new Text("婚姻状况: " + marriageStateData).setFont(simsumFont);
        Text yearOfWorking = new Text("xx: " + yearOfWorkingData).setFont(simsumFont);
        Text workLevell = new Text("xx: " + workLevellData).setFont(simsumFont);
        Text degree = new Text("学历: " + degreeData).setFont(simsumFont);
        Text department = new Text("所属单位: " + departmentData).setFont(simsumFont);
        Text major = new Text("专业: " + majorData).setFont(simsumFont);


        customerInfoTable.addCell(new Cell(0, 4).setHeight(TABLE_HEIGHT_FIRST).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(cusTitle).setBold().setFontSize(FONT16)).addStyle(topLeftRightStyle)).setMarginTop(TABLE_MARGIN_TOP);

        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(name)).addStyle(topLeftStyle)).setFontSize(FONT10);
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(age)).addStyle(topStyle));
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(sex)).addStyle(topStyle));
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(nation)).addStyle(topRightStyle));
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(marriageState)).addStyle(topLeftStyle));
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(yearOfWorking)).addStyle(topStyle));
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(workLevell)).addStyle(topStyle));
        customerInfoTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(degree)).addStyle(topRightStyle));
        customerInfoTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(department)).addStyle(topLeftBottomStyle));
        customerInfoTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(major)).addStyle(topRightBottomStyle));

        return customerInfoTable;
    }

    /**
     * xxxxxxx
     */
    public Table physicalQualityTable() {

        Table physicalQualityTable = new Table(physicalQualityTableColumnWidth);

        String bmiData = "23";
        String longRunTimeData = "xxx";
        String shortRunTimeData = "10分";
        String pullUpData = "xxx";
        String fiveTotalTimeData = "10分20秒";


        Text phyTitle = new Text("xxxxxxxx").setFont(simsumFont);
        Text bmi = new Text("xxxx: " + bmiData).setFont(simsumFont);
        Text longRunTime = new Text("xxx: " + longRunTimeData).setFont(simsumFont);
        Text shortRunTime = new Text("xxx: " + shortRunTimeData).setFont(simsumFont);
        Text pullUp = new Text("xxxxxxx: " + pullUpData).setFont(simsumFont);
        Text fiveTotalTime = new Text("xxxx: " + fiveTotalTimeData).setFont(simsumFont);


        physicalQualityTable.addCell(new Cell(0, 3).setHeight(TABLE_HEIGHT_FIRST).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(phyTitle).setBold().setFontSize(FONT16)).addStyle(topLeftRightStyle)).setMarginTop(TABLE_MARGIN_TOP);

        physicalQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(bmi)).addStyle(topLeftStyle)).setFontSize(FONT10);
        physicalQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(longRunTime)).addStyle(topStyle));
        physicalQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(shortRunTime)).addStyle(topRightStyle));


        physicalQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(pullUp)).addStyle(topLeftBottomStyle));
        physicalQualityTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_SECOND).setVerticalAlignment(VerticalAlignment.MIDDLE).add(new Paragraph().add(fiveTotalTime)).addStyle(topRightBottomStyle));

        return physicalQualityTable;
    }


    /**
     * xxxxxx
     */
    public Table psychologicalQualityTable() throws MalformedURLException {

        Table psychologicalQualityTable = new Table(customerInfoTableColumnWidth);

        String bmiData = "23";

        Text phyTitle = new Text("xxxxx").setFont(simsumFont);

        psychologicalQualityTable.addCell(new Cell(0, 4).setHeight(TABLE_HEIGHT_FIRST).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(phyTitle).setBold().setFontSize(FONT16)).addStyle(topLeftRightStyle)).setMarginTop(TABLE_MARGIN_TOP);
        Cell cell = new Cell(0, 4);
        // In the snippet after this autoscaling is not needed
        // Notice that we do not need to create new Image instances since the images had been already flushed
//        Image image = new Image(ImageDataFactory.create(IMG1));

        String imgUrl = "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6DrQ4lXQ4mNvCCWPyyHB5WSvBxGlHwYQIqLDCCk6mlrSd/NCSk2yRUCuS4ZsYfIgovTEAEJEdBQenwq3N3P2DaHkEAQg22lBloP7ehBRemMAISJqA03T4faqnKROceG0S8h2ShBF9noQUfpjACEiikBI0dHsURAMZd4GhhR7VllETpaFw62IKKMwgBARGeAPamj2cLUsMkaSBORkWWC3cnUrIso8DCBERAbpAHx+FS1eFarGUykdnSQKcDklOOwS2OdBRJmKAYSIKEq6Dnj9Klp8KjQGEWqFKApwOSQ47RKX1SWijMcAQkQUIwwidCgGDyKin2MAISKKsQNBxOPj0KxMJYkCshg8iIhaxQBCRBRHvoAGj0/hZoYZQrYIyHJY4LBxcjkR0eEwgBARJUAgpMHjUxEIcvnedGSzinA5JFhlBg8ioqNhACEiSiBF1eH1q/D5VXB0lrmJAuCwh4dZWSSOsyIiaisGECKiJND18F4iXr/KTQ1NxiqLcNol2K0i53cQERnAAEJElGSKqsPnV+ENaFw9K0WJogCnTYSDvR1ERFFjACEiSiHBkAZfQIM/yDCSbKIowG4V4bCJnNtBRBRDDCBERCkqENLgD2jwBzhfJFFEAbDbJNhtImwMHUREccEAQkSU4nQAwaCGQEhDIKhBUXnajiWLJMBmDQcOq1UEB1gREcUXAwgRkcmoqg7//jASDGngWTwyghCeSG6zirDLIiTO6SAiSigGECIiE9N1IKiEg0gwpCOkMJAcShAA2SLCKguwyiKsFq5eRUSUTAwgRERpJqTo4UCiaAiFdKgZNoFEEgXIsgCrJTx5XLYwbRARpRIGECKiNKdpOkKqDkXRoajhXhJF1U3fUyII4fkbskWERRJgsQiQJQGiyMBBRJTKGECIiDKUooYDiaqGe0kOPKZSODkQMiRRgHTQo2X/BxERmQ8DCBER/Yymhye7a5oOTdehafjZo66Hg4oOAPsfD7ylHHhnOTDXQhCE8OpSAiDs/7ogCBBFQGz1MRw02JlBRJR+GECIiIiIiChhuMsSERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElDAMIERERERElzP8DiNV0at2TUPcAAAAASUVORK5CYII=";
        byte[] strToBytes2 = getStrToBytes(imgUrl);
        Image image = new Image(ImageDataFactory.create(strToBytes2));
        image.setAutoScale(true);
//        image.setHeight(300).setWidth(600).setMarginLeft(-30);
        cell.add(image);

        psychologicalQualityTable.addCell(cell.setHeight(TABLE_HEIGHT_450).setVerticalAlignment(VerticalAlignment.MIDDLE).addStyle(topLeftRightBottomStyle)).setFontSize(FONT10);

        return psychologicalQualityTable;
    }


    /**
     * xxxxxxx
     */
    public Table attackAttributesTable() {

        Table attackAttributesTable = new Table(attackTableColumnWidth);


        Text attTitle = new Text("xxxxx").setFont(simsumFont);
        Text attDes = new Text("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").setFont(simsumFont);


        Text attTableTitle1 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle2 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle3 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle4 = new Text("xxxxx").setFont(simsumFont);
        Text attTableTitle5 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle6 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle7 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle8 = new Text("xxxxx").setFont(simsumFont);
        Text attTableTitle9 = new Text("xxxxx").setFont(simsumFont);
        Text attTableTitle10 = new Text("xxxxx").setFont(simsumFont);


        Text attTableValue1 = new Text("xxxx").setFont(simsumFont);
        Text attTableValue2 = new Text("xxxxxx").setFont(simsumFont);
        Text attTableValue3 = new Text("xxxx").setFont(simsumFont);
        Text attTableValue4 = new Text("xxxxx").setFont(simsumFont);
        Text attTableValue5 = new Text("xxx").setFont(simsumFont);
        Text attTableValue6 = new Text("7").setFont(simsumFont);
        Text attTableValue7 = new Text("1").setFont(simsumFont);
        Text attTableValue8 = new Text("~3.5(含)").setFont(simsumFont);
        Text attTableValue9 = new Text("5.5~6.5(含)").setFont(simsumFont);
        Text attTableValue10 = new Text("6.5(含)").setFont(simsumFont);


        attackAttributesTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(attTitle).setBold().setFontSize(FONT16)).addStyle(topLeftStyle)).setMarginTop(TABLE_MARGIN_TOP);

        attackAttributesTable.addCell(new Cell(0, 8).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.BOTTOM)
                .add(new Paragraph().add(attDes)).addStyle(topRightStyle)).setMarginTop(TABLE_MARGIN_TOP).setFontSize(FONT4);


        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle1).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle2).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle3).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle4).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle5).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle6).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle7).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle8).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle9).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle10).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftRightBottomStyle)).setFontSize(FONT10);


        for (int i = 0; i < 4; i++) {

            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue1)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue2)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue3)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue4)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue5)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue6)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue7)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue8)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue9)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            attackAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue10)).setTextAlignment(TextAlignment.CENTER).addStyle(leftRightBottomStyle)).setFontSize(FONT10);

        }


        return attackAttributesTable;
    }


    /**
     * xxxxx
     */
    public Table defensiveAttributesTable() {

        Table defensiveAttributesTable = new Table(attackTableColumnWidth);


        Text attTitle = new Text("xxxx").setFont(simsumFont);
        Text attDes = new Text("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").setFont(simsumFont);

        Text attTableTitle1 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle2 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle3 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle4 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle5 = new Text("xxxxx").setFont(simsumFont);
        Text attTableTitle6 = new Text("xxxxx").setFont(simsumFont);
        Text attTableTitle7 = new Text("xx差").setFont(simsumFont);
        Text attTableTitle8 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle9 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle10 = new Text("xxxxx").setFont(simsumFont);


        Text attTableValue1 = new Text("xxxx").setFont(simsumFont);
        Text attTableValue2 = new Text("5.6").setFont(simsumFont);
        Text attTableValue3 = new Text("xxxx").setFont(simsumFont);
        Text attTableValue4 = new Text("xxxxxxxxx").setFont(simsumFont);
        Text attTableValue5 = new Text("xxx").setFont(simsumFont);
        Text attTableValue6 = new Text("7").setFont(simsumFont);
        Text attTableValue7 = new Text("1").setFont(simsumFont);
        Text attTableValue8 = new Text("~3.5(含)").setFont(simsumFont);
        Text attTableValue9 = new Text("5.5~6.5(含)").setFont(simsumFont);
        Text attTableValue10 = new Text("6.5(含)").setFont(simsumFont);


        defensiveAttributesTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(attTitle).setBold().setFontSize(FONT16)).addStyle(topLeftStyle)).setMarginTop(TABLE_MARGIN_TOP);

        defensiveAttributesTable.addCell(new Cell(0, 8).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.BOTTOM)
                .add(new Paragraph().add(attDes)).addStyle(topRightStyle)).setMarginTop(TABLE_MARGIN_TOP).setFontSize(FONT4);


        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle1).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle2).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle3).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle4).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle5).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle6).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle7).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle8).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle9).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle10).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftRightBottomStyle)).setFontSize(FONT10);


        for (int i = 0; i < 4; i++) {

            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue1)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue2)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue3)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue4)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue5)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue6)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue7)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue8)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue9)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            defensiveAttributesTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue10)).setTextAlignment(TextAlignment.CENTER).addStyle(leftRightBottomStyle)).setFontSize(FONT10);

        }


        return defensiveAttributesTable;
    }


    /**
     * xxxxxxx
     */
    public Table willQualityTable() {

        Table willQualityTable = new Table(attackTableColumnWidth);

        Text attTitle = new Text("xxxxxx").setFont(simsumFont);
        Text attDes = new Text("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").setFont(simsumFont);

        Text attTableTitle1 = new Text("xx").setFont(simsumFont);
        Text attTableTitle2 = new Text("xx").setFont(simsumFont);
        Text attTableTitle3 = new Text("xx").setFont(simsumFont);
        Text attTableTitle4 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle5 = new Text("xxxx").setFont(simsumFont);
        Text attTableTitle6 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle7 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle8 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle9 = new Text("xxx").setFont(simsumFont);
        Text attTableTitle10 = new Text("xxx").setFont(simsumFont);


        Text attTableValue1 = new Text("xxxx").setFont(simsumFont);
        Text attTableValue2 = new Text("5.6").setFont(simsumFont);
        Text attTableValue3 = new Text("xxx").setFont(simsumFont);
        Text attTableValue4 = new Text("xxxxxxx").setFont(simsumFont);
        Text attTableValue5 = new Text("xxx").setFont(simsumFont);
        Text attTableValue6 = new Text("7").setFont(simsumFont);
        Text attTableValue7 = new Text("1").setFont(simsumFont);
        Text attTableValue8 = new Text("~3.5(含)").setFont(simsumFont);
        Text attTableValue9 = new Text("5.5~6.5(含)").setFont(simsumFont);
        Text attTableValue10 = new Text("6.5(含)").setFont(simsumFont);


        willQualityTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(attTitle).setBold().setFontSize(FONT16)).addStyle(topLeftStyle)).setMarginTop(TABLE_MARGIN_TOP);

        willQualityTable.addCell(new Cell(0, 8).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.BOTTOM)
                .add(new Paragraph().add(attDes)).addStyle(topRightStyle)).setMarginTop(TABLE_MARGIN_TOP).setFontSize(FONT4);


        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle1).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle2).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle3).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle4).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle5).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle6).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle7).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle8).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle9).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftBottomStyle)).setFontSize(FONT10);
        willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_25).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().add(attTableTitle10).setBold()).setTextAlignment(TextAlignment.CENTER).addStyle(topLeftRightBottomStyle)).setFontSize(FONT10);


        for (int i = 0; i < 6; i++) {

            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue1)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue2)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue3)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue4)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue5)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue6)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue7)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue8)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue9)).setTextAlignment(TextAlignment.CENTER).addStyle(leftBottomStyle)).setFontSize(FONT10);
            willQualityTable.addCell(new Cell().setHeight(TABLE_HEIGHT_44).setVerticalAlignment(VerticalAlignment.MIDDLE)
                    .add(new Paragraph().add(attTableValue10)).setTextAlignment(TextAlignment.CENTER).addStyle(leftRightBottomStyle)).setFontSize(FONT10);

        }

        return willQualityTable;
    }

    // xx建议
    public Table adviceTable() {

        Table willQualityTable = new Table(headerTableColumnWidth);

        Text attTitle = new Text("xxxxxx").setFont(simsumFont);

        String attContent = "1、xx建议xx建你好议xx建议xx建议xx建议优秀xx建议xx建议xx建议xx建议xx建议xx建议xx建xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议999999";
        String attContent2 = "2、xx建议xx建议xx建议xx建议xx建议xx建议xx建你好议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议999999";
        String attContent3 = "3、xx建议xx建议xx建议xx建议xx建议xx建议xx建你好议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议999999";


        willQualityTable.addCell(new Cell(0, 2).setHeight(TABLE_HEIGHT_35).setVerticalAlignment(VerticalAlignment.MIDDLE)
                .add(new Paragraph().setMarginLeft(5).add(attTitle).setBold().setFontSize(FONT20)).addStyle(topLeftStyle)).setMarginTop(TABLE_MARGIN_TOP);


        willQualityTable.addCell(new Cell(0, 2).setVerticalAlignment(VerticalAlignment.BOTTOM)
                .add(new Paragraph().setFirstLineIndent(20).add(returnCorrectColor(attContent)))
                .add(new Paragraph().setFirstLineIndent(20).add(returnCorrectColor(attContent2)))
                .add(new Paragraph().setFirstLineIndent(20).add(returnCorrectColor(attContent3)))
                .add(new Paragraph().setFirstLineIndent(20).add(returnCorrectColor("你好")))


                .addStyle(topLeftRightBottomStyle)).setMarginTop(TABLE_MARGIN_TOP).setFontSize(FONT10);



        return willQualityTable;
    }

    private Text returnCorrectColor(String letter) {
        if ("有点好".equals(letter)){
            return new Text("有点好").setFontColor(ColorConstants.YELLOW).setFont(simsumFont);
        } else if ("不好".equals(letter)){
            return new Text("不好").setFontColor(ColorConstants.GREEN).setFont(simsumFont);
        } else if ("你好".equals(letter)) {
            return new Text("你好")
                    .setFontColor(ColorConstants.RED).setFont(simsumFont);
        }else {
            return new Text(letter)
                    .setFontColor(ColorConstants.BLACK)
                    .setFont(simsumFont);
        }
    }



    // base64图片解码
    public static byte[] getStrToBytes(String imgStr) {
        // 图像数据为空
        if (imgStr == null)
        {
            return null;
        }
//        <= jdk1.8
//        BASE64Decoder decoder = new BASE64Decoder();
//        > jdk1.8
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
//            byte[] bytes = decoder.decodeBuffer(imgStr);
            byte[] bytes = decoder.decode(imgStr);
            for (int i = 0; i < bytes.length; ++i) {
                // 调整异常数据
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            return bytes;
        } catch (Exception e) {
            return null;
        }
    }
}
