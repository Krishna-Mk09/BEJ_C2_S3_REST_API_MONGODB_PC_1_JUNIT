package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;

import java.util.List;

public interface ICustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomer();

    List<Customer> getAllCustomersByName(String customerName);

    List<Customer> findAllCustomerProductName(String productName);

    boolean deleteCustomerById(int customerId);

}
