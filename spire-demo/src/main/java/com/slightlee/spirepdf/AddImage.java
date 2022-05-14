package com.slightlee.spirepdf;

import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

public class AddImage {
    public static void main(String[] args) {

        String path = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/pdf/";

        //创建文档
        PdfDocument pdf = new PdfDocument();

        //添加一页
        PdfPageBase page = pdf.getPages().add();

        //加载图片，并获取图片高宽
        PdfImage image1 = PdfImage.fromFile("/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/ToHtml_1_images/ToHtml_1_img1.png");
        int width1 = image1.getWidth()/2;
        int height1 = image1.getHeight()/2;
        PdfImage image2 = PdfImage.fromFile("/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/ToHtml_1_images/ToHtml_1_img2.png");
        int width2 = image2.getWidth()/2;
        int height2 = image2.getHeight()/2;
        PdfImage image3 = PdfImage.fromFile("/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/ToHtml_1_images/ToHtml_1_img3.png");
        int width3 = image3.getWidth()/2;
        int height3 = image3.getHeight()/2;

        //绘制图片到PDF
        page.getCanvas().drawImage(image1,50,50,width1, height1);
        int imageHeight2 = 50  + height1;
        page.getCanvas().drawImage(image2,50,imageHeight2,width2, height2);
        int imageHeight3 = imageHeight2 + height2;
        page.getCanvas().drawImage(image3,50,imageHeight3,width3, height3);

        //保存文档
        pdf.saveToFile(path + "add_image.pdf");
        pdf.dispose();
    }
}