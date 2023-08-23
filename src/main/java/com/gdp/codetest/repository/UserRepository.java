package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdp.codetest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
