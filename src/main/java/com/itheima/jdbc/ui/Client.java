package com.itheima.jdbc.ui;

import com.itheima.jdbc.factory.BeanFactory;
import com.itheima.jdbc.service.IAccountService;

public class Client {
    public static void main(String[] args) {
        for(int i = 0;i<5;i++){
            IAccountService accountService = (IAccountService) BeanFactory.getBeans("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
