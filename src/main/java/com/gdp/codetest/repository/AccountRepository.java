package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
