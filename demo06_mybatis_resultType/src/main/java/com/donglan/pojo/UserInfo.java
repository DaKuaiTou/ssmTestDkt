package com.donglan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private Integer idInfo;
    private String username;
    private String sexInfo;
    private Date birthdayInfo;
    private String addressInfo;

}
