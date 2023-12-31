package com.gdp.codetest.service.servicelist;

import com.gdp.codetest.model.User;
import com.gdp.codetest.service.generic.GenericServices;

public interface UserServices<T> extends GenericServices<T> {
    public Integer findIdByPhoneNumber(String phonenumber);

}
