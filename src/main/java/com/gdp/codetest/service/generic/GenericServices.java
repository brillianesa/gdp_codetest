package com.gdp.codetest.service.generic;

import java.util.List;

public interface GenericServices<T> {
    public Boolean Save(T model);

    public T Get(int id);

    public List<T> getAll();

    public Boolean Delete(int id);
}
