package com.donglan.service.impl;

import com.donglan.dao.UserDao;
import com.donglan.pojo.User;
import com.donglan.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return userDao.findById(id);
    }

    @Override
    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) throws SQLException {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }
}
