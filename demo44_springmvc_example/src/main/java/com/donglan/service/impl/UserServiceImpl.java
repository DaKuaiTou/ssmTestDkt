package com.donglan.service.impl;

import com.donglan.dao.UserDao;
import com.donglan.pojo.User;
import com.donglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
