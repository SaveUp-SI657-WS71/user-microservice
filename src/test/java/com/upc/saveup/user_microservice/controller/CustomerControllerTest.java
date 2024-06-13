package com.upc.saveup.user_microservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upc.saveup.user_microservice.controller.CustomerController;
import com.upc.saveup.user_microservice.exception.ResourceNotFoundException;
import com.upc.saveup.user_microservice.exception.ValidationException;
import com.upc.saveup.user_microservice.model.Customer;
import com.upc.saveup.user_microservice.repository.CompanyRepository;
import com.upc.saveup.user_microservice.repository.CustomerRepository;
import com.upc.saveup.user_microservice.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.upc.saveup.user_microservice.controller.CompanyControllerTest.asJsonString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test Customer");
        customer.setEmail("test@gmail.com");
        customers.add(customer);

        when(customerRepository.findAll()).thenReturn(customers);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/saveup/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Test Customer"))
                .andExpect(jsonPath("$[0].email").value("test@gmail.com"));
    }


}
