package com.slightlee.spiredoc;

import com.spire.doc.*;

public class WordtoHtml {

    public static void main(String[] args) {
        //实例化Document类的对象
        Document doc = new Document();

        String arrPath = "/Users/ming/local/IdeaProjects/springboot-demo/spire-demo/src/main/java/com/slightlee/doc/";

        //加载Word文档
        doc.loadFromFile(arrPath + "1.docx");

        //保存为HTML格式
        doc.saveToFile(arrPath + "ToHtml_1.html", FileFormat.Html);
        doc.dispose();
    }
}