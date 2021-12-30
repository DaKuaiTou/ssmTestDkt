package com.donglan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer rid;
    private String rName;
    private String rDesc;

    // 角色与用户是一对多的关系
    private List<User> userList;
}
