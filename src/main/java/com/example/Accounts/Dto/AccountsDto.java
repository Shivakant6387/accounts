package com.example.Accounts.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
public class AccountsDto {
    private String firstName;
    private String lastName;
    private String branchName;
    private BigInteger accountNumber;
    private int phoneNumber;
    private String aadharNumber;
}
