package com.microservices.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microservices.cartservice.entity.Cart;
import com.microservices.cartservice.entity.CartItem;
import com.microservices.cartservice.service.CartService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // cart

    // CREATE CART
    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    // GET ALL CARTS
    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    // GET CART BY ID
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Integer id) {
        return cartService.getCartById(id);
    }

    // UPDATE CART
    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable Integer id,
                           @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    // DELETE CART
    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable Integer id) {
        cartService.deleteCart(id);
        return "Cart deleted";
    }

    //cart items

    // ADD ITEM
    @PostMapping("/item")
    public CartItem addItem(@RequestBody CartItem item) {
        return cartService.addItem(item);
    }

    // GET ALL ITEMS
    @GetMapping("/items")
    public List<CartItem> getAllItems() {
        return cartService.getAllItems();
    }

    // GET ITEM BY ID
    @GetMapping("/item/{id}")
    public CartItem getItemById(@PathVariable Integer id) {
        return cartService.getItemById(id);
    }

    // UPDATE ITEM
    @PutMapping("/item/{id}")
    public CartItem updateItem(@PathVariable Integer id,
                               @RequestBody CartItem item) {
        return cartService.updateItem(id, item);
    }

    // DELETE ITEM
    @DeleteMapping("/item/{id}")
    public String deleteItem(@PathVariable Integer id) {
        cartService.deleteItem(id);
        return "Item deleted";
    }
    
 // PAGINATION FOR CART ITEMS
    @GetMapping("/items/paged")
    public Page<CartItem> getItemsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return cartService.getItemsPaged(page, size);
    }

    // FILTER USING STREAMS
    @GetMapping("/items/filter")
    public List<CartItem> filterItems(@RequestParam int minQty) {
        return cartService.filterItemsByQuantity(minQty);
    }
}