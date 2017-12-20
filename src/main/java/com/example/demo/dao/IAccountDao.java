package com.example.demo.dao;

import com.example.demo.bean.Account;

import java.util.List;

public interface IAccountDao {

    public int add(Account account);

    public int update(Account account);

    public int delete(int id);

    public Account findAccountById(int id);

    public List<Account> findAccountList();

}
