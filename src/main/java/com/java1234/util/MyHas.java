package com.java1234.util;

import lombok.Data;

import java.util.List;

/**
 * 存储权限设置存储的权限信息
 */
@Data
public class MyHas {
    private List<String> r;
    private List<String> p;
    private  Integer aid;
}
