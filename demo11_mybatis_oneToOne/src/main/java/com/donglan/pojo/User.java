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
    * 我们在查询用户的时候，需要带有其用户的账户信息
    * 一个用户不止一个账户，一对多的关系
    * 查询用户的时候，我们需要一个存放多个账户信息的集合对象
    * 专门用来存放用户的多个账户信息，这样的话，一对多的关系就可以保存过来了
    * */

    List<Account> accountList;

}
