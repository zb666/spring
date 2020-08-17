package it.cast.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Web页面中的引用，可以格式化的转化一些字符串的信息
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * 传入字符串
     * @param
     * @return
     */
    @Override
    public Date convert(String source) {
        if(source == null)
            throw new RuntimeException("数据为空");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转化异常");
        }
    }
}
