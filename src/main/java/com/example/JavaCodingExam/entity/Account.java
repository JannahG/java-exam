package com.example.JavaCodingExam.entity;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    private long accountNumber;
    private String accountType;
    private double availableBalance;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private Customer customer;

    public String getAccountType() {
        return accountType;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
