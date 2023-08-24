package com.gdp.codetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

}
