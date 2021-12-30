package com.donglan.mapper;

import com.donglan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
    * 根据用户的uid查询到一个用户的信息，并且连接其账户表查询该用户的所有账户信息
    * */
    User findUserAccountListByUid(Integer uid);
}
