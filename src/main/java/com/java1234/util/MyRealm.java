package com.java1234.util;

import com.java1234.entity.Admin;
import com.java1234.service.AdminService;
import com.java1234.service.HasPowerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

public class MyRealm  extends AuthorizingRealm {
    @Resource
    HasPowerService has;
    @Resource
    AdminService ad;

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=principalCollection.toString();
        Set set=has.queryRole(username);
        set.addAll(has.queryPower(username));
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(set);
        return authorizationInfo;
    }

    /*用户认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username=token.getPrincipal().toString();


        Admin a=new Admin(); a.setA_user(username);
        System.out.println("Realm："+a);
        Admin admin=ad.queryAllByAll(a).get(0);
        if(admin==null){
            throw new UnknownAccountException("用户名或密码错误");
        }else{
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(admin.getA_user(),admin.getPwd(),this.getName());
            return authenticationInfo;
        }

    }
}
