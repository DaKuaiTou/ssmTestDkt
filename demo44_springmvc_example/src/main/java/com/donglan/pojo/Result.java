package com.donglan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private Boolean flag;// 增删改是否成功的标记
    private Object result;// 查询的结果的封装
    private String message;// 成功与否的信息
}
