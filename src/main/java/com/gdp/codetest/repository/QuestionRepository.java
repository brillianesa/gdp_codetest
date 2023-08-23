package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdp.codetest.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
