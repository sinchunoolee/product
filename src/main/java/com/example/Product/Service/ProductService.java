package com.example.Product.Service;

import com.example.Product.dto.ProductDTO;
import com.example.Product.utility.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface ProductService {


    ResponseEntity<ResponseStructure<Object>> addProduct(ProductDTO productDTO);

    public ResponseEntity<ResponseStructure<Object>> findById(int pId);


    ResponseEntity<ResponseStructure<Object>> updateById(int pId, ProductDTO productDTO);

    public ResponseEntity<ResponseStructure<Object>> deleteById(int pId);
    public ResponseEntity<ResponseStructure<Object>> findAll();

}
