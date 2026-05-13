package com.sukumar.bank_account.transactionmanagement.service;

import com.sukumar.bank_account.accountmanagement.entity.Account;
import com.sukumar.bank_account.transactionhistorymanagement.dto.TransHistory_ResponseDto;
import com.sukumar.bank_account.transactionhistorymanagement.entity.TransactionHistoryEntity;

public interface TransactionService_Interface {
    TransHistory_ResponseDto depositAmount(String accNum, double amount);

    TransHistory_ResponseDto withdrawMoney(String accNum, double amount);

    TransHistory_ResponseDto transferMoney(String fromId, String toId, double amount);

      }
