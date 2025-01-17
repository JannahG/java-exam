package com.example.JavaCodingExam.controller;

import com.example.JavaCodingExam.controller.dto.CustomerDTO;
import com.example.JavaCodingExam.controller.response.CreatedResponse;
import com.example.JavaCodingExam.controller.response.ErrorResponse;
import com.example.JavaCodingExam.controller.response.GetResponse;
import com.example.JavaCodingExam.entity.Customer;
import com.example.JavaCodingExam.service.CustomerService;
import com.example.JavaCodingExam.service.validations.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @Autowired
    public Validator validator;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        ErrorResponse errorResponse = validator.ValidateCustomer(customer);

        if (errorResponse != null) {
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Customer createdCustomer = customerService.createCustomer(customer);

        CreatedResponse response = new CreatedResponse(
                createdCustomer.getCustomerNumber(),
                201,
                "Customer account created");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable int customerNumber) {
        CustomerDTO customer = customerService.getCustomer(customerNumber);

        if (customer == null) {
            ErrorResponse errorResponse = new ErrorResponse(
                    401,
                    "Customer not found"
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        GetResponse response = new GetResponse(
                customer,
                302,
                "Customer account found");

        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
