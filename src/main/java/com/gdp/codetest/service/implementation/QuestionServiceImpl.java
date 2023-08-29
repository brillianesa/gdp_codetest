package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.Question;
import com.gdp.codetest.repository.QuestionRepository;
import com.gdp.codetest.service.servicelist.QuestionServices;

@Service
public class QuestionServiceImpl implements QuestionServices<Question> {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Boolean Save(Question question) {
        try {
            questionRepository.save(question);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Question Get(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            questionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}