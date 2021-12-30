package com.donglan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*
* SpringMVC中，Controller配置一些方法来接收请求
*   1. IOC配置，所有的controller对象都要配置到spring的核心容器中来统一管理
*   2. 进行映射路径的配置， 在要处理请求的方法上添加注解@RequestMapping来配置映射路径
*   3. 在web.xml配置文件中，配置DispatcherServlet的映射路径，并且配置服务器启动时加载
*   4. 告诉DispatcherServlet，要加载的spring、springmvc的配置文件的路径，告诉servl的初始化参数
*
* 配置跳转到成功页面
*   1. 配置视图解析器，在spring的配置文件中来配置，将controller的方法的返回值进行解析，解析成真正的视图地址
*   2. 让controller的方法，返回一个字符串，这个字符串可以匹配视图解析器上的字符串
* */

@Controller
public class HelloController {

    @RequestMapping("/hello/sayHello")
    public String sayHello(){
        System.out.println("hello World...");

        // 跳转到success页面：/WEB-INF/pages/success.jsp
        return "success";
    }
}
