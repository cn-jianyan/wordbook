package com.java1234.util;

import lombok.Data;

import java.util.Set;

public class HasSet<T> {
    Set<T> set;

    public boolean getHas(String xxx){
        return  set.contains(xxx);
    }
}
