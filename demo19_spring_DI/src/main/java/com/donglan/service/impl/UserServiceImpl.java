package com.donglan.service.impl;

import com.donglan.dao.UserDao;
import com.donglan.service.UserService;


/*
* 核心：
*   依赖注入：让Spring核心容器给容器中的对象的成员变量赋值
*       第一种方式：构造方法传参的方式，前提是需要由对应的构造函数
* */

public class UserServiceImpl implements UserService {

    // 从Spring的核心容器中，获取userDao对象，并且赋值给这个成员变量
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    public void findUser() {
        System.out.println("UserServiceImpl findUser method running");
        userDao.findUser();
    }
}
