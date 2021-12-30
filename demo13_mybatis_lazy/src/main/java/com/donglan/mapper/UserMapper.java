package com.donglan.mapper;

import com.donglan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*
    * 通过uid获取用户信息
    * */
    User findUserByUid(Integer uid);

    /*
    * 通过uid获取用户的信息
    * */
    User findUserByUid2(Integer uid);
}
