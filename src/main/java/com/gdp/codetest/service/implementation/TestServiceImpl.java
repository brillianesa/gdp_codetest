package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.Test;
import com.gdp.codetest.repository.TestRepository;
import com.gdp.codetest.service.servicelist.TestServices;

@Service
public class TestServiceImpl implements TestServices<Test> {
    private final TestRepository testRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Boolean Save(Test test) {
        try {
            testRepository.save(test);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Test Get(int id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            testRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
