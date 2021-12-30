package com.donglan.service.impl;

import com.donglan.dao.UserDao;
import com.donglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Value("冬澜有雪")
    private String nickname;

/*    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;*/

    @Resource(name="userDaoImpl")
    private UserDao userDao;


    public void addUser() {
        System.out.println("UserServiceImpl addUser method running...");
        userDao.addUser();
    }
}
