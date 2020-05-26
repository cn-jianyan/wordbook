package com.java1234.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Department)实体类
 *
 * @author makejava
 * @since 2020-05-14 23:16:13
 */
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = -99316750355922560L;
    
    private Integer d_id;
    /**
    * 部门名称
    */
    private String d_name;
    /**
    * 详情
    */
    private String des;



}