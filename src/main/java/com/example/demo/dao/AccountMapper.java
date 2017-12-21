package com.example.demo.dao;

import com.example.demo.bean.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {

    @Insert("insert into account(name,money) values(#{name},#{money})")
    public int add(@Param("name")String name,@Param("money")double money);

    @Update("update account set name= #{name}, money= #{money} where id=#{id}")
    public int update(@Param("name")String name,@Param("money")double money,@Param("id")int id);

    @Delete("delete from account where id=#{id}")
    public int delete(@Param("id") int id);

    @Select("select id,name from account where id=#{id}")
    public Account findAccount(@Param("id")int id);

    @Select("select id,name,money from account")
    List<Account> findAccountList();
}
