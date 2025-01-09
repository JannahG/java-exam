package com.example.JavaCodingExam.controller.response;

import com.example.JavaCodingExam.controller.dto.CustomerDTO;
import com.example.JavaCodingExam.entity.Customer;

public class GetResponse {
    private CustomerDTO customerData;
    private int transactionStatusCode;
    private String transactionStatusDescription;

    public GetResponse(CustomerDTO customerData, int transactionStatusCode, String transactionStatusDescription) {
        this.customerData = customerData;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public CustomerDTO getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerDTO customerData) {
        this.customerData = customerData;
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
