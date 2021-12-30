package com.donglan.mapper;

import com.donglan.pojo.User;
import com.donglan.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /*
    * 查询用户的数量
    * */
    Long findUserTotal();

    /*
    * 根据id返回用户数据
    * */
    User findById(Integer id);

    /*
    * 根据用户名返回用户数据
    * */
    Map findByUsername(String username);

    /*
    * 获取所有用户信息List
    * */
    List<User> findAllUsers1();

    /*
    * 获取所有用户信息Map
    * Map的值设置为Object，是因为value可能有Date格式的
    * */
    List<Map<String,Object>> findAllUsers2();

    /*
    * 查询所有用户信息
    * */
    List<UserInfo> findAllUserInfo();
}
