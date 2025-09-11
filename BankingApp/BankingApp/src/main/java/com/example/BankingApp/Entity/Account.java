package com.example.BankingApp.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class Account {

    @Id
    private String id;
    private String owner;
    private double Balance;

}
