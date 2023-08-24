package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
