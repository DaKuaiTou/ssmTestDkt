package com.donglan.mapper;

import com.donglan.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface AccountMapper {

    /*
    * 通过aid查询账户信息
    * */
    @Select("select *from t_account where aid = #{aid}")
    @Results({
            // 映射主键
            @Result(column = "uid",property = "uid",id = true),
            // 懒加载：当需要关联表数据的时候，在加载，第二步的SQl语句
            // 设置局部懒加载，在@One注解中 fetchType = FetchType.LAZY
            @Result(property = "user",one = @One(select = "com.donglan.mapper.UserMapper.findUserByUid"),column = "uid")
    })
    Account selectAccountByAid(Integer aid);


    @Select("select *from t_account where uid = #{uid}")
    Account selectAccountByUid(Integer uid);

}
