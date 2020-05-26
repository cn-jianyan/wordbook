package com.java1234.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface HasPowerService {
    /*
     * 根据账号查角色权限
     * */
    Set<String> queryRole(String a_user);
    Set<String> queryRname(String a_user);
    Set<String> queryPower(String a_user);

    Integer insertrole(@Param("li") List<String> li,@Param("aid") Integer aid);
    Integer insertpower(@Param("li") List<String> li,@Param("aid") Integer aid);

    Integer deleteRole(@Param("aid") Integer aid);
    Integer deletePower(@Param("aid") Integer aid);
}
