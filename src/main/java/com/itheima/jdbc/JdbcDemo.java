package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 1 程序的依赖
 * 2 类之间的依赖
 * 3 方法之间的依赖
 *
 * 解耦：降低程序间的依赖关系
 *
 * 实际开发：
 *  编译时期不依赖，运行时才依赖
 *  反射创建对象，避免使用new
 *
 *  Class.forName("path") 但是这样还是有问题
 *  通过读取配置文件的方式去创建对象
 *  配置文件  Xml
 *  或者properties
 */
public class JdbcDemo {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bob1","root","root");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from user ");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("username"));
        }
        //6.释放资源 
        rs.close();
        pstm.close();
        conn.close();
    }


}
