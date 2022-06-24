package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.services.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    ShoppingCartService shoppingCartService;

    public CartController(ShoppingCartService shoppingCartService) {

        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/cart/{id}")
    public ShoppingCart getShoppingCart(@PathVariable int id) {

        return shoppingCartService.getShoppingCart(id);
    }
}
