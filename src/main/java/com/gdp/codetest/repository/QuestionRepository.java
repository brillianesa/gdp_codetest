package com.gdp.codetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gdp.codetest.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT * FROM tb_tr_question WHERE test_id=?1", nativeQuery = true)
    public List<Question> findQuestionByTest(Integer test_id);
}
