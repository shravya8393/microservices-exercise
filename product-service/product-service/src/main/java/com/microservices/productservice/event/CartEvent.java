package com.microservices.productservice.event;

public class CartEvent {

    private Long cartId;
    private Long productId;
    private int quantity;

    
    public CartEvent() {}

    public Long getCartId() { return cartId; }
    public void setCartId(Long cartId) { this.cartId = cartId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
