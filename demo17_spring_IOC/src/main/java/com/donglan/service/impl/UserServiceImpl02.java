package com.donglan.service.impl;

import com.donglan.service.UserService;

public class UserServiceImpl02 implements UserService {
    public UserServiceImpl02() {
        System.out.println("UserServiceImpl02 method...");
    }

    public String getUserName() {
        return "UserServiceImpl02 getUsername() method running";
    }

    /*
    * 初始化时候调用的方法
    * */
    public void initData(){
        System.out.println("初始化时候调用的方法");
    }
    /*
    * 销毁的时候调用的方法
    * */
    public void saveData(){
        System.out.println("该对象销毁前对数据进行了保存操作");
    }
}
