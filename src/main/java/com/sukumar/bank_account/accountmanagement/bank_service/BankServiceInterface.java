package com.sukumar.bank_account.accountmanagement.bank_service;

import com.sukumar.bank_account.accountmanagement.Dto.RequestAccountDto;
import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import jakarta.validation.Valid;

public interface BankServiceInterface {
    ResponseAccountDto createNewAccount(@Valid RequestAccountDto req);

    ResponseAccountDto getAccountDetails(String id);

    ResponseAccountDto updateAccountInfo(String id ,RequestAccountDto req);

    void deleteAccountInfo(String id);
}
