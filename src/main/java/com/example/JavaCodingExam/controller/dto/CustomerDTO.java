package com.example.JavaCodingExam.controller.dto;

import java.util.List;

public class CustomerDTO {
    private long customerNumber;
    private String customerName;
    private long customerMobile;
    private String customerEmail;
    private String address1;
    private String address2;
    private List<AccountDTO> accounts;

    public CustomerDTO(long customerNumber, String customerName, long customerMobile,
                            String customerEmail, String address1, String address2,
                            List<AccountDTO> accounts) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.accounts = accounts;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(long customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }
}