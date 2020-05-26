package com.java1234.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-05-22 11:38:40
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -49772080617117361L;
    /**
    * 角色id
    */
    private Integer rid;
    /**
    * 角色名称
    */
    private String rname;
    /**
    * 拥有权限
    */
    private String has;
    /**
    * 描述
    */
    private String des;

    private  boolean checked;

}