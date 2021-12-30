package com.donglan.service.impl;

import com.donglan.mapper.UserMapper;
import com.donglan.pojo.User;
import com.donglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    public void addUser(User user) {
        userMapper.addUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
