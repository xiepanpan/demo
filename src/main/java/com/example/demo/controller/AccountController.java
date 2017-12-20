package com.example.demo.controller;

import com.example.demo.bean.Account;
import com.example.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService iAccountService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return iAccountService.findAccountList();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id){
        return iAccountService.findAccountById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id")int id, @RequestParam(value = "name",required = true)String name,
                                @RequestParam(value = "money",required = true)double money){
        Account account =new Account();
        account.setId(id);
        account.setMoney(money);
        account.setName(name);
        int updateValue = iAccountService.update(account);
        if (updateValue==1){
            return account.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name")String name,@RequestParam(value = "money")double money){
        Account account=new Account();
        account.setName(name);
        account.setMoney(money);
        int addValue = iAccountService.add(account);
        if (addValue==1){
            return account.toString();
        }else{
            return "fail";
        }
    }

}
