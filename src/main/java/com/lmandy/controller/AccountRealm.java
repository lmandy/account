package com.lmandy.controller;

import com.lmandy.bean.AccountSystemRole;
import com.lmandy.bean.AccountSystemUser;
import com.lmandy.service.backstage.ISystemRoleService;
import com.lmandy.service.backstage.ISystemUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liming<liming@1rock.net> on 2017/7/31.
 * shiro 登录认证授权
 */
@Component("accountRealm")
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private ISystemUserService systemUserService;
    @Autowired
    private ISystemRoleService roleService;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("执行认证......");
        //封装的是当前的登录名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        //获取用户名
        String username = usernamePasswordToken.getUsername();
        //使用当前登录名作为查询条件，查询数据库，获取当前登录名的对象
        AccountSystemUser user = systemUserService.getByName(username);
        if(user == null){
            return null;
        }



        return new SimpleAuthenticationInfo(user,user.getPassWord(),this.getName());
    }

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        System.out.println("执行授权......");
        AccountSystemUser user = (AccountSystemUser) principals.getPrimaryPrincipal();
        List<AccountSystemRole> roles = roleService.getRolesByUserId(user.getId());
        for (AccountSystemRole role : roles) {
            authorizationInfo.addRole(role.getRoleName());
        }

        authorizationInfo.addStringPermission("person");

        return authorizationInfo;
    }

}
