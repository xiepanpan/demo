package com.example.demo.service;

import com.example.demo.bean.Account;
import com.example.demo.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public int add(Account account) {
        return iAccountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return iAccountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return iAccountDao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return iAccountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return iAccountDao.findAccountList();
    }
}
