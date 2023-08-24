package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
