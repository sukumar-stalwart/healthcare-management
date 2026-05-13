package com.sukumar.bank_account.accountmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAccountDto {

    private String accNumber;
    private String name;
    private Double balance;
}
