package com.example.BankingApp.AccountController;

import com.example.BankingApp.AccountService.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/transfer")
    public String transfer(@RequestParam  String fromId,
                           @RequestParam String toId,
                           @RequestParam double amount)
    {
        try
        {
            service.transferMoney(fromId, toId, amount);
            return "Transfer Successfully";


        }catch (Exception e)
        {
            return "Transfer Failed" + e.getMessage();

        }


    }
}
