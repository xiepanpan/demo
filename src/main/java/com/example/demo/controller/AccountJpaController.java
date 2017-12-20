package com.example.demo.controller;

import com.example.demo.bean.Account;
import com.example.demo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountJpaController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id")int id){
        return accountDao.findOne(id);
    }

    //http://localhost:8082/account/1?name=liudehua&money=32
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id")int id, @RequestParam(value = "name",required = true)String name,
                                @RequestParam(value = "money",required = true)double money){
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Account accountUpdate=accountDao.saveAndFlush(account);
        return accountUpdate.toString();
    }

    //http://localhost:8082/account/?name=mm&money=32
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name")String name,@RequestParam(value = "money")double money) {
        Account account=new Account();
        account.setMoney(money);
        account.setName(name);
        Account accountAdd = accountDao.save(account);
        return accountAdd.toString();
    }
}
