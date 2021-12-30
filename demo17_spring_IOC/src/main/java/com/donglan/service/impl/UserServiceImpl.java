package com.donglan.service.impl;

import com.donglan.service.UserService;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        System.out.println("UserServiceImpl method ...");
    }

    public String getUserName() {
        return "UserServiceImpl getUsername() method running";
    }
}
