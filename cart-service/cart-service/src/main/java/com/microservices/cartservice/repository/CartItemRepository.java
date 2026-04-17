package com.microservices.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.cartservice.entity.CartItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	@Query(value = "SELECT * FROM cart_item WHERE cart_id = :cartId", nativeQuery = true)
	List<CartItem> findByCartIdNative(@Param("cartId") Integer cartId);
}
