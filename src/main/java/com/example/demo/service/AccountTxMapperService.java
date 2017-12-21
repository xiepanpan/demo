package com.example.demo.service;

import com.example.demo.dao.AccountTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountTxMapperService {

    @Autowired
    private AccountTransactionMapper accountTransactionMapper;

    //加入注解后 出现错误自动回滚
    @Transactional
    public void transfer() {
        //用户1减10块 用户2加十块
        accountTransactionMapper.update(90,1);
        int i=1/0;
        accountTransactionMapper.update(110,2);
    }
}
