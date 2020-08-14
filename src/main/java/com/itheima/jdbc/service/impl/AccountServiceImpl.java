package com.itheima.jdbc.service.impl;

import com.itheima.jdbc.dao.IAccountDao;
import com.itheima.jdbc.factory.BeanFactory;
import com.itheima.jdbc.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao iAccountDao = (IAccountDao) BeanFactory.getBeans("accountDao");

    public void saveAccount() {
        iAccountDao.saveAccount();
    }
}
