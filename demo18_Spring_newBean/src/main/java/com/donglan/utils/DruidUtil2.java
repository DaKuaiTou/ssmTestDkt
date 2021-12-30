package com.donglan.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
* 获取数据源的工具类
* 打造成一个静态工厂
* */
public class DruidUtil2 {
    public DruidUtil2() {
        System.out.println("DruidUtil的无参构造方法");
    }

    private static DataSource dataSource;

    static {
        InputStream inputStream = null;
        try {
            // 读取一下properties文件，
            inputStream = DruidUtil2.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 使用properties对象来加载一下输入流
            Properties properties = new Properties();
            properties.load(inputStream);
            // 然后我们就可以使用
            dataSource = DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public DataSource getDataSource(){
        return dataSource;
    }

}
