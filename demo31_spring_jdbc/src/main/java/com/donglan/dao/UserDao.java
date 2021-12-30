package com.donglan.dao;

import com.donglan.pojo.User;

public interface UserDao {

    User findUserById(Integer id);

    User findUserByUsername(String username);

    void updateUser(User user);
}
