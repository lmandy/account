package com.lmandy.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by liming<liming@1rock.net> on 2017/8/1.
 */
@Component("anyPerms")
public class CustomPermsAuthorizationFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] permsArray = (String[]) mappedValue;

        if (permsArray == null || permsArray.length == 0) { //没有权限限制，有权限访问
            return true;
        }
        for (int i = 0; i < permsArray.length; i++) {
            if (subject.isPermitted(permsArray[i])) { //若当前用户权限是permsArray中的任何一个，则有权限访问
                return true;
            }
        }

        return false;
    }
}
