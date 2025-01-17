package com.example.JavaCodingExam.controller.response;

public class CreatedResponse {
    private int customerNumber;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public CreatedResponse(int customerNumber, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = customerNumber;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(int transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(String transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }
}
