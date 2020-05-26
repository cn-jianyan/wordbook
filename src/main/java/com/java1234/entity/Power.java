package com.java1234.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Power)实体类
 *
 * @author makejava
 * @since 2020-05-22 11:38:40
 */
@Data
public class Power implements Serializable {
    private static final long serialVersionUID = -43343381646998918L;
    
    private Integer pid;
    
    private String pname;
    
    private String has;

    private  boolean checked;


}