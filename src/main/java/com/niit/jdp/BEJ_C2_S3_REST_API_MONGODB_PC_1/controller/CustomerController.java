/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerAlreadyExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotExists;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final ICustomerService icustomerService;

    // It's a constructor injection.
    @Autowired
    public CustomerController(ICustomerService icustomerService) {
        this.icustomerService = icustomerService;
    }

    /**
     * The function is a POST request which takes a Customer object as a request body and returns a ResponseEntity object
     *
     * @param customer The object that is to be saved in the database.
     * @return ResponseEntity<?>
     */
    @PostMapping("/saveCustomer")
    public ResponseEntity<?> saveFunction(@RequestBody Customer customer) throws CustomerAlreadyExists {
        try {
            return new ResponseEntity<>(icustomerService.saveCustomer(customer), HttpStatus.CREATED);
        } catch (CustomerAlreadyExists e) {
            throw new CustomerAlreadyExists();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!Try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * It fetches all the customers from the database.
     *
     * @return A list of all customers
     */
    @GetMapping("/fetchAllCustomer")
    public ResponseEntity<?> fetchAllCustomerFunction() {
        return new ResponseEntity<>(icustomerService.getAllCustomer(), HttpStatus.CREATED);
    }

    /**
     * This function is used to fetch all the customers by their id
     *
     * @param customerId This is the path variable that will be used to fetch the customer details.
     * @return ResponseEntity<?>
     */
    @GetMapping("/fetchCustomerById/{customerId}")
    public ResponseEntity<?> fetchAllCustomerByNameFunction(@PathVariable int customerId) {
        return new ResponseEntity<>(icustomerService.getAllCustomersById(customerId), HttpStatus.CREATED);

    }

    /**
     * This function fetches all the customers who have bought a particular product
     *
     * @param productName The name of the product that you want to search for.
     * @return A list of customers who have purchased a product with the given name.
     */
    @GetMapping("/fetchCustomerByProductName/{productName}")
    public ResponseEntity<?> fetchAllCustomerByProductNameFunction(@PathVariable String productName) {
        return new ResponseEntity<>(icustomerService.findCustomerProductName(productName), HttpStatus.CREATED);

    }

    /**
     * This function is used to delete a customer by customerId
     *
     * @param customerId The customerId of the customer to be deleted.
     * @return ResponseEntity<?>
     */
    @DeleteMapping("/deleteCustomerById/{customerId}")
    public ResponseEntity<?> deleteCustomerByCustomerIdFunction(@PathVariable int customerId) throws CustomerNotExists {
        try {
            return new ResponseEntity<>(icustomerService.deleteCustomerById(customerId), HttpStatus.CREATED);
        } catch (CustomerNotExists e) {
            throw new CustomerNotExists();
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!Try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

