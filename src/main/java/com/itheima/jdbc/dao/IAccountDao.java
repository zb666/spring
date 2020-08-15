package com.itheima.jdbc.dao;

import com.itheima.jdbc.domain.Account;

import java.util.List;

public interface IAccountDao {

    void saveAccount();

    List<Account> findAllCount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);

}
