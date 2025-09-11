package com.example.BankingApp.AccountRepo;

import com.example.BankingApp.Entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
