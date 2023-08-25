package com.gdp.codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdp.codetest.model.Account;
import com.gdp.codetest.model.Role;
import com.gdp.codetest.service.servicelist.AccountServices;
import com.gdp.codetest.service.servicelist.RoleServices;

@CrossOrigin
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountServices<Account> accountServices;

    @Autowired
    private RoleServices<Role> roleServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("accounts", accountServices.getAll());
        return "account/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("roles", roleServices.getAll());
            model.addAttribute("accounts", accountServices.Get(id));
        } else {
            model.addAttribute("roles", roleServices.getAll());
            model.addAttribute("accounts", new Account());
        }
        return "account/form";
    }

    @PostMapping("save")
    public String save(Account account) {
        Boolean isSaved = accountServices.Save(account);
        if (isSaved) {
            return "redirect:/account";
        } else {
            return "account/form";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        boolean isDeleted = accountServices.Delete(id);
        if (isDeleted) {
            System.out.println("Data with ID " + id + " has been deleted.");
        } else {
            System.out.println("Failed to delete data with ID " + id);
        }
        return "redirect:/account";
    }

}
