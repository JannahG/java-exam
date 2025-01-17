package com.example.JavaCodingExam.Controller;

import com.example.JavaCodingExam.controller.CustomerController;
import com.example.JavaCodingExam.entity.AccountType;
import com.example.JavaCodingExam.entity.Customer;
import com.example.JavaCodingExam.repository.CustomerRepository;
import com.example.JavaCodingExam.service.CustomerService;
import com.example.JavaCodingExam.service.validations.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerRepository customerRepository;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private Validator validator;

    @InjectMocks
    private CustomerController customerController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void testCreateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerNumber(1);
        customer.setCustomerName("John Doe");
        customer.setCustomerMobile(9081111);
        customer.setCustomerEmail("john.doe@example.com");
        customer.setAddress1("123 Main St");
        customer.setAddress2("Apt 4B");
        customer.setAccountType(AccountType.S);

        String jsonRequest = objectMapper.writeValueAsString(customer);

        when(customerService.createCustomer(customer)).thenReturn(customer);

        mockMvc.perform(post("/api/v1/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("John Doe"))
                .andExpect(jsonPath("$.accountType").value("SAVINGS"));
    }

    @Test
    public void testGetCustomerDetails() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerNumber(3);
        customer.setCustomerName("John Doe");
        customer.setCustomerMobile(9081111);
        customer.setCustomerEmail("john.doe@example.com");
        customer.setAddress1("123 Main St");
        customer.setAddress2("Apt 4B");
        customer.setAccountType(AccountType.S);

        when(customerRepository.findById(3)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/api/v1/account/3"))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.customerNumber").value(3))
                .andExpect(jsonPath("$.customerName").value("John Doe"))
                .andExpect(jsonPath("$.customerMobile").value(9081111))
                .andExpect(jsonPath("$.accountType").value("SAVINGS"));
    }
}
