package com.example.JavaCodingExam.service;

import com.example.JavaCodingExam.controller.dto.AccountDTO;
import com.example.JavaCodingExam.controller.dto.CustomerDTO;
import com.example.JavaCodingExam.entity.Account;
import com.example.JavaCodingExam.entity.AccountType;
import com.example.JavaCodingExam.entity.Customer;
import com.example.JavaCodingExam.repository.AccountRepository;
import com.example.JavaCodingExam.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Customer createCustomer(Customer customer) {
        var customerRepo = customerRepository.save(customer);

        var acctType = customer.getAccountType();
        var desc = acctType.getDescription();

        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
//        account.setAccountType(customer.getAccountType().getDescription());
        account.setAccountType(desc);
        account.setAvailableBalance(500.00);
        account.setCustomer(customer);

        accountRepository.save(account);
        return customerRepo;
    }

    public CustomerDTO getCustomer(int customerNumber) {
        Customer customer = customerRepository.findById(customerNumber).orElse(null);

        if (customer == null) {
            return null;
        }

        List<AccountDTO> accountResponses = customer.getAccounts().stream()
                .map(account -> new AccountDTO(
                        account.getAccountNumber(),
                        account.getAccountType(),
                        account.getAvailableBalance()
                ))
                .toList();

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

    private long generateAccountNumber() {
        return (long) (Math.random() * 10000);
    }
}