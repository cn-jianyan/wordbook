package com.java1234.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (File)实体类
 *
 * @author makejava
 * @since 2020-05-14 23:17:44
 */
@Data
public class File implements Serializable {
    private static final long serialVersionUID = -16307376159494232L;
    
    private Integer f_id;
    /**
    * 文件名
    */
    private String f_name;
    /**
    * 上传时间
    */
    private Date jointime;
    /**
    * 上传人
    */
    private Integer a_id;
    private String a_name;
    /**
    * 描述
    */
    private String des;
    /**
    * 状态
    */
    private Integer state;
    /**
    * 文件路劲
    */
    private String lu;



}