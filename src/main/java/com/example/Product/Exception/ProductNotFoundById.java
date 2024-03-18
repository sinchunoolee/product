package com.example.Product.Exception;

public class ProductNotFoundById extends RuntimeException{
    private String message;

    public String getMessage() {
        return message;
    }

    public ProductNotFoundById(String message) {
        super();
        this.message = message;
    }

}
