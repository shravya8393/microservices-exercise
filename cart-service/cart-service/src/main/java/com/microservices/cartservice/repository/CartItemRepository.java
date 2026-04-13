package com.microservices.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.cartservice.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}