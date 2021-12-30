package com.donglan.controller;


import com.donglan.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    public String register(User user){
        System.out.println("注册的用户："+user);
        return "success";
    }
}
