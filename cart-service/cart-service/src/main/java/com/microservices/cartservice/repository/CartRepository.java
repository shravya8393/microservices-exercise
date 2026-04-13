package com.microservices.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.cartservice.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}