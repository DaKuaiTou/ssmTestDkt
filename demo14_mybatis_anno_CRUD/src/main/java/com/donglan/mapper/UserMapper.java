package com.donglan.mapper;


import com.donglan.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    /*
    * 新增用户
    * */
    @Insert("insert into t_user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    @SelectKey(keyProperty = "uid",keyColumn = "uid",resultType = int.class,before = false,statement = "select last_insert_id()")
    int insertUser(User user);

    /*
    * 根据uid删除用户
    * */
    @Delete("delete from t_user where uid = #{uid}")
    int deleteUserByUid(Integer uid);

    /*
    * 修改用户
    * */
    @Update("update t_user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where uid = #{uid}")
    int updateUser(User user);

    /*
    * 根据uid查询用户
    * */
    @Select("select *from t_user where uid = #{uid}")
    User selectUserByUid(Integer uid);

}
