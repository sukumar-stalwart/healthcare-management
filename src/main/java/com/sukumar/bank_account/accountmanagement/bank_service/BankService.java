package com.sukumar.bank_account.accountmanagement.bank_service;

import com.sukumar.bank_account.accountmanagement.Dto.RequestAccountDto;
import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import com.sukumar.bank_account.accountmanagement.entity.Account;
import com.sukumar.bank_account.accountmanagement.exception.AccountNotFoundException;
import com.sukumar.bank_account.accountmanagement.mapper.Account_Mapper;
import com.sukumar.bank_account.accountmanagement.repository.BankRepository;
import com.sukumar.bank_account.accountmanagement.util.GenerateAccountNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService implements BankServiceInterface{

    @Autowired
    private BankRepository bankRepo;

    @Override
    public ResponseAccountDto createNewAccount(RequestAccountDto req) {

            String accnum ;
        do {
             accnum = GenerateAccountNumber.generateUniqueAccNum();
           }
        while(bankRepo.existsById(accnum));

      Account account =   Account_Mapper.toEntity(req,accnum);
      bankRepo.save(account);

     ResponseAccountDto responseAccountDto = Account_Mapper.toDto(account);
     return  responseAccountDto ;
         }



    @Override
    public ResponseAccountDto getAccountDetails(String id) {
           Account acc = bankRepo.findById(id).orElseThrow(()-> new AccountNotFoundException("Account not found"));

         ResponseAccountDto accDetail =  Account_Mapper.toDto(acc);
         return  accDetail ;
    }

    @Override
    public ResponseAccountDto updateAccountInfo(String id ,RequestAccountDto req) {
           Account acc =  bankRepo.findById(id).orElseThrow(()-> new AccountNotFoundException("Account not found")) ;
           acc.setName(req.getName());
           acc.setBalance(req.getBalance());
           bankRepo.save(acc);

             ResponseAccountDto updatedAcc =  Account_Mapper.toDto(acc);

           return updatedAcc;
    }

    @Override
    public void deleteAccountInfo(String id) {
        Account acc = bankRepo.findById(id).orElseThrow(()-> new AccountNotFoundException("Account Not Found"));

        bankRepo.delete(acc);

    }
}
