package com.sukumar.bank_account.transactionhistorymanagement.repository;

import com.sukumar.bank_account.transactionhistorymanagement.entity.TransactionHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Trans_HistoryRepository extends JpaRepository<TransactionHistoryEntity,Long>{

    List<TransactionHistoryEntity> findByAccount_AccNumber(String AccNum);

    List<TransactionHistoryEntity> findByAccount_AccNumberAndType(String AccNum,String type);



}
