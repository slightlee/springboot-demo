package com.slightlee.spiredoc;

import com.spire.xls.*;

public class ReadProperties {
    public static void main(String[] args) {
        //加载Excel文档
        Workbook wb = new Workbook();
        wb.loadFromFile("/Users/ming/Desktop/666.xlsx");

        //读取Excel内置文档属性
        System.out.println("标题： " + wb.getDocumentProperties().getTitle());
        System.out.println("主题： " + wb.getDocumentProperties().getSubject());
        System.out.println("作者： " + wb.getDocumentProperties().getAuthor());
        System.out.println("单位： " + wb.getDocumentProperties().getCompany());
        System.out.println("主管： " + wb.getDocumentProperties().getManager());
        System.out.println("类别： " + wb.getDocumentProperties().getCategory());
        System.out.println("关键字： " + wb.getDocumentProperties().getKeywords());

        //获取Excel自定义文档属性
        DocumentProperty property = (DocumentProperty) wb.getCustomDocumentProperties().get(0);
        //读取第一个自定义文档属性的名称和值
        System.out.println("名称： " + property.getName());
        System.out.println("值： " + property.getValue());
    }
}