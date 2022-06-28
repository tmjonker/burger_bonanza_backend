package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.services.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    ShoppingCartService shoppingCartService;

    public CartController(ShoppingCartService shoppingCartService) {

        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/cart/{username}")
    public void postCart(@RequestBody ShoppingCart shoppingCart, @PathVariable String username) {

        shoppingCartService.processShoppingCart(shoppingCart, username);
    }

    @GetMapping("/cart/{username}")
    public ShoppingCart getCart(@PathVariable String username) {

        return shoppingCartService.getShoppingCart(username);
    }
}
