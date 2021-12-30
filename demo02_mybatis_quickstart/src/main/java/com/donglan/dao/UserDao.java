package com.donglan.dao;

import com.donglan.pojo.User;

import java.util.List;

/*
* 持久层接口，建议命名方式可以改成UserMapper
* */
public interface UserDao {

    // 查询所有用户信息，返回所有用户列表数据
    List<User> findAllUser();
}
