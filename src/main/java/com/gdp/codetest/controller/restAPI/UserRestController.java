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
import com.gdp.codetest.model.User;
import com.gdp.codetest.service.servicelist.UserServices;

@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private UserServices<User> userServices;

    @GetMapping("user")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", userServices.getAll());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", userServices.Get(id));
    }

    @PostMapping("user")
    public ResponseEntity<Object> post(@RequestBody User user) {
        userServices.Save(user);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        userServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
