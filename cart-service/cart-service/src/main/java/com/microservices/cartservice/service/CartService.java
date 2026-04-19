package com.microservices.cartservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.cartservice.entity.Cart;
import com.microservices.cartservice.entity.CartItem;
import com.microservices.cartservice.repository.CartRepository;
import com.microservices.cartservice.repository.CartItemRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.microservices.cartservice.dto.ProductDTO;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductClient productClient;

   // for cart

    // CREATE CART
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    // GET ALL CARTS
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // GET CART BY ID
    public Cart getCartById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    // UPDATE CART
    public Cart updateCart(Integer id, Cart updatedCart) {
        Cart existing = cartRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setUserId(updatedCart.getUserId());
        return cartRepository.save(existing);
    }

    // DELETE CART
    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }

    // cart items

    // ADD ITEM
    public CartItem addItem(CartItem item) {
        return cartItemRepository.save(item);
    }

    // GET ALL ITEMS
    public List<CartItem> getAllItems() {
        return cartItemRepository.findAll();
    }

    // GET ITEM BY ID
    public CartItem getItemById(Integer id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    // UPDATE ITEM
    public CartItem updateItem(Integer id, CartItem updatedItem) {
        CartItem existing = cartItemRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setCartId(updatedItem.getCartId());
        existing.setProductId(updatedItem.getProductId());
        existing.setQuantity(updatedItem.getQuantity());

        return cartItemRepository.save(existing);
    }

    // DELETE ITEM
    public void deleteItem(Integer id) {
        cartItemRepository.deleteById(id);
    }
    public void addToCart(Long productId, int quantity) {

        ProductDTO product = productClient.getProductById(productId);

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        System.out.println("Product validated, adding to cart...");
    }
    
 // PAGINATION
    public Page<CartItem> getItemsPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return cartItemRepository.findAll(pageable);
    }

    // FILTER USING STREAMS
    public List<CartItem> filterItemsByQuantity(int minQty) {
        return cartItemRepository.findAll()
                .stream()
                .filter(item -> item.getQuantity() >= minQty)
                .toList();
    }
    
    public List<CartItem> getItemsByCartId(Integer cartId) {
        return cartItemRepository.findByCartIdNative(cartId);
    }
}