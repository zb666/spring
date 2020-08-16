package com.itheima.jdbc.dao.impl;

import com.itheima.jdbc.dao.IAccountDao;
import com.itheima.jdbc.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl2 extends JdbcDaoSupport implements IAccountDao {
    public void saveAccount() {

    }

    public List<Account> findAllCount() {
        return null;
    }

    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void saveAccount(Account account) {

    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?,money=? where id= ?",
                account.getName(),account.getMoney(),account.getId()
                );
    }

    public void deleteAccount(Integer accountId) {

    }

    public Account findAccountByName() {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>());
        if(accounts.isEmpty()){
            return  null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        return null;
    }


}
