package com.gdp.codetest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_test")
public class Test {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer test_id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testdate;

    @OneToMany(mappedBy = "test")
    @JsonIgnore
    private List<User> user;

    @OneToMany(mappedBy = "test")
    @JsonIgnore
    private List<Question> question;

    public Integer getTest_id() {
        return test_id;
    }

    public void setTest_id(Integer test_id) {
        this.test_id = test_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTestdate() {
        return testdate;
    }

    public void setTestdate(Date testdate) {
        this.testdate = testdate;
    }
}
