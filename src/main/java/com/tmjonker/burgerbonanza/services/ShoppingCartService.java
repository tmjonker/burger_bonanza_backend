package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {

        this.shoppingCartRepository = shoppingCartRepository;
    }

    public ShoppingCart getShoppingCart(int id) {

        return shoppingCartRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }
}
