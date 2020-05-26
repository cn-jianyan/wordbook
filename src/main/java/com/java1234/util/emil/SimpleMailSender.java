package com.java1234.util.emil;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

/**
 * @author jianyan
 * 邮件发送核心类
 * 2020.5.24
 * @version 1.0
 */
public class SimpleMailSender {
    /**
     * 发送html格式的邮件
     * @param mailInfo 待发送邮件信息
     * @return
     * */
    public boolean sendHtmlMail(MailSenderInfo mailInfo){
        //1.判断是否需要身份验证
        MyMailValidation validation=null;//验证类
        Properties pro=mailInfo.getProperties();//拿到主机和端口
        //2.验证类实例化  如果需要身份验证，则需要创建一个密码的验证器

        validation=new MyMailValidation(mailInfo.getUsername(),mailInfo.getPassword());

        //3.根据邮件的会话属性和密码验证器构建一个发送邮件的的session
        Session sendMailSession=Session.getDefaultInstance(pro,validation);
        sendMailSession.setDebug(true);
        try {
          //4.通过session会话创建邮件信息
          Message message=new MimeMessage(sendMailSession);
          //5.创建邮件发送者的地址
          Address form=new InternetAddress(mailInfo.getFromAddresss());
          //6.设置邮件的发送者 并且把发送者地址设置到邮件中
          message.setFrom(form);
          //7.设置接受者的地址
          Address to=new InternetAddress(mailInfo.getToAddrss());
          //8.Message.RecipientType.TO 表示接收者的类型  to接收者的地址
          message.setRecipient(Message.RecipientType.TO,to);
          //9.设置邮件的主题
          message.setSubject(mailInfo.getTitle());
          //10.设置发送的时间
          message.setSentDate(new Date());
//内容
          //11.创建一个容器类
          Multipart multipart=new MimeMultipart();
          //12.创建一个包含html容器的body
          BodyPart html=new MimeBodyPart();
          html.setContent(mailInfo.getContent(),"text/html;charset=utf-8");//htm格式 防止出现乱码
          multipart.addBodyPart(html);//把html放入容器中
          message.setContent(multipart);//把内容放到发送邮件信息对象中

          //发送邮件的固定格式
          MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
          mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
          mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
          mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
          mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed; x-java-fallback-entry=true");
          mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
          CommandMap.setDefaultCommandMap(mc);

          Transport.send(message);//发送邮件
          System.out.println("邮件发送成功");
           return  true;
      }catch (Exception e){
          e.printStackTrace();
          return  false;
      }


    }
}
