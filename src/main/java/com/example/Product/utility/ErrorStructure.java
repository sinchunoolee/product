package com.example.Product.utility;

import org.springframework.stereotype.Component;

import java.util.Map;
@Component

public class ErrorStructure<T> {
    private int statuscode;
    private String errorMessage;
    private T data;
    private Object rootCause;
    public Object getRootCause() {
        return rootCause;
    }

    public ErrorStructure setRootCause(Object rootCause) {
        this.rootCause = rootCause;
        return this;
    }


    public int getStatuscode() {
        return statuscode;
    }
    public ErrorStructure setStatuscode(int statuscode) {
        this.statuscode = statuscode;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public ErrorStructure setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return  this;
    }
    public T getData() {
        return data;
    }
    public ErrorStructure setData(T data) {
        this.data = data;
        return this;
    }


}
