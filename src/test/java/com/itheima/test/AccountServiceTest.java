package com.itheima.test;

import com.itheima.jdbc.domain.Account;
import com.itheima.jdbc.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountServiceImpl;

    @Test
    public void testFindAll(){
        List<Account> allAccount = accountServiceImpl.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account account = accountServiceImpl.findAccountById(3);
        System.out.println(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(2);
        account.setName("AAA");
        account.setMoney(20.0f);
        accountServiceImpl.updateAccount(account);
        List<Account> allAccount = accountServiceImpl.findAllAccount();
        for (Account myAccount : allAccount) {
            System.out.println(myAccount);
        }
    }

}
