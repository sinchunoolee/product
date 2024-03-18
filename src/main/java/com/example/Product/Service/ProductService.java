package com.example.Product.Service;

import com.example.Product.Model.Product;
import com.example.Product.utility.ResponseStructure;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public ResponseEntity<ResponseStructure<Product>> addProduct(Product product);
    public ResponseEntity<ResponseStructure<Product>> findById(int pId);
    public ResponseEntity<ResponseStructure<Product>> updateById(int pId, Product product);
    public ResponseEntity<ResponseStructure<Product>> deleteById(int pId);
    public ResponseEntity<ResponseStructure<List<Product>>> findAll();

}
