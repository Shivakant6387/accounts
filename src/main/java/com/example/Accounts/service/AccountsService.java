package com.example.Accounts.service;

import com.example.Accounts.Exception.UserNotFoundException;
import com.example.Accounts.model.Accounts;
import com.example.Accounts.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {
    @Autowired
    private AccountsRepository accountsRepository;
    public List<Accounts> findAllAccounts(){
        return accountsRepository.findAll();
    }
    public Accounts createNewAccount(Accounts accounts){
        return accountsRepository.save(accounts);
    }
    public Optional<Accounts> findByAccountId(int id) throws UserNotFoundException{
        Optional<Accounts> accounts=accountsRepository.findById(id);
       if (accounts.isEmpty())
           throw new UserNotFoundException("Accounts not found exception");
       return accounts;
    }
    public Accounts updateAccount(Accounts updatedAccount) {
        Optional<Accounts> accountOptional = accountsRepository.findById(updatedAccount.getId());

        if (accountOptional.isPresent()) {
            Accounts existingAccount = accountOptional.get();
            existingAccount.setFirstName(updatedAccount.getFirstName());
            existingAccount.setLastName(updatedAccount.getLastName());
            existingAccount.setAccountNumber(updatedAccount.getAccountNumber());
            existingAccount.setBranchName(updatedAccount.getBranchName());
            existingAccount.setPhoneNumber(updatedAccount.getPhoneNumber());
            existingAccount.setAadharNumber(updatedAccount.getAadharNumber());
            return accountsRepository.save(existingAccount);
        } else {
            throw new UserNotFoundException("Account not found with ID: " + updatedAccount.getId());
        }
    }

}
