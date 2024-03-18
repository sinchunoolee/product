package com.example.Product.ServiceImpl;

import com.example.Product.Exception.ProductNotFoundById;
import com.example.Product.Model.Product;
import com.example.Product.Repository.ProductRepo;
import com.example.Product.Service.ProductService;
import com.example.Product.dto.ProductDTO;
import com.example.Product.utility.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo repo;
    private ResponseStructure<Object> responseStructure;

    public ProductServiceImpl(ProductRepo productRepository, ResponseStructure<Object> responseStructure) {
        super();
        this.repo = productRepository;
        this.responseStructure = responseStructure;
    }

    @Override
    public ResponseEntity<ResponseStructure<Object>> addProduct(ProductDTO productDTO) {
        responseStructure.setStatuscode(HttpStatus.CREATED.value())
                .setMessage("Product Created successfully!!")
                .setData(repo.save(mapToProduct(productDTO, new Product())));

        return ResponseEntity.status(HttpStatus.CREATED).body(responseStructure);
    }

    @Override
    public ResponseEntity<ResponseStructure<Object>> findById(int pId) {
        return repo.findById(pId)
                .map(product->ResponseEntity.status(HttpStatus.FOUND)
                        .body(responseStructure.setStatuscode(HttpStatus.FOUND.value())
                                .setMessage("Product Object is Found")
                                .setData(product)))
                .orElseThrow(()-> new ProductNotFoundById("Product Object Not Found"));
    }

    @Override
    public ResponseEntity<ResponseStructure<Object>> updateById(int pId, ProductDTO productDTO) {
        return repo.findById(pId)
                .map(p->ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
                        .setMessage("Product Updated Successfully!")
                        .setData(repo.save(mapToProduct(productDTO, p)))))
                .orElseThrow(()->new ProductNotFoundById("Product Not Found By Id"));
    }

    @Override
    public ResponseEntity<ResponseStructure<Object>> deleteById(int pId) {
        return repo.findById(pId).map(product->{
            repo.delete(product);
            return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
                    .setMessage("Product Object deleted successfully!")
                    .setData(product));
        }).orElseThrow(()->new ProductNotFoundById("Product Not found by Id"));
    }

    @Override
    public ResponseEntity<ResponseStructure<Object>> findAll() {
        return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
                .setMessage("All Products Found!")
                .setData(repo.findAll()));

    }
    private Product mapToProduct(ProductDTO productDTO, Product product) {
        return product.setpName(productDTO.getProductName()).
                setpId(productDTO.getProductCategory()).
                setpPrice(productDTO.getProductPrice());
    }
}

