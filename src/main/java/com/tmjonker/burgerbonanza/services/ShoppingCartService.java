package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.menu.MenuItem;
import com.tmjonker.burgerbonanza.entities.shoppingcart.ShoppingCart;
import com.tmjonker.burgerbonanza.entities.shoppingcart.shoppingcartrequest.ShoppingCartRequest;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    ShoppingCartRepository shoppingCartRepository;
    CustomUserDetailsService userDetailsService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CustomUserDetailsService userDetailsService) {

        this.shoppingCartRepository = shoppingCartRepository;
        this.userDetailsService = userDetailsService;
    }

    public ShoppingCart getShoppingCart(String username) {

        User user = (User) userDetailsService.loadUserByUsername(username);

        return user.getShoppingCart();
    }

    public void processShoppingCart(ShoppingCartRequest shoppingCartRequest, String username) {

        ShoppingCart cart = new ShoppingCart(shoppingCartRequest.getNumItems(), shoppingCartRequest.getMenuItems());
        User user = (User) userDetailsService.loadUserByUsername(username);
        cart = shoppingCartRepository.save(cart);
        user.setShoppingCart(cart);

        userDetailsService.saveUser(user);
    }
}
