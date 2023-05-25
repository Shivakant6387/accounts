package com.example.Accounts.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {
    private LocalDateTime localDateTime;
    private String message;
    private String details;
}
