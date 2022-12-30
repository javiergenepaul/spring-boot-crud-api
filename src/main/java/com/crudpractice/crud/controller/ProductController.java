package com.crudpractice.crud.controller;


import com.crudpractice.crud.model.Product;
import com.crudpractice.crud.response.ResponseHandler;
import com.crudpractice.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/hello-world")
    public ResponseEntity<Object> HelloWorld(){
        try {
            List<Product> prod = service.getProducts();
            String message = "Hello World Example";
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping("/add-product")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        try {
            Product prod = service.saveProduct(product);
            String message = "Successfully Added Product";
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/add-products")
    public ResponseEntity<Object> addProduct(@RequestBody List<Product> products) {
        try {
//            return (List<Product>) service.saveProducts(products);
            List<Product> prod = service.saveProducts(products);
            String message = "Successfully Added Products";
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<Object> findAllProducts() {
        try {
            List<Product> prod = service.getProducts();
            String message = "Product List.";
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable int id) {
        try {
            Product prod = service.getProductById(id);
            String message;
            if (prod != null) {
                message = "Product Details.";
            } else {
                message = "Product not found.";
            }
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/product-name/{name}")
    public ResponseEntity<Object> findProductByName(@PathVariable String name) {
        try {
            Product prod = service.getProductByName(name);
            String message;
            if (prod != null) {
                message = "Product Details.";
            } else {
                message = "Product not found.";
            }
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
        try {
            Product prod = service.updateProduct(id, product);
            String message;
            if (prod != null) {
                message = "Product Details.";
            } else {
                message = "Product not found.";
            }
            return ResponseHandler.generateResponse(message, HttpStatus.OK, prod);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        try {
            String message = service.deleteProduct(id);
            return ResponseHandler.generateResponse(message, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
