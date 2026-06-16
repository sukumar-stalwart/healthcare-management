package com.sukumar.bank_account.accountmanagement.bank_controller;


import com.sukumar.bank_account.accountmanagement.Dto.DeleteResponseDto;
import com.sukumar.bank_account.accountmanagement.Dto.RequestAccountDto;
import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import com.sukumar.bank_account.accountmanagement.bank_service.BankServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class Bank_Controller {


    @Autowired
    private BankServiceInterface service ;


   /* @PostMapping("/createaccount")
    public ResponseEntity<ResponseAccountDto> create(@Valid @RequestBody RequestAccountDto req){
        ResponseAccountDto res = service.createNewAccount(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }*/


    // we use ResponseEntity to know the api status using httpstatuscode

    @GetMapping("/getaccount/{id}")
    public ResponseEntity<ResponseAccountDto> getAccDetails(@PathVariable String id){
          ResponseAccountDto accDetail = service.getAccountDetails(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(accDetail);
    }


    @PutMapping("/updatecccount/{id}")
    public ResponseEntity<ResponseAccountDto> updateAccDetails(@PathVariable String id ,@RequestBody RequestAccountDto req){
        ResponseAccountDto acc = service.updateAccountInfo(id ,req);

         return ResponseEntity.status(HttpStatus.ACCEPTED).body(acc);
    }


    @DeleteMapping("/deleteaccount/{id}")
    public ResponseEntity<DeleteResponseDto> deleteAccount(@PathVariable String id ){
           service.deleteAccountInfo(id);
        DeleteResponseDto drs = DeleteResponseDto.builder().timeStamp(LocalDateTime.now()).status(HttpStatus.ACCEPTED.value())
                .message("Account Deleted Successfully").path("/deleteaccount" +id ).build();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(drs);
    }

}
