package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer saveCustomer(Customer customer) throws CustomerExistsAlready;

    List<Customer> getAllCustomer();

    Optional<Customer> getAllCustomersById(int customerId);

    List<Customer> findCustomerProductName(String productName);

    boolean deleteCustomerById(int customerId);

}
