package com.sukumar.bank_account.accountmanagement.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestAccountDto {

    @NotBlank(message = "name should not be blank")
    private String name;

    @NotNull(message = "balance should not be null")
    @Min(value = 1000, message = "balance should be minimum 1000")
    private Double balance;
}
