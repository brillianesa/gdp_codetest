package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.Score;
import com.gdp.codetest.repository.ScoreRepository;
import com.gdp.codetest.service.servicelist.ScoreServices;

@Service
public class ScoreServiceImpl implements ScoreServices<Score> {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Boolean Save(Score score) {
        try {
            scoreRepository.save(score);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Score Get(int id) {
        return scoreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            scoreRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
