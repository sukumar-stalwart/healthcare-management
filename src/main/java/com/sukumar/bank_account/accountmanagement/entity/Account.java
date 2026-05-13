package com.sukumar.bank_account.accountmanagement.entity;

import com.sukumar.bank_account.transactionhistorymanagement.entity.TransactionHistoryEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String accNumber;
    private String name ;
    private Double balance ;
    private LocalDateTime createdDate ;


    @OneToMany(mappedBy = "account")
    List<TransactionHistoryEntity> transactions ;

}
