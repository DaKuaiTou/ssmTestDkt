package com.donglan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryUser {

    public QueryUser(Long currentPage, Integer pageSize, User queryCondition) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.queryCondition = queryCondition;
    }

    private Long currentPage;// 当前页
    private Integer pageSize;// 每页显示的数据
    private Long offset;// 就是limit后面的第一个？占位符，表示从第几行数据开始读取

    private User queryCondition;// 作为一个搜索条件而存在的

    public Long getOffset(){
        return (currentPage - 1) * pageSize;
    }
    /*
    * limit ?,?
    * 第一页   limit 0,3
    * 第二页   limit 3,3
    * 第三页   limit 6,3
    *
    * */
}
