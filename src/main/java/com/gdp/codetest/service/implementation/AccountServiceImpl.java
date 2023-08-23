package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdp.codetest.model.Account;
import com.gdp.codetest.repository.AccountRepository;
import com.gdp.codetest.service.servicelist.AccountServices;

public class AccountServiceImpl implements AccountServices<Account> {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Boolean Save(Account account) {
        return accountRepository.findById(account.getAccount_id()).isPresent();
    }

    @Override
    public Account Get(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
