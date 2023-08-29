package com.gdp.codetest.service.servicelist;

import java.util.List;

import com.gdp.codetest.model.Question;
import com.gdp.codetest.service.generic.GenericServices;

public interface QuestionServices<T> extends GenericServices<T> {
    public List<Question> findQuestionByTest(Integer test_id);
}
