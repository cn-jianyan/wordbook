package com.java1234.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Job)实体类
 *
 * @author makejava
 * @since 2020-05-14 23:19:05
 */
@Data
public class Job implements Serializable {
    private static final long serialVersionUID = -55764784827794141L;
    
    private Integer j_id;
    /**
    * 职位
    */
    private String j_name;
    /**
    * 详情
    */
    private String des;


}