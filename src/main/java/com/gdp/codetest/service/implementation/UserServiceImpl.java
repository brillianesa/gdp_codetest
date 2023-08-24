package com.gdp.codetest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.User;
import com.gdp.codetest.repository.UserRepository;
import com.gdp.codetest.service.servicelist.UserServices;

@Service
public class UserServiceImpl implements UserServices<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean Save(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public User Get(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Boolean Delete(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
