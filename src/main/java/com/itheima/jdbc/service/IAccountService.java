package com.itheima.jdbc.service;

import com.itheima.jdbc.domain.Account;

import java.util.List;

public interface IAccountService {

    void saveAccount();

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
