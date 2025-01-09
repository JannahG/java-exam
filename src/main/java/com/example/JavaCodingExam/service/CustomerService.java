package com.example.JavaCodingExam.service;

import com.example.JavaCodingExam.controller.dto.AccountDTO;
import com.example.JavaCodingExam.controller.dto.CustomerDTO;
import com.example.JavaCodingExam.entity.Account;
import com.example.JavaCodingExam.entity.Customer;
import com.example.JavaCodingExam.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public CustomerDTO getCustomer(int customerNumber) {
        Customer customer = customerRepository.findById(customerNumber).orElse(null);

        if (customer == null) {
            return null;
        }

        List<Account> accounts = customer.getAccounts();

        List<Account> filteredAccounts = accounts.stream()
                .filter(account -> account.getAccountType() == customer.getAccountType())
                .toList();

        List<AccountDTO> accountResponses = filteredAccounts.stream()
                .map(account -> new AccountDTO(account.getAccountNumber(),
                        account.getAccountType().toString(),
                        account.getAvailableBalance()))
                .collect(Collectors.toList());

        return new CustomerDTO(
                customer.getCustomerNumber(),
                customer.getCustomerName(),
                customer.getCustomerMobile(),
                customer.getCustomerEmail(),
                customer.getAddress1(),
                customer.getAddress2(),
                accountResponses
        );
    }
}