package com.donglan.controller;


import com.donglan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    public String register(User user){
        System.out.println("注册的用户："+user);
        return "success";
    }

    @RequestMapping("/returnModelAndView")
    public ModelAndView returnModelAndView(){

        // 初始化数据模型视图
        ModelAndView modelAndView = new ModelAndView();
        // 数据模型视图对象绑定一个视图的名称，同时还要绑定一些数据【会将数据存储到requestd域对象中】
        modelAndView.setViewName("success");
        modelAndView.addObject("username","张三");
        modelAndView.addObject("password","123456");
        // 返回数据模型视图，同样会去找视图解析器，解析viewName，使用请求转发跳转到对象的视图上面
        return modelAndView;
    }


    // 转发
    @RequestMapping("methodForward")
    public String methodForward(){
        System.out.println("请求转发");
        // return "success";
        //return "forward:/WEB-INF/pages/success.jsp";// 就不会通过视图解析器进行解析了
        //return "forward:/user/returnModelAndView";// 转发到其他的控制器上

        // 因为重定向实际上是客户端再次向服务器发送请求，所以无法访问WEB-INF目录
        //return "redirect:/register.jsp";// 重定向到register页面
        return "redirect:/user/returnModelAndView";// 重定向到其他的控制器上
    }


    @RequestMapping("/responseJson")
    @ResponseBody
    public User responseJson(){
        // 模拟数据库获取User
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setNickname("三三");
        user.setBirthday(new Date());
        List<String> hobbies = new ArrayList<>();
        hobbies.add("basketball");
        hobbies.add("football");
        user.setHobbies(hobbies);

        // 将User对象响应给客户端，转成json格式
        return user;
    }


}














