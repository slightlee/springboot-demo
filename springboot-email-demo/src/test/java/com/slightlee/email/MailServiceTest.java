package com.slightlee.email;

import com.slightlee.email.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
  * 邮件发送测试服务
  * @Author Morrow
  * @Date 2021/9/24 16:48
  */
@SpringBootTest
public class MailServiceTest {


    @Resource
    MailService mailService;

    @Autowired
    TemplateEngine templateEngine;


    @Test
    public void sayHelloTest() {
        mailService.sayHello();
    }


    /**
     *   文本邮件 发送测试
     */
    @Test
    public void sendSimpleMailTest(){
        mailService.sendSimpleMail("收件人邮箱地址","这是一个简单文本邮件","你好，这是第一封简单文本邮件");
    }


    /**
     *   HTML 邮件 发送测试
     */
    @Test
    public void sendHtmlMailTest() throws MessagingException {

        String content = "<html>\n" +
                "<body>\n" +
                "<h3>这是一封HTML邮件" +
                "</body>\n" +
                "</html>";

        mailService.sendHtmlMail("收件人邮箱地址","这是一封HTML邮件",content);
    }

    /**
     *   附件 邮件 发送测试
     */
    @Test
    public void sendAttachFileMailTest() throws MessagingException {
        mailService.sendAttachFileMail("收件人邮箱地址","这是一封附件邮件","你好呀，你看到我了","D:\\Desktop\\logo.jpg");
    }


    /**
     *   图片 邮件 发送测试
     */
    @Test
    public void sendImagerMail() throws MessagingException {

        String rscPath = "D:\\Desktop\\logo.jpg";
        String rscId = "img0001";
        String content =  "<html><body>你能看到一张图片:" +
                "<img src=\'cid:"+rscId+"\'>" +
                "<img src=\'cid:"+rscId+"\' width='500' height='200'>"+
                "</body></html>";

        //如果是多张图片 则可以 使用多个 <img ... > rscId 设置不同的值
        // 这里 设置图片的大小   <img src="cid:rscId"  width="500" height="200">

        mailService.sendImagerMail("收件人邮箱地址","这是一个图片邮件",content,rscPath,rscId);
    }

    /**
     *   模板 邮件 发送测试
     */
    @Test
    public void sendTemplateMailTest() throws MessagingException {

        Context context = new Context();
        context.setVariable("id","1001");
        String mailContext = templateEngine.process("mailTemplate.html", context);
        mailService.sendHtmlMail("收件人邮箱地址","这是一个模板邮件",mailContext);
    }

}
