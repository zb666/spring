package com.itheima.jdbc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的链接
     */
    public Connection getThreadConnection(){
        try {
            Connection connection = threadLocal.get();
            if(connection == null){
                //缓存到当前线程的ThreadLocal
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        threadLocal.remove();
    }

}
