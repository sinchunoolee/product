package com.example.Product.utility;

import com.example.Product.Exception.ProductListEmpty;
import com.example.Product.Exception.ProductNotFoundById;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> actorNotFoundByIdException(ProductNotFoundById ex){
        ErrorStructure<String> errorStructure=new ErrorStructure<>();
        errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
        errorStructure.setErrorMessage(ex.getMessage());
        errorStructure.setData("Product object with the given id doesn't exist!");

        return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> productListEmpty(ProductListEmpty ex){
        ErrorStructure<String> errorStructure=new ErrorStructure<>();
        errorStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
        errorStructure.setErrorMessage(ex.getMessage());
        errorStructure.setData("Products object with the given id doesn't exist!");

        return new ResponseEntity<ErrorStructure<String>>(errorStructure,HttpStatus.NOT_FOUND);
    }
}
