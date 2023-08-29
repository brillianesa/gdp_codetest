package com.gdp.codetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    @Query(value = "SELECT * FROM tb_tr_score WHERE account_id = ?1", nativeQuery = true)
    public List<Score> findScoreByAccountID(Integer account_id);
}
