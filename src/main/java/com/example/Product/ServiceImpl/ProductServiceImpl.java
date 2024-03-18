package com.example.Product.ServiceImpl;

import com.example.Product.Exception.ProductNotFoundById;
import com.example.Product.Model.Product;
import com.example.Product.Repository.ProductRepo;
import com.example.Product.Service.ProductService;
import com.example.Product.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;

    @Override
    public ResponseEntity<ResponseStructure<Product>> addProduct(Product product) {
        Product product1=repo.save(product);

        ResponseStructure<Product> responseStructure=new ResponseStructure<>();
        responseStructure.setStatuscode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Product Object Created Successfully!!");
        responseStructure.setData(product1);

        return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> findById(int pId) {
        Optional<Product> optional=repo.findById(pId);


        if(optional.isPresent()) {
            Product actor=optional.get();
            ResponseStructure<Product> responseStructure=new ResponseStructure<>();
            responseStructure.setStatuscode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Products Object Updated Successfully!!");
            responseStructure.setData(actor);

            return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.FOUND);

        }else {
            throw new ProductNotFoundById("Product not found!");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> updateById(int pId, Product updatedProduct) {
        Optional<Product> optional=repo.findById(pId);
        if(optional.isPresent()) {
            Product existingProduct=optional.get();
            updatedProduct.setpId(existingProduct.getpId());
            updatedProduct.setpPrice(updatedProduct.getpPrice());
            ResponseStructure<Product> responseStructure=new ResponseStructure<>();
            responseStructure.setStatuscode(HttpStatus.OK.value());
            responseStructure.setMessage("Product Object Updated Successfully!!");
            responseStructure.setData(updatedProduct);
            repo.save(updatedProduct);

            return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);

        }else
        {
            throw new ProductNotFoundById("Product not found!");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Product>> deleteById(int pId) {
        Optional<Product> optional=repo.findById(pId);
        if(optional.isPresent()) {
            Product existActor=optional.get();
            repo.deleteById(pId);
            ResponseStructure<Product> responseStructure=new ResponseStructure<>();
            responseStructure.setStatuscode(HttpStatus.OK.value());
            responseStructure.setMessage("Product Object Deleted Successfully!!");
            responseStructure.setData(existActor);

            return new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);

        }else {
            throw new ProductNotFoundById("Product not found!");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Product>>> findAll() {
        List<Product> list = repo.findAll();

        if(list.isEmpty()) {
            throw new ProductNotFoundById("Product not found!");
        }
        else {
            ResponseStructure<List<Product>> responseStructure=new ResponseStructure<>();
            responseStructure.setStatuscode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Products Objects found Successfully!!");
            responseStructure.setData((List<Product>) list);

            return new ResponseEntity<ResponseStructure<List<Product>>>(responseStructure,HttpStatus.OK);
        }
    }
    }

