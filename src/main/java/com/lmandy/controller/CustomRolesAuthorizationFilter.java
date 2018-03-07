package com.lmandy.controller;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by liming<liming@1rock.net> on 2017/8/1.
 * shiro   /record/* = roles["zhangsan,admin"] 默认是&，即同时拥有2中角色才能访问，
 * 这里我们继承AuthorizationFilter重写isAccessAllowed方法实现任意一角色即可访问
 *
 * 同理，权限也是如此
 *
 */
@Controller("anyRoles")
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问
            return true;
        }
        for (int i = 0; i < rolesArray.length; i++) {
            if (subject.hasRole(rolesArray[i])) { //若当前用户是rolesArray中的任何一个，则有权限访问
                return true;
            }
        }

        return false;
    }
}
