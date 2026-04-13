package com.microservices.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}