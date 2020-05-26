package com.java1234.service.impl;

import com.java1234.dao.HasPowerDao;
import com.java1234.service.HasPowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HasPowerServiceImpl implements HasPowerService {
    @Resource
    HasPowerDao dao;

    @Override
    public Set<String> queryRole(String a_user) {
         List<String> li= dao.queryRole(a_user);
         Set set=new HashSet();
         li.forEach((i)->{
             String[] str=i.split(",");
             List x= Arrays.asList(str);
             set.addAll(x);
         });
         return  set;
    }

    @Override
    public Set<String> queryRname(String a_user) {
        return new HashSet<>(dao.queryRoleRname(a_user));
    }

    @Override
    public Set<String> queryPower(String a_user) {
        return new HashSet<>(dao.queryPower(a_user));
    }


    @Override
    public Integer insertrole(List<String> li, Integer aid) {
        dao.deleteRole(aid);
        return dao.role(li,aid);
    }

    @Override
    public Integer insertpower(List<String> li, Integer aid) {
       dao.deletePower(aid);
        return dao.power(li,aid);
    }

    @Override
    public Integer deleteRole(Integer aid) {
        return null;
    }

    @Override
    public Integer deletePower(Integer aid) {
        return null;
    }
}
