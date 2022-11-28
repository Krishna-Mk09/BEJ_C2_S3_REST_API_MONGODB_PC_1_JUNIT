package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Product;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerAlreadyExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.ICustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private ICustomerService iCustomerService;
    @InjectMocks
    private CustomerController customerController;
    private Customer customer;
    private Product customerProduct;
    private Product product;

    private static String jsonToString(final Object ob) throws JsonProcessingException {
        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonContent = mapper.writeValueAsString(ob);
            result = jsonContent;
        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
        return result;
    }

    @BeforeEach
    void setUp() {
        product = new Product(111, "macBook", "apple product");
        customer = new Customer(222, "krishna", 56462346, product);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @AfterEach
    void tearDown() {
        product = null;
        customerProduct = null;
        customer = null;
    }

    @Test
    public void saveCustomerTestSuccess() throws Exception {
        when(iCustomerService.saveCustomer(any())).thenReturn(customer);
        mockMvc.perform(post("/api/v1/saveCustomer").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer))).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(iCustomerService, times(1)).saveCustomer(any());

    }

    @Test
    public void saveCustomerTestFailure() throws Exception {
        when(iCustomerService.saveCustomer(any())).thenThrow(CustomerAlreadyExists.class);
        mockMvc.perform(post("/api/v1/saveCustomer").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer))).andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(iCustomerService, times(1)).saveCustomer(any());

    }

    @Test
    public void deleteCustomerSuccess() throws Exception, CustomerNotExists {
        when(iCustomerService.deleteCustomerById(anyInt())).thenReturn(true);
        mockMvc.perform(delete("/api/v1/deleteCustomerById/222").contentType(MediaType.APPLICATION_JSON).content(jsonToString(customer))).andExpect(status().is2xxSuccessful()).andDo(MockMvcResultHandlers.print());
        verify(iCustomerService, times(1)).deleteCustomerById(anyInt());
    }

    @Test
    public void deleteCustomerFailure() throws Exception, CustomerNotExists {
        when(iCustomerService.deleteCustomerById(anyInt())).thenThrow(CustomerNotExists.class);
        mockMvc.perform(delete("/api/v1/deleteCustomerById/222").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(iCustomerService, times(1)).deleteCustomerById(anyInt());
    }
}

