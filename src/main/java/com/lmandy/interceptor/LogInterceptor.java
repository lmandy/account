package com.lmandy.interceptor;

import com.lmandy.bean.AccountSystemUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 94993 on 2017/3/21.
 */
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println("执行顺序。。。。。。1");

        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();

        String url = uri.substring(contextPath.length());

        if(url.equals("/login") || url.equals("/")){
            return true;
        }else {
            AccountSystemUser systemUser = (AccountSystemUser) request.getSession().getAttribute("user");
            if(systemUser == null){
                //不符合条件的，跳转到登录界面
                request.getRequestDispatcher("/").forward(request, response);
                return false;
            } else{
                return true;
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("执行顺序。。。。。。2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("执行顺序。。。。。。3");

    }
}
