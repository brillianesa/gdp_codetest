package com.gdp.codetest.controller;

import javax.swing.plaf.synth.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdp.codetest.model.Test;
import com.gdp.codetest.service.servicelist.TestServices;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestServices<Test> testServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("tests", testServices.getAll());
        return "test/index";

    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("tests", testServices.Get(id));
        } else {
            model.addAttribute("tests", new Test());
        }
        return "/test/form";
    }

    @PostMapping("save")
    public String save(Test test) {
        Boolean isSaved = testServices.Save(test);
        if (isSaved) {
            return "redirect:/test";
        } else {
            return "test/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = testServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/test";
    }
}
