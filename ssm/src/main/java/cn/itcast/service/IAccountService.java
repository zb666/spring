package cn.itcast.service;

import cn.itcast.domian.Account;

import java.util.List;

public interface IAccountService {

    // 查询所有账户
     List<Account> findAll();

    // 保存帐户信息
     void saveAccount(Account account);

    List<Account> findByName(String name);
}
