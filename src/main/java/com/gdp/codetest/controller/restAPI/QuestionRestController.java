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
import com.gdp.codetest.model.Question;
import com.gdp.codetest.service.servicelist.QuestionServices;

@RestController
@RequestMapping("api")
public class QuestionRestController {
    @Autowired
    private QuestionServices<Question> questionServices;

    @GetMapping("question")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", questionServices.getAll());
    }

    @GetMapping("question/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", questionServices.Get(id));
    }

    @PostMapping("question")
    public ResponseEntity<Object> post(@RequestBody Question question) {
        questionServices.Save(question);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("question/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        questionServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
