package com.donglan.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/sayHello")
    public String satHello(){

        System.out.println("sqyHello方法被调用了");

        return "success";
    }

}
