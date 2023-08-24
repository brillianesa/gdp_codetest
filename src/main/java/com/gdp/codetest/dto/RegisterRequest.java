package com.gdp.codetest.dto;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.gdp.codetest.model.Role;

public class RegisterRequest {
    @Id
    private int user_id;
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    private String email;
    private String fullname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateofbirth;
    
    private String gender;
    private Boolean iscompleted;
    private String address;
    private String phonenumber;
    private String password;
    private Role role;

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Boolean getIscompleted() {
        return iscompleted;
    }
    public void setIscompleted(Boolean iscompleted) {
        this.iscompleted = iscompleted;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public Date getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
