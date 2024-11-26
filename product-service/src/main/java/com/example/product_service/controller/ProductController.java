package com.example.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

@Autowired
private ProductService productService;

@GetMapping
public List<Product> getAllProducts() {
    return productService.getAllProducts();
}
//get product by id
@GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable int id) {
    return productService.getProductById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
//add product
@PostMapping
public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    Product savedProduct = productService.addProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
}
//update product
@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
    return productService.updateProduct(id, product)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
//delete product
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
    if (productService.deleteProduct(id)) {
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
