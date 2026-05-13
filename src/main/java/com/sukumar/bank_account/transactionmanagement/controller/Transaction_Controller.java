package com.sukumar.bank_account.transactionmanagement.controller;


import com.sukumar.bank_account.transactionhistorymanagement.dto.TransHistory_ResponseDto;
import com.sukumar.bank_account.transactionmanagement.service.Transaction_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Transaction_Controller {


    @Autowired
    private Transaction_Service service ;

    @PostMapping("/account/{accNum}/deposit")
    public TransHistory_ResponseDto deposit(@PathVariable String accNum , @RequestParam double amount){
            return  service.depositAmount(accNum ,amount);

    }

   @PostMapping("/account/{accNum}/withdraw")
    public TransHistory_ResponseDto withdrawAmount(@PathVariable String accNum ,@RequestParam double amount){
             return  service.withdrawMoney(accNum,amount);
   }


   @PostMapping("transfer")
    public TransHistory_ResponseDto transferAmount(@RequestParam String fromId , @RequestParam String toId, @RequestParam double amount){
                return     service.transferMoney(fromId ,toId,amount);
   }


}
