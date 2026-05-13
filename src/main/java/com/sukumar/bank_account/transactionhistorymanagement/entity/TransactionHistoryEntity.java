package com.sukumar.bank_account.transactionhistorymanagement.entity;


import com.sukumar.bank_account.accountmanagement.Dto.ResponseAccountDto;
import com.sukumar.bank_account.accountmanagement.entity.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistoryEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long transactionId ;
    private String type ;
    private double amount ;
    private LocalDateTime dateTime ;
    private String message ;


    @JoinColumn(name ="accNumber")
    @ManyToOne
    private Account account ;


}
