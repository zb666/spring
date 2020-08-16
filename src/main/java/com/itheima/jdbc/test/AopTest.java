package com.itheima.jdbc.test;

import com.itheima.jdbc.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = context.getBean("accountService",IAccountService.class);
        accountService.findAllAccount();
    }
}
