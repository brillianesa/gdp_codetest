package com.gdp.codetest.controller.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdp.codetest.handler.Response;
import com.gdp.codetest.model.Test;
import com.gdp.codetest.service.servicelist.TestServices;

@CrossOrigin
@RestController
@RequestMapping("api")
public class TestRestController {
    @Autowired
    private TestServices<Test> testServices;

    @GetMapping("test")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", testServices.getAll());
    }

    @GetMapping("test/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", testServices.Get(id));
    }

    @PostMapping("test")
    public ResponseEntity<Object> post(@RequestBody Test test) {
        testServices.Save(test);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("test/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        testServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
