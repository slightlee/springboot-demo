package com.slightlee.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class demo1 {

    public static void main(String[] args) {


        String arrPath = "/Users/ming/local/IdeaProjects/springboot-demo/spiredoc-demo/src/main/java/com/slightlee/doc/";

        String filePath = arrPath + "ToHtml_1.html";

        File file = new File(filePath);

        try {
            Document doc = Jsoup.parse(file, "utf-8");

            // 获取URL的链接
            Elements links = doc.select("a[href]");
//            for (Element link : links) {
//                System.out.println("\nlink : " + link.attr("href"));
//                System.out.println("text : " + link.text());
//            }

            // 获取URL的图像
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images) {
                System.out.println("src : " + image.attr("src"));
//                System.out.println("height : " + image.attr("height"));
//                System.out.println("width : " + image.attr("width"));
//                System.out.println("alt : " + image.attr("alt"));
            }

            System.out.println("===========================");
//
//            Elements normal = doc.getElementsByClass("Normal");
//            for (Element element : normal) {
//                System.out.println(element);
//            }


            System.out.println("==============2222=============");

            Elements elements = doc.select("table");
            for (Element element : elements) {
                System.out.println(element);
            }
            Element element = elements.get(1);
            System.out.println(element);

            System.out.println("==============tr=============");

            Elements elements1 = element.select("tr");
            for (Element elementtr : elements1) {
                System.out.println(elementtr);
            }


//            // 获取 class="resultView" 标签中内容
//            String resultView = document.select("table[class=resultView]").html();
//            System.out.println("resultView：" + resultView);
//
//            String text = document.select("table[class=resultView]").text();
//            System.out.println("text：" + text);

        } catch (IOException e) {
           e.printStackTrace();
        }

    }
}
