package com.donglan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello1")
    public String sayHello1(){
        System.out.println("hello World...sayHello1");
        return "success";
    }

    // 请求参数必须是 password=123 的请求才可以成功请求到该方法，否则会报错400，Bad request
    @RequestMapping(value = "/sayHello2",params = {"password=123"})
    public String sayHello2(){
        System.out.println("hello World...sayHello2");
        return "success";
    }

    // 该方法只能指定接收post的请求
    @RequestMapping(path = "/sayHello3",method = {RequestMethod.POST})
    @PostMapping("/sayHello3")
    public String sayHello3(){
        System.out.println("hello World...sayHello3");
        return "success";
    }

    // 请求头中必须含有 content-type=text/* ，才能请求成功，否则报错
    @RequestMapping(params = "/sayHello4",headers = {"content-type=text/*"})
    public String sayHello4(){
        System.out.println("hello World...sayHello4");
        return "success";
    }
}
