package com.itheima.jdbc.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {

    private static Properties pros;

    private static Map<String,Object> beans;

    static {
        try{
            pros = new Properties();
            beans = new HashMap<String, Object>();
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pros.load(inputStream);
            Enumeration<Object> keys = pros.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = pros.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        }catch (Exception ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Object getBeans(String beanName){
        return beans.get(beanName);
    }



}
