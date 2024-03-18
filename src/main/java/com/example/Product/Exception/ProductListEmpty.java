package com.example.Product.Exception;

public class ProductListEmpty extends RuntimeException{
    private String message;

    public String getMessage() {
        return message;
    }

    public ProductListEmpty(String message) {
        super();
        this.message = message;
    }

}
