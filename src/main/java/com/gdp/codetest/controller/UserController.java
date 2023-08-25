package com.gdp.codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdp.codetest.model.Test;
import com.gdp.codetest.model.User;
import com.gdp.codetest.service.servicelist.TestServices;
import com.gdp.codetest.service.servicelist.UserServices;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServices<User> userServices;

    @Autowired
    private TestServices<Test> testServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userServices.getAll());
        return "user/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {

            model.addAttribute("tests", testServices.getAll());
            model.addAttribute("users", userServices.Get(id));
        } else {

            model.addAttribute("tests", testServices.getAll());
            model.addAttribute("users", new User());
        }
        return "user/form";
    }

    @PostMapping("save")
    public String save(User user) {
        Boolean isSaved = userServices.Save(user);
        if (isSaved) {
            return "redirect:/user";
        } else {
            return "user/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = userServices.Delete(id);
        if (isDeleted) {
            // Data berhasil dihapus
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            // Gagal menghapus data
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/user";
    }
}
