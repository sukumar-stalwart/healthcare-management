package com.sukumar.bank_account.accountmanagement.mapper;

import com.sukumar.bank_account.accountmanagement.Dto.RequestAccountDto;
import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import com.sukumar.bank_account.accountmanagement.entity.Account;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

public class Account_Mapper {

    public static Account toEntity(@RequestBody RequestAccountDto req ,String accnum){

        Account acc = new Account();
        acc.setAccNumber(accnum);
        acc.setName(req.getName());
        acc.setBalance(req.getBalance());
        acc.setCreatedDate(LocalDateTime.now());

        return acc ;
    }


    public static ResponseAccountDto toDto(Account acc){
        ResponseAccountDto radto = new ResponseAccountDto();
        radto.setAccNumber(acc.getAccNumber());
        radto.setName(acc.getName());
        radto.setBalance(acc.getBalance());

        return radto ;
    }


}
