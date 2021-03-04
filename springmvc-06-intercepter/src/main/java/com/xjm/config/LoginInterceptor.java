package com.xjm.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Panda
 * @create 2021-03-04 15:02
 */
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //登录页面放行
        if(request.getRequestURI().contains("goLogin")){
            return true;
        }
        if(request.getRequestURI().contains("login")){
            return true;
        }
        //判断什么情况下没有登录
        if (session.getAttribute("userLoginInfo")!=null){
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
