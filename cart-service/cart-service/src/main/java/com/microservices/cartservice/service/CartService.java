package com.microservices.cartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.cartservice.entity.Cart;
import com.microservices.cartservice.entity.CartItem;
import com.microservices.cartservice.repository.CartRepository;
import com.microservices.cartservice.repository.CartItemRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    // CREATE CART
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // ADD ITEM TO CART
    public CartItem addItemToCart(CartItem item) {
        return cartItemRepository.save(item);
    }

    // GET CART ITEMS
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }
}