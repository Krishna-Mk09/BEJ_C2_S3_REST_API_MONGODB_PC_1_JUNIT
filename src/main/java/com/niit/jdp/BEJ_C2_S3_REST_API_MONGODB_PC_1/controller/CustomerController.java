/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.service.ICustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final ICustomerService icustomerService;

    // It's a constructor injection.
    public CustomerController(ICustomerService icustomerService) {
        this.icustomerService = icustomerService;
    }

    @PostMapping("saveCustomer")
    public ResponseEntity<?> saveFunction(@RequestBody Customer customer) {
        return new ResponseEntity<>(icustomerService.saveCustomer(customer), HttpStatus.CREATED);
    }


    @GetMapping("/fetchAllCustomer")
    public ResponseEntity<?> fetchAllCustomerFunction() {
        return new ResponseEntity<>(icustomerService.getAllCustomer(), HttpStatus.CREATED);
    }

    @GetMapping("fetchCustomerById/{customerId}")
    public ResponseEntity<?> fetchAllCustomerByNameFunction(@PathVariable int customerId) {
        return new ResponseEntity<>(icustomerService.getAllCustomersById(customerId), HttpStatus.CREATED);

    }
}

