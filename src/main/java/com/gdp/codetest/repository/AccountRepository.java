package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdp.codetest.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
