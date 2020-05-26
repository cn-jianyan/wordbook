package com.java1234.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2020-05-14 23:19:19
 */
@Data
public class Notice implements Serializable {
    private static final long serialVersionUID = 931487732726083760L;
    
    private Integer n_id;
    /**
    * 公告名
    */
    private String n_name;
    /**
    * 内容
    */
    private String content;
    /**
    * 发布时间
    */
    private Date jointime;
    /**
    * 发布人
    */
    private Integer a_id;
    private String a_name;
    /**
    * 状态
    */
    private Integer state;


}