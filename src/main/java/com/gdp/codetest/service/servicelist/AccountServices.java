package com.gdp.codetest.service.servicelist;

import com.gdp.codetest.dto.RegisterRequest;
import com.gdp.codetest.model.Account;
import com.gdp.codetest.model.User;
import com.gdp.codetest.service.generic.GenericServices;

public interface AccountServices<T> extends GenericServices<T> {
    public boolean register(RegisterRequest registerRequest);
    // public boolean register(RegisterRequest registerRequest, Account account, User user);
}
