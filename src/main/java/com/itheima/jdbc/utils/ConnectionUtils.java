package com.itheima.jdbc.utils;

import java.sql.Connection;

public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();



}
