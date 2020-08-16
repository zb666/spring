package com.itheima.jdbc.test.jdbctemplate;

import com.itheima.jdbc.dao.IAccountDao;
import com.itheima.jdbc.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = context.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        account.setMoney(3000f);
        accountDao.updateAccount(account);
    }

}
