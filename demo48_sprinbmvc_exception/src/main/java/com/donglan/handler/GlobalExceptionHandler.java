package com.donglan.handler;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 全局异常处理器
*   作用：处理整个项目中的所有的controller抛出的异常
*   步骤：
*       1. 编写一个类，让这个类实现 HandlerExceptionResolver 接口
*       2. 重回resolverException方法
*       3. 在springmvc.xml配置文件你中，配置异常解析器
* */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // 形参 e 表示的捕获的异常信息，使用该对象可以收集异常信息
        e.printStackTrace();// 可以在控制台打印异常信息

        // 返回ModelAndView模型视图，就可以给模型实体设置视图名称，经过视图解析器来解析成物理视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
