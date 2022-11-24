/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain;

public class Customer {
    private int customerId;
    private String customerName;
    private long PhoneNumber;
    private Product customerProduct;

    public Customer() {
    }

    public Customer(int customerId, String customerName, long phoneNumber, Product customerProduct) {
        this.customerId = customerId;
        this.customerName = customerName;
        PhoneNumber = phoneNumber;
        this.customerProduct = customerProduct;
    }
}
