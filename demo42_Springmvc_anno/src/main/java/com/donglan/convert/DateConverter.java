package com.donglan.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Converter<String,Date>接口泛型中，第一个泛型是要转换的类型，第二个泛型是转换后的类型
* */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {// s表示的就是要进行类型转换的那个字符串，比如“1990-11-18”
        // 进行类型转换的相关操作。返回最终的类型，返回Date类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Date类型转换错误");
        }
    }
}
