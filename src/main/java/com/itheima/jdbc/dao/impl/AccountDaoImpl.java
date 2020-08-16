package com.itheima.jdbc.dao.impl;

import com.itheima.jdbc.dao.IAccountDao;
import com.itheima.jdbc.domain.Account;
import com.itheima.jdbc.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private ConnectionUtils connectionUtils;

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void saveAccount() {
        System.out.println("账户保存成功");
    }

    public List<Account> findAllCount() {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
            //return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void saveAccount(Account account) {
        try{
             runner.update(
                    "insert into account(name,money)values(?,?)",
                        account.getName(),account.getMoney()
                    );
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?,money = ? where id  =?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
             runner.update(
                    "delete from account where id = ?",
                        accountId
                    );
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public Account findAccountByName(String accountName) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ? ",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
