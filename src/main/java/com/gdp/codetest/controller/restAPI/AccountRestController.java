package com.gdp.codetest.controller.restAPI;

import com.gdp.codetest.dto.LoginRequest;
import com.gdp.codetest.dto.RegisterRequest;
import com.gdp.codetest.handler.Response;
import com.gdp.codetest.model.Account;
import com.gdp.codetest.model.Question;
import com.gdp.codetest.service.servicelist.AccountServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("account")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", accountServices.getAll());
    }

    @GetMapping("account/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", accountServices.Get(id));
    }

    @PostMapping("account")
    public ResponseEntity<Object> post(@RequestBody Account account) {
        accountServices.Save(account);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("account/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        accountServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }

    @PostMapping("account/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        if (authentication.isAuthenticated()) {
            return Response.generate(HttpStatus.OK, "Signed in");
        }
        return Response.generate(HttpStatus.UNAUTHORIZED, "Data failed to login");
    }

    @PostMapping("account/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest) {
        Boolean result = accountServices.register(registerRequest);
        if (result) {
            return Response.generate(HttpStatus.OK, "Data has been saved");
        }
        return Response.generate(HttpStatus.OK, "Data failed to save");
    }
}