package com.sukumar.bank_account.transactionhistorymanagement.controller;


import com.sukumar.bank_account.transactionhistorymanagement.dto.TransHistory_ResponseDto;
import com.sukumar.bank_account.transactionhistorymanagement.service.TransHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Trans_HistoryController {


    @Autowired
    private TransHistoryService service ;

    @GetMapping("/account/{accNum}/transaction")
    public ResponseEntity<List<TransHistory_ResponseDto>> getAllTransactions(@PathVariable String accNum){
         List<TransHistory_ResponseDto> trs =service.getAllTransaction(accNum);

       return  ResponseEntity.status(HttpStatus.FOUND).body(trs);
    }


    @GetMapping("/account/{accNum}/type")
    public ResponseEntity<List<TransHistory_ResponseDto>>  getSpecific(@PathVariable String accNum ,@RequestParam String type){
          List<TransHistory_ResponseDto> specific =    service.getSpecificTransactions(accNum,type);
       return    ResponseEntity.status(HttpStatus.FOUND).body(specific);
    }

}
