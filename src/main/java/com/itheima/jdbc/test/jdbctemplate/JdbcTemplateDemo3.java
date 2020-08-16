package com.itheima.jdbc.test.jdbctemplate;

import com.itheima.jdbc.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account(name,money)values(?,?)","eee",3333f);
        //更新
//        jt.update("update account set name=?,money=? where id=?","test",4567,7);
        //删除
//        jt.update("delete from account where id=?",8);

        Long count = jdbcTemplate.queryForObject("select count(*) from account where money > ?", Long.class, 100f);
        System.out.println(count);
    }
}

class AccountRowMapper implements RowMapper<Account>{

    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
