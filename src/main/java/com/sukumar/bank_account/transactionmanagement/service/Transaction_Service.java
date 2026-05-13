package com.sukumar.bank_account.transactionmanagement.service;

import com.sukumar.bank_account.accountmanagement.entity.Account;
import com.sukumar.bank_account.accountmanagement.exception.AccountNotFoundException;
import com.sukumar.bank_account.accountmanagement.repository.BankRepository;
import com.sukumar.bank_account.transactionhistorymanagement.dto.TransHistory_ResponseDto;
import com.sukumar.bank_account.transactionhistorymanagement.entity.TransactionHistoryEntity;
import com.sukumar.bank_account.transactionhistorymanagement.mapper.TransHistory_Mapper;
import com.sukumar.bank_account.transactionhistorymanagement.repository.Trans_HistoryRepository;
import com.sukumar.bank_account.transactionmanagement.exception.InsufficientBalanceException;
import com.sukumar.bank_account.transactionmanagement.exception.InvalidAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Transaction_Service implements TransactionService_Interface {


    @Autowired
    private BankRepository bankRepo ;

    @Autowired
    private Trans_HistoryRepository transHistoryRepository ;

    private TransactionHistoryEntity saveHistory(Account acc , String type , double amount , String message){

        TransactionHistoryEntity trh = new TransactionHistoryEntity();

        trh.setAccount(acc);
        trh.setType(type);
        trh.setAmount(amount);
        trh.setMessage(message);
        trh.setDateTime(LocalDateTime.now());

      return transHistoryRepository.save(trh);


    }


    @Override
    public TransHistory_ResponseDto depositAmount(String accNum, double amount){
        Account acc = bankRepo.findById(accNum).orElseThrow(()-> new RuntimeException("Account Not found"));

            if(amount < 0){
                throw new InvalidAmountException("Amount should not be negative");
            }
           double newBalance = acc.getBalance() + amount ;
           acc.setBalance(newBalance);
           bankRepo.save(acc);


           TransactionHistoryEntity th = saveHistory(acc,"deposit",amount,"Deposited Successfully");

            return  TransHistory_Mapper.toDto(th);
    }


    @Override
    public TransHistory_ResponseDto withdrawMoney(String accNum, double amount) {

        Account acc = bankRepo.findById(accNum).orElseThrow(()-> new AccountNotFoundException("Account Not Found"));

        double accBalance = acc.getBalance();

        if(amount > accBalance){
            throw new InsufficientBalanceException("Balance is Insufficient");
        }

        if(amount < 0){
            throw new InvalidAmountException("Amount should not be negative");
        }


         double newBalance =  accBalance- amount ;
         acc.setBalance(newBalance);
         bankRepo.save(acc);

         TransactionHistoryEntity th = saveHistory(acc,"Withdraw",amount,"Withdrawl Successfully");
                   return    TransHistory_Mapper.toDto(th);
    }



    @Override
    public TransHistory_ResponseDto transferMoney(String fromId, String toId, double amount) {

       Account sender =  bankRepo.findById(fromId).orElseThrow(()-> new AccountNotFoundException("Account not found"));

        Account receiver =  bankRepo.findById(toId).orElseThrow(()-> new AccountNotFoundException("Account not found"));

        double senderUpdatedBalance = sender.getBalance() - amount ;
        sender.setBalance(senderUpdatedBalance);
        bankRepo.save(sender) ;


        double receiverUpdatedBalance = receiver.getBalance() + amount ;
        receiver.setBalance(receiverUpdatedBalance);
        bankRepo.save(receiver);

               TransactionHistoryEntity th =  saveHistory(sender,"transfer",amount,"transferred Successfully");

          return TransHistory_Mapper.toDto(th);
    }
}
