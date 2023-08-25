package com.gdp.codetest.controller.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdp.codetest.handler.Response;
import com.gdp.codetest.model.Account;
import com.gdp.codetest.service.servicelist.AccountServices;

@RestController
@RequestMapping("api")
public class AccountRestController {
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
}
