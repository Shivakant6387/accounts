package com.example.Accounts.service;

import com.example.Accounts.model.Accounts;
import com.example.Accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;
    public List<Accounts> findAllAccounts(){
        return accountsRepository.findAll();
    }
}
