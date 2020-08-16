package com.itheima.jdbc.service.impl;

import com.itheima.jdbc.dao.IAccountDao;
import com.itheima.jdbc.domain.Account;
import com.itheima.jdbc.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

//Service 这里可以做Aop的切面增强

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void  saveAccount(){
        accountDao.saveAccount();
        System.out.println("service中的saveAccount方法执行了。。。");
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllCount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        //根据名称查询转出的账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //查询转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //减少A账户的钱
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        //更新转出账户
//        int i = 1/0;
        //更新转入账户
        accountDao.updateAccount(targetAccount);
    }

}

