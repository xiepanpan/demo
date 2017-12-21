package com.example.demo.controller;

import com.example.demo.bean.Account;
import com.example.demo.service.AccountMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accountmybatis")
public class AccountMybatisController {

    @Autowired
    private AccountMapperService accountMapperService;

//    http://localhost:8082/accountmybatis/list
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountMapperService.findAccountList();
    }

    //http://localhost:8082/accountmybatis/5
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id")int id) {
        return accountMapperService.findAccount(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id")int id, @RequestParam(value = "name",required = true)String name,
                                @RequestParam(value = "money",required = true)double money) {
        int updateValue = accountMapperService.update(name, money, id);
        if (updateValue==1) {
            return "success";
        }else
            return "fail";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id")int id) {
        int deleteValue = accountMapperService.delete(id);
        if (deleteValue==1)
            return "success";
        else
            return "fail";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name")String name,@RequestParam(value = "money")double money) {
        int addValue = accountMapperService.add(name, money);
        if (addValue==1)
            return "success";
        else
            return "fail";
    }
}
