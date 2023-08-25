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
import com.gdp.codetest.model.Score;
import com.gdp.codetest.service.servicelist.ScoreServices;

@RestController
@RequestMapping("api")
public class ScoreRestController {
    @Autowired
    private ScoreServices<Score> scoreServices;

    @GetMapping("score")
    public ResponseEntity<Object> get() {
        return Response.generate(HttpStatus.OK, "Data retrieved", scoreServices.getAll());
    }

    @GetMapping("score/{id}")
    public ResponseEntity<Object> get(@PathVariable(required = true) Integer id) {
        return Response.generate(HttpStatus.OK, "Data retrieved", scoreServices.Get(id));
    }

    @PostMapping("score")
    public ResponseEntity<Object> post(@RequestBody Score score) {
        scoreServices.Save(score);
        return Response.generate(HttpStatus.OK, "Data saved");
    }

    @DeleteMapping("score/{id}")
    public ResponseEntity<Object> delete(@PathVariable(required = true) Integer id) {
        scoreServices.Delete(id);
        return Response.generate(HttpStatus.OK, "Data deleted");
    }
}
