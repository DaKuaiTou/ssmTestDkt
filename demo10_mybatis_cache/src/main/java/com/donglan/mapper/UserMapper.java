package com.donglan.mapper;

import com.donglan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
    * 查询所有用户信息
    * */
    List<User> findAllUsers();

    /*
    * 新增用户
    * */
    void insertUser(User user);
}
