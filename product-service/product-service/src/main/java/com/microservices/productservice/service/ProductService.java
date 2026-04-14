package com.microservices.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.productservice.entity.Product;
import com.microservices.productservice.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CREATE PRODUCT
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // GET ALL PRODUCTS
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET PRODUCT BY ID
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    // CHECK STOCK
    public boolean isProductInStock(Integer id, Integer quantity) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null && product.getStock() >= quantity;
    }
}