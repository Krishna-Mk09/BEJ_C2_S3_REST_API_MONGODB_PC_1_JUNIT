/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerAlreadyExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    // A private variable of type CustomerRepository.
    private final CustomerRepository customerRepository;

    // A constructor injection.
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * If the customer already exists, throw an exception, otherwise save the customer.
     *
     * @param customer The customer object that needs to be saved.
     * @return Customer
     */
    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExists {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExists();
        }
        return customerRepository.save(customer);
    }

    /**
     * > The function returns a list of all customers from the database
     *
     * @return A list of all customers
     */
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    /**
     * This function returns an Optional of Customer object, which is the result of the findById() function of the
     * customerRepository object
     *
     * @param customerId The id of the customer you want to retrieve.
     * @return Optional<Customer>
     */
    @Override
    public Optional<Customer> getAllCustomersById(int customerId) {
        return customerRepository.findById(customerId);
    }


    /**
     * > Find all customers who have purchased a product with the given name
     *
     * @param productName The name of the product that the customer has purchased.
     * @return A list of customers who have purchased a product with the name productName.
     */
    @Override
    public List<Customer> findCustomerProductName(String productName) {
        return customerRepository.findAllCustomerProductName(productName);
    }

    // The above code is deleting a customer by id.

    /**
     * If the customer exists, delete it. If it doesn't exist, throw an exception
     *
     * @param customerId The id of the customer to be deleted.
     * @return A boolean value.
     */
    @Override
    public boolean deleteCustomerById(int customerId) throws CustomerNotExists {
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerNotExists();
        }
        customerRepository.deleteById(customerId);
        return true;
    }
}




