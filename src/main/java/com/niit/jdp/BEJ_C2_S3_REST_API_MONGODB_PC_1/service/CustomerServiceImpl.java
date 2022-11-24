/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    public List<Customer> getAllCustomersByName(String customerName) {
        return null;
    }

    @Override
    public List<Customer> findAllCustomerProductName(String productName) {
        return null;
    }

    @Override
    public boolean deleteCustomerById(int customerId) {
        return false;
    }
}
