package com.example.demo.dao;

import com.example.demo.bean.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
public interface IAccountDao {

    public int add(Account account);

    public int update(Account account);

    public int delete(int id);

    public Account findAccountById(int id);

    public List<Account> findAccountList();

}
