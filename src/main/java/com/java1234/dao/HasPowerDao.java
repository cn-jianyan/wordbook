package com.java1234.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HasPowerDao {
    /*
    * 根据账号查角色权限
    * */
    List<String> queryRole(String a_user);
    List<String> queryRoleRname(String a_user);

    List<String> queryPower(String a_user);

    Integer role(@Param("li") List<String> li,@Param("aid") Integer aid);
    Integer power(@Param("li") List<String> li,@Param("aid") Integer aid);

    Integer deleteRole(@Param("aid") Integer aid);
    Integer deletePower(@Param("aid") Integer aid);
}
