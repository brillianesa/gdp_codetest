package com.gdp.codetest.controller.restAPI;

import com.gdp.codetest.dto.LoginRequest;
import com.gdp.codetest.dto.RegisterRequest;
import com.gdp.codetest.handler.Response;
import com.gdp.codetest.model.Account;
import com.gdp.codetest.service.servicelist.AccountServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api") 
public class AccountRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountServices<Account> accountServices;


    @PostMapping("account/login") 
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            return Response.generate(HttpStatus.OK, "account has been login");
        }
        return Response.generate(HttpStatus.UNAUTHORIZED, "data failed to login");
    }

    @PostMapping("account/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest) {
        Boolean result = accountServices.register(registerRequest);
        if (result) {
             return Response.generate(HttpStatus.OK, "data has been saved");
        }
        return Response.generate(HttpStatus.OK, "data failed to save");
    }
}