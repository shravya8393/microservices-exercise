package com.microservices.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.productservice.entity.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = "SELECT * FROM product WHERE price > :price", nativeQuery = true)
	List<Product> findProductsAbovePrice(@Param("price") double price);
}
