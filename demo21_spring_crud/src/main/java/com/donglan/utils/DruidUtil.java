package com.donglan.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtil {

    private static DataSource dataSource;

    static{
        InputStream in = null;
        try {
            // 加载properties配置文件
            Properties properties = new Properties();
            // 类加载配置文件
            in = DruidUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 可以通过properties对象来加载输入流
            properties.load(in);

            // 可以用过Druid底层的工厂设计模式，去加载配置文件，从而创建出来DruidDataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
