package com.upc.saveup.user_microservice.controller;

import com.upc.saveup.user_microservice.UserMicroserviceApplication;
import com.upc.saveup.user_microservice.model.Company;
import com.upc.saveup.user_microservice.repository.CompanyRepository;
import com.upc.saveup.user_microservice.repository.CustomerRepository;
import com.upc.saveup.user_microservice.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = UserMicroserviceApplication.class)
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CompanyService companyService;

    @MockBean
    private CustomerRepository customerRepository;

    @InjectMocks
    private CompanyController companyController;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }


    @Test
    public void testGetPurchaseData() throws Exception {
        List<Map<String, Object>> purchaseData = new ArrayList<>();
        Map<String, Object> data = new HashMap<>();
        data.put("item", "Product 1");
        data.put("amount", 100);
        purchaseData.add(data);
        when(companyService.getSaleData(1)).thenReturn(purchaseData);
        mockMvc.perform(get("/api/saveup/v1/sale/1/data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].item").value("Product 1"))
                .andExpect(jsonPath("$[0].amount").value(100));
    }


    @Test
    public void testUpdateCompany() throws Exception {
        Company company = new Company();
        company.setName("Test Company");
        company.setEmail("test@gmail.com");
        company.setRuc("12345678901");
        company.setAddress("address");
        company.setPhoneNumber("999999999");
        company.setPassword("password");
        company.setRepeatPassword("password");
        company.setDepartment("department");
        company.setDistrict("district");
        when(companyService.isCompanyExist(1)).thenReturn(true);
        doNothing().when(companyService).updateCompany(company);

        mockMvc.perform(put("/api/saveup/v1/companies/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(company)))
                .andExpect(status().isOk())
                .andExpect(content().string("Company is updated successfully"));
    }

    @Test
    public void testDeleteCompany() throws Exception {
        when(companyService.isCompanyExist(1)).thenReturn(true);
        doNothing().when(companyService).deleteCompany(1);

        mockMvc.perform(delete("/api/saveup/v1/companies/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Company is deleted successfully"));
    }

    static String asJsonString(final Object obj) {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
