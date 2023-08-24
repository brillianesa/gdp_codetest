package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
