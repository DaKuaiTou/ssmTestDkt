package com.donglan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer aid;
    private Double money;
    private Integer uid;

    // 一对一关系：一个账户一定对应所属的一个用户
    private User user;


}
