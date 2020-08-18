package cn.itcast.dao;

import cn.itcast.domian.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//动态代理对象 连接数据库层
@Repository
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Insert(("insert into account(name,money) values(#{name},#{money})"))
    void saveAccount(Account account);

}
