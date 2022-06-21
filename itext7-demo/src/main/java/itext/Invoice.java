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
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.net.MalformedURLException;

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
        String sexData = "男";
        String nationData = "汉";

        String marriageStateData = "xx";
        String yearOfWorkingData = "xxx年";
        String workLevellData = "xxx";
        String degreeData = "研究生";

        String departmentData = "部门1111";
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
        String longRunTimeData = "10分20秒";
        String shortRunTimeData = "10分20秒";
        String pullUpData = "50个";
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

        String imgUrl = "iVBORw0KGgoAAAANSUhEUgAAAyAAAAGQCAMAAABh+/QGAAACdlBMVEX////9/PbZ2ty1tbWlpqmtra28vLzDw8TNzMzR0dHj4+Pr6+v19fX2+P3y9fvt8frp7vmrrbNdYm5OVWhNWXhOXIhSWmxOU1hNTlNLTEpTVVtqbXV/goacnaLm6/iHiIZTXHZUcMZSarRPZKJSYpVGRkZRXYNRZ6hPYZlOX5FRUlF2dnW5vcRTbbxRZJ14e4JVWmOOjo7O0t1HSEfl6fZPYY6PkJBkY2Pd4u5UYYhUb8FOUk18pmiJvXCRzHWPyXSHum+EtGx1m2RylGJti15idFpbZlVLSkdVWFeMw3KBrmtqg11fcVdSWk5UWlPW2ubi5vNlfFq0tru+wst5enlaVktUUktcW05jY1NmaVZmdVhuimJ5m2V1cmuUglijiU/KplTcslXUrFS7m1O0lVGpjlGagk+Tfk6GdU53ak1sY0x/cE1kYl3EoVP6yFjqvVbNqFTBnlJcXFyampmtklVRTkfYr1TmuVa3mFPitlaRflR8c1hRT0nvwFd6dm5ngFqkpKR0a1WbhVSHeFfzw1d3bVj2xlmWlpWBfnhvb21cWVV3eHdhW0yki1OFgn1hXlewr62KhXyCpGlpamaeoqZyg16PgF20weaCltVshc5cdsmLntmsuuNjfcucrN7L1O5deMm9wtLS2fCusrmFmdZwiM+8x+l3iW7CyM5qcmny+e/P6cOu2pqi1IuWz3zu9+m13aHu9+rK5ryc0YO94Kze8NXU68nh8drB4rOn1pH0+fHSzL/10X/70HL6y2L6z3D714W+qHainpf+9+X82Y384aX7zmzOsG7x6tr97s395rTit1n+8NP++ez83pv96b7JzNPf5PAGOoQjAAAja0lEQVR42u2djX8T1ZrHE9pC3xKCYGVAUooUpK1ICRfQlvBS2vJmEaHhTV76AhQsAVqgpXi1tNBiFbjeehVEkZXd6wsvouL17gssu6B3ZRHd/2hnJmk758wknTNzJjNJft/PvTSMaeZkmN88z++c55zjcgEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOAY3GMyMrMyxo7LzhmTm5fvsbs5ANiOx+Pxer3jx/tEJjw1cdLTkyZNKpg4ceIzkycLT02Z+uy0sTl5drcRgMQj6mK8z6+kcHoRxYznZj49aeLkYlEoWdnQCUgPPLQyIjw7qygWM2Y/P6dgcknptOx8uxsPgIXE0IZEWUHRKLww9+mJk6e8mJlj97cAwAJEcfjjMHX2aAKJBJPnZxXMm5qVa/e3AYAn8cUhIbygSyAyz016Zkp5tt3fCQAueLy+0dTh989/Sr8+5EgyZ2JgagaMO0hyPN7RxSGxIMAmEIm5k54pzYRtB0mLrtgRZZ4+D0IHklmTS8fZ/TUBMAKDOkSm/cGIQCRDUiAsHGP3dwWADc+orpxPCJF4Yc68RVlItUDyoNN4ECyeN9eoQoqKZk8XyhFGQFLAHjyiPn3qS0/PfW72jJeNaWTuxKno+QWOx8PkPMgYUlohVAiB4oBQUVFRUjJl4sRJM2cwuZFFMOzA0bAZc5IyoXJJUGLpkmXLKytXVK1cWV0j1Fasmjdpjk6dzJ4+b6zdlwCAWJiRh7+sOqjF6jUr1q57pVgomThLj4ufMX1Klt2XAQAtTMnDv1gIxmNZZdXaCuGZSc+P3qc1XZhg96UAgMaE95AprAyOypIV1RUVqyaNFklefmkKvAhwFGbl4ffXLRldIHIoqaoWKqY8Hb+0cUbBVNT7AsdgtGNXwfoKffqQWV5V80rJpLgaeW5KodvuywKAjNe0PBgFIlG5LrDq6XgSmRnItPvCAMBHHlKKtYxRIcGlK2qEuKPvs2BFgN2YNx9R9Jh0tWtf+UpFQexUa8b0Z1GiBeyEU/gQeVUwIBDJj2wIPBM71ZotvGb3JQLpC7fwIbGx2phCRDtSXTEppkSmb7L7KoF0hV/4iChEqGT2IUNhZF1sicwthhMBNsA1fESyrNL6UChUv3nL1q3bqjes3f46g16WVwsx1w2a/qLd1wqkH5zDh6SPHTt37W5o3N3UvGfX3n0t+w+8UVtbv6V6pU73vmSDUBCjUn6mgEJ4kFi4hw//4taDYZpDh5v37q8PhDbXbNAhk9UbAhO1FfJyQaHdFwykEx7u8vD7WxvCsWg4smdffe3mbaOKZOnaQAwvMrMNHb4gUfBPr/z+9qPh+Bxqaqk/tmXD8lE0slaYoz0mgjQLJAj+6ZUUQI6HR6ejsyUUqlkbVyHLalZpT68qQOkJSAD8e68kFgR06EPmRHNXYPPKeBJZEdDu0JqF3ixgOVakVyLzT+oViETngWNb4xmSDRUvaQ6JTIERAdZivrA9Bm/+kUUh4Y499fXbYo+TLK9bBSMCEo8l6ZXMW4eZBCJyfF9t/dsxJVJVrNmfVdBt9yUEKYx1+vCXnWIViMjBN2pjV3BVawaRlzAiAizCitGPEQp7DCgkfGhf7bZYCllTrFXmOxPVi8ASrNWH37+w14hCwqf3BrYujSGRmilaVn2q3VcSpCJei/Xh9084c6Br19HOI7sbGzoO9emXSN+uwNbV2grZXqGxBMrsRXZfS5B6WKYP33iv1+vxeKSTjMlo7y88W/rOooGS2sCpU117dp/Qp5FdtTXaXVqVgekaCpli99UEqYYV+hjvjchCG3deTkb/u23ClpM9TQ2jS+ToezX606wZk+2+niC14K0Pn9ej88zuMeMyC3eEeptHFcm5Wu3x9ZUV6ir4F4oxZAj4wVUf43WLY4T8cQtbB3o7O+L3aO3frFnKuCagsXuVAIUAXvDTh/7IoSZvbPnAQM/ueBI5eEy7z7dGozirAAoBfOClDzPqiJI39q1QT7xka++xKs3iLA0jIphuDQAuXvrgoI4IeZmtW48eiqmQjgObtVb53a4eVn9ZsPvKglSAiz7Gc31aj+kPnWmKKZGmYxs0FLKiQt2Xhd5eYBoO+vB5+Tcr+/yFntOxJNKi1eNbqVYIRgyBWczXl/isSvW7hZ2xMq3mN9eoFbJcUC1S+hyqToApTOuDb25FkVXSG6PjtyOkkWYtCajm4s581u4rDJIap0aPITIGemP0abVs0UizBNVi8C8ttPsSgyTG3PwPy+UhMbb1pLZEOo9ppFkVM1UKwVIOwCim9JEQeUiMO9ulP82qUVX3FmDpXmAMU/PPLei5ismfBO1O35ataoW8osqyJufZfaFBUuI1IY/xiW2q5/1TmnlW02YNH0LHEAyHACOY6MBKWHY1Qs4FzRm7B+vVCgnQvb1zsV4WYMe4AUlkdjVCd+iIhkKOv6nu7RVg1IFpDOvDhvARIV/TrHcEVFMNl6vG1Aty7L7cIMkwbEDsCR8RsoVGtUL6jv1ZVXVSQiskgE3VAQtGDYht4SPa7MFzGkGkXlUBv4Ku7Z09z+4rDpIKg/pIcOeVBu1a688dUK0Hv30eXXOC9eSAfgwaEDvTqyGyAxprmO5XZVkb6DmG0zFeCPRizIDYnF4N845GmrVfFUNq6HnqxXa3GyQLxgyI/enVEO1nNLIslQ8JUGudzMWSpEAfhhIsJ6RXQ+SENJw6nWWtoTt7p5fZ3W6QFBhKsJykD5crr1g9leoYPR6ych6SLMCOoQTLWfoQqVPVZvUFVDbkJSRZgBkjCZZD7LmSVtUCWh3HVDZkBpIswIiRBMuB+nC53lKVwB+nKxcrX0GSBdgwkGA5pXuX5n1Vd6+qtnflFCRZgAn2BMtnd5Nj0n9UNT+EnkFVQ+1B9RKGC0E82BMsn91NjkO5SiEt9CzcYlIgL2BfBBCPlNKHGENUWVaIWslhDVW2OOsDu9sMHAx7AHGo/xjiPO3UT4SoEFJN7RaNbRFATNgdusP14XLtoHt7O6n1spYGUNYLdMK8jInj9eFytdIjhi1/IRVSRfVkTcm1u8nAoTAHEMeNn2tRd2gUG1I3hxAI1usFMWDt4k0KfbhcxbQNoUbU6SnqBdl2txg4EtYAkiT6cOXRtb3N1GpZ1OSpGW12txg4EsYA4pz5H6ORQ88PoUdDqJqs6Rl2txg4EC+bPnx2t5eBdno4RFhNCIRaw+FlLLUI1DAGkCTowBphkFoOiF6StIb06bOwkBygYQwgyWJAIrhrqRBCzcClfDoKToAKtgCSPAYkQjZlQ+gB9bWT4EJAPNgCiM/u5jJD25CebZRPR0cWiAdbAEkqAxKBtiHUFPW3J5IhBGXvQAnbGEhyGZDoNxSoyVOkT19dS6wCNHvQ7vYCR8EUQHx2t9YQ2R+SCtm/khwtJEPIPKz3DkZgCyBJmGBJnCX3DzlUSwiE2jVk7rt2Nxc4CKYy3mRMsCTyqZKTHnL+LVVwgqJeMELqJ1gS3dQube8RPn0ZORaCeSFgGG8aJFgSAycIgeypiTe38ClMLQRRWPSRbEOESnKozUNqiZIsajgd9SYgCpNFt7uxpnifnKJ+jnQh62YRg4Xz7G4tcAgsFj1ZHXoEejCkOF5F1rwxdjcXOIO0cOgR/kRuhLuXCiHEMnJz+u1uLXAELBY9iR16hLPEGg7Uiu+Vz6CmF6hgGEX32d1W04zrJUMIWbNITi3E5HTgYrPoSR9AXK4LRAg5TQ6nk4OFz79od2OBA2DIsHw8z5tVLLJJ47BgaRnUWDKE7KtWCoTalk1IgQcCMAtDhsX1fslalO9yly6ihuNyV+VovpMfAx1ERZZAhJCKuZg3BQgYMiy+Y4Tyba/SQ3ZJnvY7uZFBdmTtf1spEHLfQhS9A5YMi2/CMSIQMdkSZZHfltVW0i2mXeLxyJHofynVTMWMU0IstUjOC1lG1vQ+hYrFtMe2LixZIFLAkF5kleTlt0makCNI9Ij8//wszhHElbWTrDdZQqxv8jT6sYAChgyLs2OVbvv8tn5X/iIxiOS3ZUivIwIZOZIx/E6eCKcJm0709JJLWf8hK0H/DMCp6M+wfJzPLPdiiZrILpaJykESyNCRIT/CWyBk2XsjsXHh0oBy6m0Btr1Nd/T3YfGrwvJ9dPHSx0VMfHzp4kc+Xuf3bCFyrPpKotxEWfQ+eb0d/ybAQejPsHidccFlNm2McHkBpyaQ+07tIgqyKhVDITOmJnfxMjCN/gyLVx/vJ0VFn175TDQ0w4lTuWQ7NuWPpFhDR+Sfud3SMY//syufFhV9wqcN404qBdJBbodQ84dhgTwzP8mrl4FZ9Fe687HonstFVz+JfNSIsyiPdvMOCyR6RP4pDyfK3byeT64WXebTjBDR00uuQ1q96LloseLEf0ru+WHAPIm26JeLLpnIkxZcKrrMpRnkDuqdxFBIVXnhlDnPzXh+llDGM7MEyYj+Tl4+qcYnRZdMfZD3Ep8sa8zW2EXvy2v88xdOnfpiJs/ICZIT/RaEy32yoOiqySfygqtFXJw6ubVny1qiHmu9NZ13IPnQbUF8XE53Wev5f1FM969ILz4feuFyfXTV57pyUesjPuGTZGUSQyFHieVNqq9Z0TkBkpHEZli+ok/VgeiibIivRPQxIpUrnw+rhcDzaZGPQ1Py6pUCaSA2Q6h6lvjqVl5/4Gz0WxAuGdZHWrf8P3/ucl0p+hePqJQr4jvE0CHqQ/pTPqDmStFHPNqyY7dSIceWKwsWV/H/6iAp0W1BfFxOd7HoM+3/IOliwVVRFZ5LH38ekYvElSKNLOuzoosuDowlcqwWouY9BBMCZHRbED43yaWiGPnKRfGm/1yWxcWiv15RDp6rxeAvusSjLbkDSoE0byFMyASYECChuxCLT5rxcZH251wsEuPGsEDEA55LUo71kbYJKfqYS2OIiYXkjmwrvuAfPUEyotuC8DmdtkAWXJX0QQhETrcsFkhhpzKEhNbENiEWXXzgeHR7dE5ZhmaKJerjYuTnkAcZEssVTYFwSrGoxRtaNihDSB1hQuDS0xXdHp2TT9U06UN9VZ5Lci+W7M8j0tAWCCeT7sojTAi5cfr2axZ8e5B06PbonJ6hWjmTGEAkxOjxkfxCyrA+H5LJXzU+hFM3r8t1QbkXAlnRu3IhBAIYPDqv82kMFEaGB4sinmNIH/IwiOuinG5RcBooFClvjjlrqrIULh3o9+g+Xie8rKfU8HM5h7qo2cfLrdTERZuQLqUJWd4Glw70C4RbjrGg6KrJUkNexYoiecSWhbuIcqwABAL0d2Lx68ZxSrm7zA5lRe8RwqXXzbfm+4NkwptgCyLhkAlTMoXKmelkveK6Mrh0YIdAFFNu2X+X35RbGWL1H3LS1Np2CATo7eXlW4w0vGgDE3wXbYhAbhVCdGNVfWHdBQDJgt5eXs4PUAcs+xNhDLE81v6Vyn7eQeUF8CXu3wQ4iMR79Ch2LxwXhdzRk1iBdHWFVTkmSB5sE4hTIAp6yYp3YTEEku7o7uW1u6GWUaqcVXiYWKK35su0eESAOEAgxOpYHcRuhRsmQCDpjl6B+OxuqGWQe03VrlaWK06DQNIdr06BpG4nZ/YZohvrddTzAgV6BZK6d0ceIRBihd6qwvS4BCA2EEg+0c9LDISQ09JT9xKA2OgdSE/huyPQF2vWLTkjJHWzTBAbvQJJYYdK7IJAjBRWfgWBpDt6K01SWCDESOFepUDWLFJeAp/dDQU2AIGQa7wTO7GRcwp9djcU2IBegdjdTgsZbFQIZI9SIEvqIJB0xxkCkbZ8jrPLM+8doEmIWhOiGIusVvRZew2AI3GCQNyl0laEue/EVIG1Ajl7JNbSWEsDEEi6o1Mflgpk1PvfWoEQy48eJGalC6+mSZoJYuEAgUQ2to2QJeZam4gX5eJPawVCVCuS5bzkPmwWtgE4FQcIJLLns4y8NXrbJupFdrGlAmnfpRDIcWLZhjoIJN1xikCypD3RhzdJp16U2yaQ+RBImuMUgcg/Iq/yF+VQL2xLsUoQQdId+wTy9fUbN28Fmbh188b1r7k3hDTp8CBAiV3dvN/cZtPGCLe/5dyU2N285KR0X2L+RYCjsEkg3wWD39/54Vu3/BfZjcuZVsSb97uGX7hLxewqa8iku7/94c73weB3fNtCDhQSAgm8CoGkObYIxH07eOs7t+JAeXFxsZDjivTu9rsUL9ylVDev+7tbwdtutvPFhyw1IZY1wUBh2mNLseLt4E0TedK3N4O3ebaGLFZUCmSpAIGkO3YI5LvgTVMhwH2Ta5ZFlrsrixVRiwVsmDD1TfCWSZ/97a0gR6dOTphapxQIJkylPTZMub2t/fz/5lbwb+KPH8Ub8++RI9dvfe26c0Prvd/xTLICyjnpxJTb5YsgkHTHm3CBfB38XjPBuhOUBPKjfGfKChFf/v3HYbUQuL8PchsPoRZtWKsQSOU7Fj0jQNKQeIFcD97ROiwpQxTIDVEQ14Ni6BAPSH/KB9TcCV7n1Z44y/6seBYCSXf0CoRffnEj+IPGUff3N/9VFMg3t0RVuL+/9aMogaiTvxPUyLJ+CN5wcYJaOE65QQgWjgOJX3r0pqbBvnPrxxuiQH6UZSG+uqMcjlCL4dvgTV7toZYeXaI479oPLOqnAElD4hevvhXUsCDXxUSKEIhLCipSjnVd24QEb/FqD7l4taAUZvU1CCTdcYZAfpSCBC0QOd2yXiBxtj9YtxECSXv0CoTb7aGVYt2I3pE3RzyIKyqWO5oC4ZhikRvoEKVYg5gOAhIuEC2TPiyQf/te7sWS/XlEGtoC4WfSyV7efcqBdExJBzZs4hmjmzeaWF2X78zIiGFUJn/TeC+/bl5qE8+3FfpYssqabgqQTCR8G+hYA4VR53F9WB/yMIjrhpxuUXAcKKS2gVZuD0KOE2IgPT3xJtyl39ZTaijbdjn10sqlOJaadPco9NEXUG4wVVVuSQgFSUXiBeKsYsXCJoVAGoglGzZkQiBAdz8vv15OR5W771DOBiEn3K4rs+b7g6RCr0C41vM6ZsJUXkhpQc7VKAWCNU2AS79AfPxOqZpyy/K7fKfcjiU8+j5lsfvSEmtSTJBc6O3n5XqHEIs26MaCRRvKm4lOLGWp4ppBi54PIKnQ28/LNwn/1iHL/rSdiFmJVYVaXuBi6MbifIs4YuG4vAFlAOkkPDpZqgiBpCu6u7FScaSMtCAt1UqBkCtXoxMrbdErkFS0qcSyo+H6FQp9rIZHBzK6XXoKPkSJUt4Tx5QBhNwk3Wd3S4Ft6HbpqZeG515QBhBif8Lg2mmpnl8Cfeh26T67W8qdsT2EBdlAePSNqf1wAHrR7dJTL8facVgpkGPLlAIpTu2vDvSjWyCp9hjNq1fqg6xUJGvd4dHTGd0mxGd3SzmTSWRYR4nZhOSKJrAg6YxuE5JqicaFBsKCKDt5qe0JUy12Ahb0m5DUuk/GbFXqoy+g1Ac53TbVngyADd0C8dndUq4QK2JRnbxVhbAgYAjdJiS1nqTCaaVADhAZVvVrsCBgCP0mhMudMrzPmgHKjf6imnEnlfroIIbRgzXK7TtTLLUEzOgWCIdcw10q7X2elWHstzkKhNjdNnyO6MNCJy9Qorsci8OzVLkjJzv8BOIhFsQiF/wJbpiQutYLsKM/x/KZPVV+23DskFKtTVJI6S8tLs7ILSkWQwvxl+G3iLooL5Y3gxYFUi79NCczCWK9n3AjsSgvtaYiMqx0R39Hr2mbni3f+BKRvdA3iZoQckQllOS5S6m/DL/FVV6cEd1Avd+VLb5D1JHZ70xa9H3EVBCykje1uiaAEfQLxGfyTMMCiYSS7KgUcksy1H8ZfourXAojUtQQBSIdzW3LM9EGiaydRIZVu5rowyImE8KCAP05ltnH6bBAIi/yF+XI0UDWgiwQxV+G3xKxHlGBuLI2Sf8zSeiPSn0cJCbbUoWKyLAAQ45lsqc3d1VO5MW/9/zH3XthJk7/5/3/+m/xI9pySw12gg2T8SHxyfuVWxMGX9+EDAuQ6O/HMnm/yDmUy/XgIZs2Rnj4wF3abjrDIqYSUsuZBLcTSyr67P63AQ6AIcfymTtTbomYKf3UF/75Hy3/45aMd+wUK2rS+6O9u1mD//PLP0Rr/VNWsdkMi1ysIdyi3Pw5uKwNGRagYMixzKYc7tLaI+G+R+6hEfU4AhkedB/xIO2P7oUfLsox+XWJ5bDCh2qJAEIuWo0MC0gw5Fg+s+d6GL77wPhvP7gb3m1yEITcFCS8b5tSH0sFvt8WpAQMOZbZZ+pP4bumFtf9+n/DP5lrwVliIghZ6E7tjo4MC0RgEIjP1IkehO+ZiB/SoOH798KmPoEaA9lLBJCgQNQpYhAERNBf827yqfow/Ejj6CPxTr0v/nws/ozGh0f3fnU9ue/SfPNDEw0g9+0Mh4uXKvWx4gviq6LSHURgselmHqu/hn/WSLCehCMCeSzfsrJCxJc/PQ5rZlPun8O/Gm/B+SZCH7uIOl5qri0sOhiCRSAmnquPwk/UB0UhPJZf3BcF8Sgshg7xkPSnfEDNE80opI/sU2QAqV1OlGF9xe1RAFILL4tCjD9Y74d/0Tr4m/zzwT1RFWJ8eCxKIOrkn8iZF8UvWgd1MkB08Yb3ELtKBWuIQUJYdDACi0B8hs9yV8Ngu3++9/ieFEQey7IQ5fJEeQ/fV/3Cg/Bdo+cny9zD4XqiTHF5DQIIiAGLTTf+aL0XVluQB5GirHu/DgvEJavmVykj0zQh4XsGT58fIvXRQ3ZhVRMzpWDRgQImm244yYohkN/kP5QCkdMt7gLZdJDQBzUVfXWIVyYJUhCG0XTjSVaMFOtXWRcjHsQVTbeeaArEcIqVTVbxUmW8wbXtnBJJkIqwhRCDSVYMk/6TFEEei9qQerFkfx6RhrZAjJp0egjkCLEYVjAYIKbaIoAAEqYQYvD2idXNGzHjj+QXv7mGAogokN80PsRoN+9gIymQY4RDD27vRwABcfAyCcRn6BzaA4WPhzqrHg3rQx4GEWPLY/W73feMDRS2nyP1QRWZLCF3XUMfL6BhCyHG+nge6nn6P5blcl+zj9dwqUn2GVIfJ0JkgkUup4gAAlSwhRBjj1izxYpyp5eRT/BQBoRabVQ1iI4AAlSwhRBjNsRsubv7rrFyd9qANJErNQRDxL7PCCBAA8YQ4jN0EtMTpgwlWLQBoZb6oeeBIIAALRhDiCEb4n4YvvfIYBBxS1NujfwubUCoiejB1RU8tA9SHbaxEKPP2Z/C4Z+f/PKA8UZ3P/jlyc9hY/kVuR9hmN4PJBhcRy4WhzEQoA1jCDGoEDPL/hg6YYD6GLoHi3boPrv/HYBDYQ0hRnP1Xx/dZ1047t7d+48MTpQKHaI+K7ScFMgrpENHAAGxYCrqTZJ7qbWB0kfLX0h9bKccOsp4QSyYQ4jzFbJjN21AyGm2Kofu/K8E7MObagqhJqGrDQi9nDu6eEE8mAXis7vFcVl4NEwbkCWkPtZ8QX0hu5sMHA17CPHZ3eQ4lKv08cZ2KoAUU18HAQTEhbWr18kKUcePTsqABGs2JsuXAc6A3af7fQ71IedV+qA2y1FNI3S8pQL2w55kOfS22kH7c3q7TvUQIRIsMDrsSZYjFdJK9+/SqzQEg6sF6mv47G40SAIMJFkOfPSG6PFBeiV3kbrfna9z4DyMJFkOU0hegK4vCYdrqQ7e4IYPHP0dgGMxkmQ56u7KrlfJI1xPVWAFV7yLBAsYwlCS5aAapvYzan0c+DOlj2V19BdAggV0YijJckp3r2fwnFof+1+nDQg1y9ZZIRA4HPYka3Fm4dnCCXa3WyRbaNTQBx0/VCVYSLAAC6z6mLClq7mh85yQYXfDtdKr8IEqWh9VhfQ3sLvhIKlgtCHd0b1jT/fsMLkLrTnytdKrcL0qv1pDG3QYEMAGkw2ZMLK38u43bQwimulVn6DKr9Ysor8BDAhghMGGLG5V3pC9b9kURPI3fagRPjoCdP+uaqscGBBgAP0KmdBClgQKY+1ob3fooIY+GqlFqiV9tEEfwDz6bUghXTbbW5ib6NZmD/RoyCN8kK5P1BoAgQEBRtBtQ84fpu/L3e+Vm1pilJX886dOaOmjc4tKH0tCC2BAABf0LnLSvld9ax6tzUxcQ7OEJi15hN/YptLHakGlD+eUAIAkQ6cN+fKA1t25c2BcYlo57uxOTXmcCKmGP4JLoQ/AEZ0KGezTukE7Tp7Ptr6JY9t6GzT10UyvzyBRrNKHz+5rDJIZfQJZH9K8RcONZ1ot7tDKGOg9oX3uFrX9CAaFV1Vtt/sKg6RGZ1fW76dOa9+mx3sHLBw4zAp92KF93hOhbVr6WKxqOTqwgCl0KmS+0Kl9p4Y7ut7stqZl3cLOP8Y4aXNopVoeqxdBH4A7Xn0K8ReeiRFEwqd7zvA3I+POtvbEOmG4d3C7Wh+VJWp9oIMXmEavQspiBpFwuOlUXTvHscMx/cLJI7FPFuquUeuj6is/9AGsQK9C/OdP9sW8azvOXRjM4JLQ5GVe2Ho0ZvAInzh19v8mVKv0UV0IfQCL0K2Q12qbwrFp7DqzI9NkHMkdu6O+pyHOSXoGNvr9z6oGQOoyoQ9gGboV4i/fcjjO3Rs+3HNhoNzo+GHe2MKBCz1xP/9ISF4qcVMlVZ5Y/CX0ASxEv0J+H+ztiHcLhzuaTwbenzYuj60BeWPL2wZ6O0f56P1vRSaa95N9WCtqFkAfwFL0K8T/mnZdLRFIzp2sr9vUna1HJfljxnUX7gj1Np8Y7VPP1ZVFm1D2lVIfa9/1Qx/AYhgU4p9We3S0m1l83B/sORMaHDzfnjFujOYMq/y87Iz+0gFhS29PU8Pon7dna/9IC75S5Fjr2jWaCH0AzrAo5NXCk52j39Iihxqb9nSdvPDmm62tg29tOl/e397eX3i2dLB1IBQQzpzpOrq7Q9fnhHcJ5cplfBbXDU2TWh0q02gg9AG4w6IQ//zzIR1RZJg/nmho3H2wqXnPrl1HO4/sbmzoOMTw2317i/upIqv1Fa8vlfSxfXC9RuugD2ABbCudrC+vjT3UzZNDe2v7Nc5fLtRtrxvUSq9QXwKsgXEtoFfbhS6dGZJxOrpC02JFsbL5msehD2AVrCsuZg50HTQvgtgcPFmSydgkn93XEKQyzGuSvlYa6tHRB2WExn3CW6+xtgfzB4Gl6J2nPsL6aRcONHN3Ix3n3mvtXszcGOgDWIyX+ab0+78sFHoP9plXxRB9zacG+ucbaAi6r4DleAztr3OtsPbUHi65VsPRnbWFG420wSH7M4BUx5BC/P6yhRc2m/TsJ5pbQhcKy4yd32f3dQPpgtfYHSr6kczSQFfPEUOdvx2dLfUD719bb/TcSK9AwjC2SVuEjdPeHQidOXdQ/1h5X0PTua6BgfMTDIvDj9EPkFgMpllDkaSsvbSkvrdrV1Nj3GjScbh53/7Nta3v9l8z4slH8Nl9vUC64TV1w0ZUktm/aXAgsPlU1969u/Y0Nx3Z3Xj8+GG5JGvvvpb9p3qFusHC7jIzcSMK0iuQcIz1ZqlZsH7jtQ/a+8vPn31rx6BU1Xu2sLx/2oRrZRt/Zx/n0AS9V8AWvHzuX6tB+AA2wSuIWAnCB7ARr933/2ggfABbcXYQQfgAtuO1WwWxQfgATsChEoE8gEPwsBfBW854ZFfAOTjNisB8AIfhJIlAHsCBeB0iER/MB3AmTpAI5AEcjN0SgTyAw7HTi8B7gCTArk5fdOyCZMGbeHkgtwLJRGLDCIIHSD4SZdhhzEGS4rFeIz4vggdIYjxeK+UBdYDkx6I4gtgBUgcvZ88+Hr4DpBgeXiIZj9ABUhRRJKbSLR/EAVIej9eIKfF5oQ2QRogy0RdNxKgBaYB0xeMRleIdP94nEVWExHhRFl7xP9rdPgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAICV/D/sz+qHaGlp2gAAAABJRU5ErkJggg==";
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

        Text attTitle = new Text("xxxx建议").setFont(simsumFont);

        String attContent = "1、xx建议测优秀一般xx建你好议xx建议xx建议xx建议优秀xx建议xx建议xx建议xx建议xx建议xx建议xx建xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议xx建议999999";
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
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decodeBuffer(imgStr);
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
