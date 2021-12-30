package com.donglan.service;

import com.donglan.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(Integer id);

    void deleteById(Integer id);

    void addUser(User user);

    void updateUser(User user);

}
