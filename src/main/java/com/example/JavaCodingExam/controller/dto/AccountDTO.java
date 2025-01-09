package com.example.JavaCodingExam.controller.dto;

import com.example.JavaCodingExam.entity.AccountType;

public class AccountDTO {

    private long accountNumber;
    private String accountType;
    private double availableBalance;

    public AccountDTO(long accountNumber, String accountType, double availableBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.availableBalance = availableBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
}