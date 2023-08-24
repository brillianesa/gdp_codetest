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

import com.gdp.codetest.model.Account;
import com.gdp.codetest.model.Question;
import com.gdp.codetest.model.Score;
import com.gdp.codetest.service.servicelist.AccountServices;
import com.gdp.codetest.service.servicelist.QuestionServices;
import com.gdp.codetest.service.servicelist.ScoreServices;

@Controller
@RequestMapping("score")
public class ScoreController {
    @Autowired
    private ScoreServices<Score> scoreServices;

    @Autowired
    private AccountServices<Account> accountServices;

    @Autowired
    private QuestionServices<Question> questionServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("scores", scoreServices.getAll());
        return "score/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("accounts", accountServices.getAll());
            model.addAttribute("questions", questionServices.getAll());
            model.addAttribute("scores", scoreServices.Get(id));
        } else {
            model.addAttribute("accounts", accountServices.getAll());
            model.addAttribute("questions", questionServices.getAll());
            model.addAttribute("scores", new Score());
        }
        return "score/form";
    }

    @PostMapping("save")
    public String save(Score score) {
        Boolean isSaved = scoreServices.Save(score);
        if (isSaved) {
            return "redirect:/score";
        } else {
            return "score/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = scoreServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/score";
    }
}
