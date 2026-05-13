package com.sukumar.bank_account.accountmanagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteResponseDto {

    private LocalDateTime timeStamp ;
    private Integer status ;
    private String message ;
    private String path ;




}
