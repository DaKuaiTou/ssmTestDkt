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


    // 一对多的关系，一个用户匹配多个账户
    private List<Account> accountList;
}
