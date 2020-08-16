package com.itheima.jdbc.service;

import com.itheima.jdbc.domain.Account;
import com.sun.xml.internal.txw2.annotation.XmlNamespace;

import java.util.List;

//CacheNameSpace(blocking=true)//基于注解方式实现配置二级缓存
public interface IAccountService {

    void saveAccount();

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer accountId);
}
