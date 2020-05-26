package com.java1234.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-05-14 23:13:46
 */
@Data
public class Admin implements Serializable {
    private static final long serialVersionUID = 417636665062278662L;
    /**
    * 用户主键
    */
    private Integer a_id;
    /**
    * 用户账户
    */
    private String a_user;
    /**
    * 密码
    */
    private String pwd;
    /**
    * 用户名
    */
    private String a_name;
    /**
    * 状态
    */
    private Integer state;
    /**
    * 添加时间
    */
    private Date jointime;


}