package com.java1234.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Staff)实体类
 *
 * @author makejava
 * @since 2020-05-14 23:20:03
 */
@Data
public class Staff implements Serializable {
    private static final long serialVersionUID = 989671763165783051L;
    
    private Integer s_id;
    /**
    * 员工名称
    */
    private String s_name;
    /**
    * 性别
    */
    private String sex;
    /**
    * 电话
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 职位
    */
    private Integer j_id;
    private  String j_name;
    /**
    * 学历
    */
    private String school;
    /**
    * 身份证
    */
    private String card;
    /**
    * 部门
    */
    private Integer d_id;
    private  String d_name;
    /**
    * 家庭住址
    */
    private String lu;
    /**
    * 入职时间
    */
    private Date jointime;



}