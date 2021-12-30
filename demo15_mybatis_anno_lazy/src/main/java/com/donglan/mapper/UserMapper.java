package com.donglan.mapper;

import com.donglan.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /*
    * 通过uid获取用户信息
    * */
    @Select("select *from t_user where uid = #{uid}")
    User findUserByUid(Integer uid);

    /*
    * 通过uid获取用户的信息
    * */
    @Select("select *from t_user where uid = #{uid}")
    @Results({
            // 主键映射
            @Result(id = true,column = "uid",property = "uid"),
            // 一对多的关系映射
            // 全局懒加载
            // 当需要用户信息的时候，在去加载第二个sql语句
            @Result(property = "accountList", column = "uid",many = @Many(select = "com.donglan.mapper.AccountMapper.selectAccountByUid"))
    })
    User findUserByUid2(Integer uid);
}
