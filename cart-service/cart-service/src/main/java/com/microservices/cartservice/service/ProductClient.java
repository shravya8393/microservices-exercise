package com.microservices.cartservice.service;

import com.microservices.cartservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductClient {

    @Autowired
    private WebClient webClient;

    public ProductDTO getProductById(Long productId) {
        return webClient.get()
                .uri("/products/" + productId)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }
}