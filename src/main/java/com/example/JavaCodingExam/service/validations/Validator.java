package com.example.JavaCodingExam.service.validations;

import com.example.JavaCodingExam.controller.response.ErrorResponse;
import com.example.JavaCodingExam.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public ErrorResponse ValidateCustomer(Customer customer) {
        if (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
            return new ErrorResponse(400, "Customer name is required field");
        }
        if (customer.getAddress1() == null || customer.getAddress1().isEmpty()) {
            return new ErrorResponse(400, "Address1 is required field");
        }
        if (customer.getAddress2() == null || customer.getAddress2().isEmpty()) {
            return new ErrorResponse(400, "Address2 is required field");
        }
        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().isEmpty()) {
            return new ErrorResponse(400, "Email is required field");
        }
        if (!isValidEmail(customer.getCustomerEmail())) {
            return new ErrorResponse(400, "Email should be valid");
        }

        return null;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
