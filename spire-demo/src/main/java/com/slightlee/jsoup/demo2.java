package com.slightlee.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class demo2 {

    public static void main(String[] args) {


        String arrPath = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/";

        String filePath = arrPath + "ToHtml_1.html";

        File file = new File(filePath);

        try {
            Document doc = Jsoup.parse(file, "utf-8");

            Elements elements = doc.select("table");
//            for (Element element : elements) {
//                System.out.println(element);
//            }

            // 取第2个表格
            Element tab2 = elements.get(1);
//            System.out.println(tab2);
            // 获取 第2个表格 tr
            Elements tab2Tr = tab2.select("tr");
            for (Element tr : tab2Tr) {
//                System.out.println(tr);
                // 获取 tr 下的 td
                Elements trTd = tr.select("td");

                trTd.forEach(t -> System.out.println(t.text()));

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
