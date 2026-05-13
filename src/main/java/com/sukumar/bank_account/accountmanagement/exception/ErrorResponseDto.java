package com.sukumar.bank_account.accountmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {

    private LocalDateTime timeStamp ;
    private Integer status ;
    private String message ;
    private String path ;
}
