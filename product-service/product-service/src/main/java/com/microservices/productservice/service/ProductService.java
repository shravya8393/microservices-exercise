package com.microservices.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.productservice.entity.Product;
import com.microservices.productservice.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public boolean isProductInStock(Integer id, Integer quantity) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null && product.getStock() >= quantity;
    }
    
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    
    public Page<Product> getProductsPaged(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return productRepository.findAll(pageable);
    }
    
    public List<Product> filterByPrice(double minPrice) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getPrice() >= minPrice)
                .toList();
    }
    
}