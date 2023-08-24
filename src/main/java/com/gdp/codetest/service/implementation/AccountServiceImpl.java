package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.Account;
import com.gdp.codetest.model.User;
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

    //  @Override
    // public boolean register(RegisterRequest registerRequest) {
    //     User user = new User();
    //     user.setFullName(registerRequest.getFullName());
    //     user.setDateOfBirth(register(registerRequest));

    //     Boolean resultUser = userService.Save(user);
    //     if(resultUser){
    //         Integer user_id = userService.findIdByEmail(registerRequest.getEmail());
    //         User user = new User();
    //         user.setUser_id(user_id);
    //         user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

    //         Boolean resultUser = userService.Save(user);
    //         return resultUser;
    //     }

    //     return resultUser;
    // }
}
