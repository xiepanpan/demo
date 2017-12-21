package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionMapper {
    int update(@Param("money")double money,@Param("id")int id);
}
