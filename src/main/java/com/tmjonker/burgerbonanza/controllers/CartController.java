package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.entities.shoppingcart.shoppingcartrequest.ShoppingCartRequest;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    ShoppingCartService shoppingCartService;

    public CartController(ShoppingCartService shoppingCartService) {

        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/cart/{username}")
    public ResponseEntity<?> postCart(@RequestBody ShoppingCartRequest shoppingCartRequest, @PathVariable String username) {

        return shoppingCartService.processShoppingCart(shoppingCartRequest, username);
    }

    @GetMapping("/cart/{username}")
    public ResponseEntity<?> getCart(@PathVariable String username) {

        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(username);

        if (shoppingCart != null) {
            return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
