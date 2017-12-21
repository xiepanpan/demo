package com.example.demo.controller;

import com.example.demo.dao.AccountTransactionMapper;
import com.example.demo.service.AccountMapperService;
import com.example.demo.service.AccountTxMapperService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@MapperScan("com.example.demo.dao")//扫描dao
public class AccountTxController {

    @Autowired
    private AccountTxMapperService accountTxMapperService;

    @RequestMapping(value = "transfer",method = RequestMethod.GET)
    public void transfer(){
        accountTxMapperService.transfer();
    }
}
