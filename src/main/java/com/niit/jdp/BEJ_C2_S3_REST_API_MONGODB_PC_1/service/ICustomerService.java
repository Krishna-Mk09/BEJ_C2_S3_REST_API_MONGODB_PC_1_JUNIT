package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerAlreadyExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotExists;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    /**
     * This function saves a customer and throws an exception if the customer already exists.
     *
     * @param customer The customer object that needs to be saved.
     * @return Customer
     */
    Customer saveCustomer(Customer customer) throws CustomerAlreadyExists;

    /**
     * This function returns a list of all customers.
     *
     * @return A list of all the customers in the database.
     */
    List<Customer> getAllCustomer();

    /**
     * This function returns an Optional of Customer, or nothing if the customer doesn't exist.
     *
     * @param customerId The id of the customer you want to retrieve.
     * @return Optional<Customer>
     */
    Optional<Customer> getAllCustomersById(int customerId);

    /**
     * Find all customers who have purchased a product with the given name.
     *
     * @param productName The name of the product to search for.
     * @return A list of customers who have bought a product with the given name.
     */
    List<Customer> findCustomerProductName(String productName);

    /**
     * This function deletes a customer from the database, if the customer exists.
     *
     * @param customerId The id of the customer to be deleted.
     * @return boolean
     */
    boolean deleteCustomerById(int customerId) throws CustomerNotExists;

}
