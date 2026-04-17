package com.microservices.cartservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cartId;
    private Integer productId;
    private Integer quantity;
    
    // getters
    public Integer getId() { return id; }
    public Integer getCartId() { return cartId; }
    public Integer getProductId() { return productId; }
    public Integer getQuantity() { return quantity; }

    // setters
    public void setId(Integer id) { this.id = id; }
    public void setCartId(Integer cartId) { this.cartId = cartId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}