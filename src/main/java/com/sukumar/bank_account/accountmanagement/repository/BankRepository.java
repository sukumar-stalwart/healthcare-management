package com.sukumar.bank_account.accountmanagement.repository;

import com.sukumar.bank_account.accountmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Account,String> {
}
