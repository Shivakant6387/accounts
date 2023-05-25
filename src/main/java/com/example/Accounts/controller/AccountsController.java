package com.example.Accounts.controller;

import com.example.Accounts.model.Accounts;
import com.example.Accounts.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountsController {
    @Autowired
    private AccountsService accountsService;
    @GetMapping("/accounts")
    public String get(){
        return "Welcome to new user";
    }
    @GetMapping("/getAllDetails")
    public ResponseEntity<List<Accounts>> getAllAccountsDetails(){
        return ResponseEntity.ok(accountsService.findAllAccounts());
    }
}
