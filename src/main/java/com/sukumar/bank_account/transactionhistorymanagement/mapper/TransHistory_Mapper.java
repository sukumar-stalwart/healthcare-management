package com.sukumar.bank_account.transactionhistorymanagement.mapper;

import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import com.sukumar.bank_account.accountmanagement.entity.Account;
import com.sukumar.bank_account.accountmanagement.mapper.Account_Mapper;
import com.sukumar.bank_account.transactionhistorymanagement.dto.TransHistory_ResponseDto;
import com.sukumar.bank_account.transactionhistorymanagement.entity.TransactionHistoryEntity;

import java.time.LocalDateTime;

public class TransHistory_Mapper {




    public static TransHistory_ResponseDto toDto(TransactionHistoryEntity trs){

        TransHistory_ResponseDto trso = new TransHistory_ResponseDto();

        trso.setType(trs.getType());
        trso.setAmount(trs.getAmount());
        trso.setMessage(trs.getMessage());
        trso.setDateTime(trs.getDateTime());

        trso.setAccNum(trs.getAccount().getAccNumber());
      ResponseAccountDto acc = Account_Mapper.toDto(trs.getAccount());
        trso.setAccount(acc);

         return trso ;
    }

}
