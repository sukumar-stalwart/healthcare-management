package com.sukumar.bank_account.transactionhistorymanagement.service;

import com.sukumar.bank_account.transactionhistorymanagement.dto.TransHistory_ResponseDto;
import com.sukumar.bank_account.transactionhistorymanagement.entity.TransactionHistoryEntity;
import com.sukumar.bank_account.transactionhistorymanagement.mapper.TransHistory_Mapper;
import com.sukumar.bank_account.transactionhistorymanagement.repository.Trans_HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransHistoryService {

        @Autowired
        private Trans_HistoryRepository historyRepo ;

        public List<TransHistory_ResponseDto> getAllTransaction(String accNum) {

            List<TransactionHistoryEntity> transactions = historyRepo.findByAccount_AccNumber(accNum);

            return transactions.stream().map(TransHistory_Mapper::toDto).toList();

        }

    public List<TransHistory_ResponseDto> getSpecificTransactions(String accNum, String type) {

        List<TransactionHistoryEntity> thr =  historyRepo.findByAccount_AccNumberAndType(accNum, type);

       return thr.stream().map(TransHistory_Mapper::toDto).toList();
    }
}

