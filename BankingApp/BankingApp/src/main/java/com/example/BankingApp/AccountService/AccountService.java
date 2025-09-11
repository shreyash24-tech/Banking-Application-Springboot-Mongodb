package com.example.BankingApp.AccountService;

import com.example.BankingApp.AccountRepo.AccountRepository;
import com.example.BankingApp.Entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Transactional
    public void transferMoney(String fromId, String toId, double amount) {
        Account from = repository.findById(fromId).orElseThrow(() -> new RuntimeException("Sender Not Found"));

        Account to = repository.findById(toId).orElseThrow(() -> new RuntimeException("Reciver not found"));

        from.setBalance(from.getBalance() - amount);
        repository.save(from);

        if (amount > 1000) {
            throw new RuntimeException("Transaction Limit Exceed");

        }

        to.setBalance(to.getBalance() + amount);
        repository.save(to);
    }




}
