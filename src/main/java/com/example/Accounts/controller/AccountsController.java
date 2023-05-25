package com.example.Accounts.controller;

import com.example.Accounts.Exception.UserNotFoundException;
import com.example.Accounts.model.Accounts;
import com.example.Accounts.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PostMapping("/createNewAccount")
    public ResponseEntity<Accounts> postNewAccounts(@RequestBody Accounts accounts){
        return ResponseEntity.ok(accountsService.createNewAccount(accounts));
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Optional<Accounts>> getSingleAccountsId(@PathVariable int id) throws UserNotFoundException {
      return ResponseEntity.ok(accountsService.findByAccountId(id));
    }
    @PutMapping("/update")
    public ResponseEntity<Accounts>update(@RequestBody Accounts accounts){
        return ResponseEntity.ok(accountsService.updateAccount(accounts));
    }
}
