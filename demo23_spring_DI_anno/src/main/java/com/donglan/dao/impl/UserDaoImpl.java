package com.donglan.dao.impl;

import com.donglan.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public void addUser() {
        System.out.println("UserDaoImpl addUser method running...");
    }

}
