package com.donglan.interceptor;


/*
*
* 拦截器
*   作用：在执行controller的方法之前可以做预处理，以及controller的方法之后做后处理
*   步骤：
*       1. 写一个类，实现HandlerInterceptor接口
*       2. 选择需要的方法来重写
*           preHandle()：在处理器方法之前执行
*           postHandle()：在处理器方法之后，视图解析之前执行
*           afterCompletion()：在视图解析之后执行，官方建议可以在该方法中做一些资源清理操作
*       3. 在springmvc.xml中，进行拦截器的配置(配置拦截器的拦截路径和排除拦截路径)
* */

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PermissionInterceptor的preHandle方法执行了...");
        // 返回值为true表示放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("PermissionInterceptor的postHandle方法执行了...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("PermissionInterceptor的afterCompletion方法执行了...");
    }
}
