package com.donglan.service;

import com.donglan.pojo.User;

import java.util.List;

public interface UserService {

    // 查询所有用户信息
    List<User> findAll();

    // 根据id删除用户
    void deleteById(Integer id);

    // 添加用户
    void addUser(User user);

}
