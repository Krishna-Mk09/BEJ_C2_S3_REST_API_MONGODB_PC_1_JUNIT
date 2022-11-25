package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Product customerProduct;
    private Product product1, product2;

    /**
     * A setup function which is called before each test case.
     */
    @BeforeEach
    void setUp() {
        product1 = new Product(111, "mac", "my mac");
        customer = new Customer(222, "vamshi", 873472342, product1);
    }

    /**
     * The function deletes all the data in the database after each test
     */
    @AfterEach
    void tearDown() {
        product1 = null;
        customer = null;
        customerRepository.deleteAll();
    }

    /**
     * This function is used to test the customer name
     */
    @Test
    void findAllCustomerName() {
        assertEquals("vamshi", customer.getCustomerName());
        assertNotEquals(112, customer.getCustomerName());
    }

    /**
     * This function tests the getProductName() function in the Product class
     */
    @Test
    void getCustomerProductName() {
        assertEquals("mac", product1.getProductName());
        assertNotEquals("MAC", product1.getProductName());
    }

    /**
     * This function tests the getProductId() function in the Product class
     */
    @Test
    void getProductById() {
        assertEquals(111, product1.getProductId());
        assertNotEquals(11.1, product1.getProductId());
    }

    /**
     * The function getCustomerById() tests that the customerId is 222 and not 1.22
     */
    @Test
    void getCustomerById() {
        assertEquals(222, customer.getCustomerId());
        assertNotEquals(1.22, customer.getCustomerId());
    }

    /**
     * This function tests the getPhoneNumber() function in the Customer class
     */
    @Test
    void getCustomerByPhone() {
        assertEquals(873472342, customer.getPhoneNumber());
        assertNotEquals(87347234, customer.getPhoneNumber());
    }

    /**
     * The function deletes a customer from the database and then checks if the customer is still in the database
     */
    @Test
    void delete() {
        Customer c1 = customerRepository.save(customer);
        customerRepository.delete(customer);
        assertEquals(Optional.empty(), customerRepository.findById(customer.getCustomerId()));
    }
}