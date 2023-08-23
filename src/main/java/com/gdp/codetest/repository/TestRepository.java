package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdp.codetest.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

}
