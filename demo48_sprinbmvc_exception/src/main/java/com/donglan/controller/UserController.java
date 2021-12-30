package com.donglan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("访问到了satHello方法");
        int num = 1/0;
        return "success";
    }
}
