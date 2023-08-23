package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gdp.codetest.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
