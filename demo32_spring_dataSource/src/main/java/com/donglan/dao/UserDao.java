package com.donglan.dao;

import com.donglan.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> findUser();
}
