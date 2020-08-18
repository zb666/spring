package cn.itcast.dao;

import cn.itcast.domian.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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

    @Select("select * from where id = #{id}")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "money",property = "money")
    })
    Account findAccountById(Integer userId);

    @Select("select * from account where name like #{name}")
    List<Account> findAccountsByName(String name);

}
