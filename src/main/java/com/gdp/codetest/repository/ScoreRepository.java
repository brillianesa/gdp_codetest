package com.gdp.codetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    @Query(value = "SELECT *\n" + //
            "FROM \n" + //
            "(SELECT s.score_id, u.user_id, q.question_id, q.questionDetail, q.image, s.useranswer, s.score \n" + //
            "FROM tb_tr_question q \n" + //
            "INNER JOIN tb_tr_test t ON q.test_id = t.test_id \n" + //
            "INNER JOIN tb_m_user u ON t.test_id = u.test_id \n" + //
            "LEFT JOIN tb_tr_score s ON q.question_id = s.question_id AND u.user_id = s.account_id ) as a\n" + //
            "WHERE user_id = ?1", nativeQuery = true)
    public List<Score> findScoreByAccountID(Integer account_id);
}
