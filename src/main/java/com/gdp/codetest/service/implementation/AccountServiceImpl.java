package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.Account;
import com.gdp.codetest.repository.AccountRepository;
import com.gdp.codetest.service.servicelist.AccountServices;

@Service
public class AccountServiceImpl implements AccountServices<Account> {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Boolean Save(Account account) {
        try {
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            return false;
        }
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
