/*
 * Author Name : M.Krishna.
 * Date: 24-11-2022
 * Created With: IntelliJ IDEA Community Edition
 *
 */


package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain;

public class Product {
    private int productId;
    private String productName;
    private String description;

    public Product() {
    }

    public Product(int productId, String productName, String description) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
    }
}
