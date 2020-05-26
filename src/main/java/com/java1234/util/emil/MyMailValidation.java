package com.java1234.util.emil;

import lombok.Data;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author jianyan
 * @version 1.0
 * 邮箱验证类 验证邮箱账户密码是否正确
 * 继承邮箱验证类 Authentcator
 * */
@Data
public class MyMailValidation extends Authenticator {
    String username=null;//账户
    String password=null;//密码

    public MyMailValidation(){

    }
    public MyMailValidation(String username,String password){
        this.username=username;
        this.password=password;
    }
    //验证用户名以及密码
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username,password);
    }
}
