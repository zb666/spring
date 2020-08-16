package com.itheima.jdbc.service.impl;

import com.itheima.jdbc.domain.Account;
import com.itheima.jdbc.service.IAccountService;

import java.util.Date;
import java.util.List;


public class AccountServiceImpl2 implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }

    public List<Account> findAllAccount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        return null;
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {

    }

    public void deleteAccount(Integer accountId) {

    }

    public void transfer(String sourceName, String targetName, Float money) {

    }


}

