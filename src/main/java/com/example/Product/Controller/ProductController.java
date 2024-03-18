package com.example.Product.Controller;

import com.example.Product.Service.ProductService;
import com.example.Product.dto.ProductDTO;
import com.example.Product.utility.ErrorStructure;
import com.example.Product.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    public ProductController(ProductService productService) {
        super();
        this.service = productService;
    }

    @Operation(description = "The endpoint is used to add a new product to the database", responses = {
            @ApiResponse(responseCode = "200", description = "Product saved successfully!"),
            @ApiResponse(responseCode = "400", description = "Invalid inputs")})
    @PostMapping(value="/products/addProduct")
    public ResponseEntity<ResponseStructure< Object>> addProduct(@RequestBody ProductDTO productDTO) {
        return service.addProduct(productDTO);
    }

    @Operation(description = "This is get method to find the product based on Id", responses =  {@ApiResponse(responseCode = "302", description = "Product Found"),
            @ApiResponse(responseCode = "404", description = "Product not found by given Id", content = {@Content(schema = @Schema(implementation = ErrorStructure.class))})
    })
    @GetMapping(value="/products/findById")
    public ResponseEntity<ResponseStructure<Object>> findById(@RequestParam int productId) {

        return service.findById(productId);
    }


    @PutMapping(value="/products/updateById")
    public ResponseEntity<ResponseStructure<Object>> updateById(@PathVariable int productId, @RequestBody ProductDTO productDTO) {
        return service.updateById(productId, productDTO);
    }


    @DeleteMapping(value="/products/deleteById")
    public ResponseEntity<ResponseStructure<Object>> deleteById(@RequestParam int pId) {

        return service.deleteById(pId);
    }


    @GetMapping(value="/products/findAll")
    public ResponseEntity<ResponseStructure<Object>> findAll(){
        return service.findAll();
    }

}
