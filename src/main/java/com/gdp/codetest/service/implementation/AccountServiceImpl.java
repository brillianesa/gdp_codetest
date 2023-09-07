package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gdp.codetest.dto.RegisterRequest;
import com.gdp.codetest.model.Account;
import com.gdp.codetest.model.Question;
import com.gdp.codetest.model.Score;
import com.gdp.codetest.model.User;
import com.gdp.codetest.repository.AccountRepository;
import com.gdp.codetest.repository.QuestionRepository;
import com.gdp.codetest.repository.ScoreRepository;
import com.gdp.codetest.service.servicelist.AccountServices;
import com.gdp.codetest.service.servicelist.UserServices;

@Service
public class AccountServiceImpl implements AccountServices<Account> {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserServices<User> userServices;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean Save(Account account) {
        try {
            accountRepository.save(account);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Account Get(int id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            accountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean register(RegisterRequest registerRequest) {
        User user = new User();
        user.setFullname(registerRequest.getFullname());
        user.setDateofbirth(registerRequest.getDateofbirth());
        user.setPhonenumber(registerRequest.getPhonenumber());
        user.setGender(registerRequest.getGender());
        user.setAddress(registerRequest.getAddress());
        user.setTest(registerRequest.getTest());

        Boolean resultUser = userServices.Save(user);
        if (resultUser) {
            Account account = new Account();
            Integer account_id = userServices.findIdByPhoneNumber(registerRequest.getPhonenumber());
            account.setAccount_id(account_id);
            account.setEmail(registerRequest.getEmail());
            account.setPassword(passwordEncoder.encode((registerRequest.getPassword())));
            account.setRole(registerRequest.getRole());

            accountRepository.save(account);

            Integer testId = user.getTest().getTest_id();
            List<Question> questions = questionRepository.findByTestId(testId);

            for (Question question : questions) {
                Score score = new Score();
                score.setAccount(account);
                score.setQuestion(question);
                score.setScore(null);
                scoreRepository.save(score);
            }
        }
        return resultUser;
    }

    // @Override
    // public boolean register(RegisterRequest registerRequest, Account account, User user) {
    //     user.setFullname(registerRequest.getFullname());
    //     user.setDateofbirth(registerRequest.getDateofbirth());
    //     user.setPhonenumber(registerRequest.getPhonenumber());
    //     user.setGender(registerRequest.getGender());
    //     user.setAddress(registerRequest.getAddress());
    //     user.setTest(registerRequest.getTest());

    //     Boolean resultUser = userServices.Save(user);
    //     if(resultUser){
    //         Integer account_id = userServices.findIdByPhoneNumber(registerRequest.getPhonenumber());
    //         account.setAccount_id(account_id);
    //         account.setEmail(registerRequest.getEmail());
    //         account.setPassword(passwordEncoder.encode((registerRequest.getPassword())));
    //         account.setRole(registerRequest.getRole());

    //         accountRepository.save(account);
    //     }
    //     return resultUser;
    // }
}
