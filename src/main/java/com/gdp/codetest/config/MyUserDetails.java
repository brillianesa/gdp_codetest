package com.gdp.codetest.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gdp.codetest.model.Account;
import com.gdp.codetest.repository.AccountRepository;

@Service
public class MyUserDetails implements UserDetails, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    private String username;
    private String password;
    private GrantedAuthority authority;
    private Integer id;
    private String fullname;
    private Integer test_id;

    public Integer getTest_id() {
        return test_id;
    }

    public String getFullname() {
        return fullname;
    }

    public MyUserDetails() {}

    public MyUserDetails(Account account) {
        this.username = account.getEmail();
        this.password = account.getPassword();
        this.authority = new SimpleGrantedAuthority(account.getRole().getName());
        this.id = account.getAccount_id();
        this.fullname = account.getUser().getFullname();
        this.test_id = account.getUser().getTest().getTest_id();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(authority);
        return grantedAuthority;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account data = accountRepository.login(username);
        return new MyUserDetails(data);
    }
    

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public GrantedAuthority getAuthority() {
        return authority;
    }

    public Integer getId() {
        return id;
    }
}