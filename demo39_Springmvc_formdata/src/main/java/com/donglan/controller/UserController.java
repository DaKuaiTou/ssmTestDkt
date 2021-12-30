package com.donglan.controller;


import com.donglan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {


    // 一个一个参数进行获取：在处理请求的方法中，添加和请求参数相同的参数名称集合
    @RequestMapping("/findbyName")
    public String findbyName(String username,int age){
        System.out.println("用户名称："+username+"，年龄是："+age);
        return "success";
    }
    // 如果请求的参数名和方法的参数名不一致，我们应该怎么办？
    // 我们可以通过RequestParam注解来指定获取的请求参数名
    @RequestMapping("/findbyName1")
    public String findbyName1(@RequestParam("username") String name, int age){
        System.out.println("用户名称："+name+"，年龄是："+age);
        return "success";
    }

    // pojo实体类型的参数
    // 在方法中加入一个pojo类型的参数，要求pojo实体类中的属性和请求参数的名称一致
    // pojo类型的属性一定要有set方法，pojo类中一定要有无参构造方法
    @RequestMapping(path = "/register",method = {RequestMethod.POST})
    public String register(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping(path = "/register1",method = {RequestMethod.POST})
    public String register1(User user){
        System.out.println(user);
        return "success";
    }

    // 如果传过来的参数是多个同名的参数，我们可以使用List或者数组进行封装，
    // 请求参数名称一定要和方法的参数名称一致，而且一定要在List参数前加@RequestParam
    @PostMapping("deleteMore")
    public String deleteMore(@RequestParam List<Integer> ids){
        System.out.println("要删除的数据："+ids);
        return "success";
    }

    // 请求参数是多个的情况下，可以封装到Map中
    @PostMapping("register2")
    public String register2(@RequestParam Map map){
        System.out.println("获取到的请求参数是："+map);
        return "success";
    }
}
