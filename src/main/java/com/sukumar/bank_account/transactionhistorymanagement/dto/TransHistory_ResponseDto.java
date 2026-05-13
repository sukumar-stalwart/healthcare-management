package com.sukumar.bank_account.transactionhistorymanagement.dto;

import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import com.sukumar.bank_account.accountmanagement.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransHistory_ResponseDto {

    private String accNum ;
    private String type ;
    private double amount ;
    private LocalDateTime dateTime ;
    private String message ;

    private ResponseAccountDto account;
}
