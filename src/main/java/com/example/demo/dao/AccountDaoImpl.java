package com.example.demo.dao;

import com.example.demo.bean.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao具体实现类
 *
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
        return jdbcTemplate.update("INSERT INTO account(NAME,money) VALUES(?,?) ",
                account.getName(),account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE account SET NAME =?,money=? WHERE id=?",
                account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM TABLE account WHERE id=?",id);
    }

    @Override
    public Account findAccountById(int id) {
        List<Account> accountList = jdbcTemplate.query("select * from account WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Account.class));
        if (accountList!=null&&accountList.size()>0){
            Account account = accountList.get(0);
            return account;
        }
        return null;
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new Object[]{},
                new BeanPropertyRowMapper<>(Account.class));
        if (accountList!=null&&accountList.size()>0){
            return accountList;
        }
        return null;
    }
}
