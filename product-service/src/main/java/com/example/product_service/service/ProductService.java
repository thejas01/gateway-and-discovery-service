package com.example.product_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product_service.model.Product;

@Service
public class ProductService {

    private final List<Product> productList = new ArrayList<>();

    // Initialize with some products
    public ProductService() {
        productList.add(new Product(1, "Laptop", 1000.00));
        productList.add(new Product(2, "Phone", 800.00));
        productList.add(new Product(3, "Tablet", 500.00));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    // Get product by ID
    public Optional<Product> getProductById(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst();
    }

   // Add a new product
    public Product addProduct(Product product) {
        product.setId(generateProductId());
        productList.add(product);
        return product;
    }
    // public boolean addProduct(Product product) {
    //     if (Objects.equals(product.getId(), null) && productList.existsById(product.getId())) {
    //         throw new IllegalArgumentException("Product with this ID already exists");
    //     }
    //     return productList.add(product);
    // }
    

    // Update an existing product
    public Optional<Product> updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProduct = getProductById(id);
        existingProduct.ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
        });
        return existingProduct;
    }

    // Delete a product by ID
    public boolean deleteProduct(int id) {
        return productList.removeIf(product -> product.getId() == id);
    }

    // Utility to generate unique product IDs
    private int generateProductId() {
        return productList.size() > 0 ? productList.get(productList.size() - 1).getId() + 1 : 1;
    }
}