package com.donglan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Integer uid;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    /*
    * 一个用户至少担任一个角色
    * 用户和角色  一对多的关系
    * */

    private List<Role> roleList;
}
