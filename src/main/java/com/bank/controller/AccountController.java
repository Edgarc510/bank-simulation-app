package com.bank.controller;


import com.bank.enums.AccountType;
import com.bank.model.Account;
import com.bank.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
    Write a method to return index.html
     */

    @GetMapping("/index")
    public String getIndex(Model model){

        model.addAttribute("accountList", accountService.listAllAccount() );

        return "account/index";
    }
    @GetMapping("/create-form")
    public String createAccount(Model model){

//        model.addAttribute("account", new Account());
        model.addAttribute("account", Account.builder().build());
        model.addAttribute("accountTypes", AccountType.values());

        return "account/create-account";
    }
    @PostMapping("create")
    public String createAccount(@ModelAttribute("account") Account account){

        accountService.createNewAccount
                (account.getBalance(),new Date(),account.getAccountType(),account.getUserID());
        return "redirect:/index";
    }


}
