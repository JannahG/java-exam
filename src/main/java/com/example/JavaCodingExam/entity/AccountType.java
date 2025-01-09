package com.example.JavaCodingExam.entity;

public enum AccountType {
    Y("Yearly account"),
    S("Savings account"),
    C("Checking account");

    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name() + ": " + description;
    }
}