package com.example.JavaCodingExam.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    private long accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double availableBalance;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private Customer customer;

    public AccountType getAccountType() {
        return accountType;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
}
