package com.gdp.codetest.service.servicelist;

import com.gdp.codetest.dto.RegisterRequest;
import com.gdp.codetest.service.generic.GenericServices;

public interface AccountServices<T> extends GenericServices<T> {
    public boolean register(RegisterRequest registerRequest);
}
