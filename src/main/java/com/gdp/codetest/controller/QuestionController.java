package com.gdp.codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdp.codetest.model.Question;
import com.gdp.codetest.model.Test;
import com.gdp.codetest.service.servicelist.QuestionServices;
import com.gdp.codetest.service.servicelist.TestServices;

@Controller
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionServices<Question> questionServices;

    @Autowired
    private TestServices<Test> testServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("questions", questionServices.getAll());
        return "question/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("tests", testServices.getAll());
            model.addAttribute("questions", questionServices.Get(id));
        } else {
            model.addAttribute("tests", testServices.getAll());
            model.addAttribute("questions", new Question());
        }
        return "question/form";
    }

    @PostMapping("save")
    public String save(Question question) {
        Boolean isSaved = questionServices.Save(question);
        if (isSaved) {
            return "redirect:/question";
        } else {
            return "question/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = questionServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/department";
    }
}