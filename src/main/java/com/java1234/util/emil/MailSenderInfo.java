package com.java1234.util.emil;

import lombok.Data;

import java.util.Properties;

/**
 * @author jianyan
 * 邮件信息类
 * @version 1.0
 * 2020.5.24
 */
@Data
public class MailSenderInfo {
    //连接邮箱的服务器
    private String mailServerHost; //服务器的主机号
    private  String mailServerPort; //服务器的端口


    //发送者的邮箱信息
    private  String fromAddresss;  //发送者的地址
    private  String username;    //发送者的邮箱账户
    private String password;    //发送者的邮箱密码

    //收件人的信息
    private  String toAddrss;//收件人的地址
    private  String title;//邮件主题
    private  String content;//邮件内容

    /**
     * 获得邮件的会话属性session
     * smtp:简单邮件传输协议
     */
    public Properties getProperties(){
        Properties p=new Properties();
        p.put("mail.smtp.host",this.mailServerHost);//邮件主机服务器
        p.put("mail.smtp.port",this.mailServerPort);//端口号
        p.put("mail.smtp.auth",true);
        return p;
    }

}
