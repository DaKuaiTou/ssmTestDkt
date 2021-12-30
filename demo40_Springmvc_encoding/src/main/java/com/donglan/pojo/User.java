package com.donglan.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {

    private String username;
    private String password;
    private String nickname;
    private Date birthday;

    private List<String> hobbies;
}
