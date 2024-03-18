package com.example.Product.Controller;

import com.example.Product.Model.Product;
import com.example.Product.Service.ProductService;
import com.example.Product.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    @PostMapping(value="/products/addProduct")
    public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }


    @GetMapping(value="/products/findById")
    public ResponseEntity<ResponseStructure<Product>> findById(int pId) {
        return service.findById(pId);
    }


    @PutMapping(value="/products/updateById")
    public ResponseEntity<ResponseStructure<Product>> updateById(@RequestParam int pId, @RequestBody Product product) {
        return service.updateById(pId, product);
    }


    @DeleteMapping(value="/products/deleteById")
    public ResponseEntity<ResponseStructure<Product>> deleteById(int pId) {
        return service.deleteById(pId);
    }


    @GetMapping(value="/products/findAll")
    public ResponseEntity<ResponseStructure<List<Product>>> findAll(){
        return service.findAll();
    }

}
