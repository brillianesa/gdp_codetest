package com.gdp.codetest.dto;

public class UserSummary {
    private Integer id;
    private String email;
    private String fullname;
    private Integer test_id;

    public Integer getTest_id() {
        return test_id;
    }

    public UserSummary(Integer id, String email, String fullname, Integer test_id) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.test_id = test_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getName() {
        return fullname;
    }

    public void setName(String fullname) {
        this.fullname = fullname;
    }
}
