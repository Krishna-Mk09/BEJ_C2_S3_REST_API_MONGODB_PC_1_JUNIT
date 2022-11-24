package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerAlreadyExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotExists;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer saveCustomer(Customer customer) throws CustomerAlreadyExists;

    List<Customer> getAllCustomer();

    Optional<Customer> getAllCustomersById(int customerId);

    List<Customer> findCustomerProductName(String productName);

    boolean deleteCustomerById(int customerId) throws CustomerNotExists;

}
