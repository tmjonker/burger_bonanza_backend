package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.exceptions.UsernameAlreadyExistsException;
import com.tmjonker.burgerbonanza.services.CustomUserDetailsService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {

    CustomUserDetailsService userDetailsService;

    public RegisterController(CustomUserDetailsService userDetailsService) {

        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public User register(@RequestBody Map<String, String> userMap) throws UsernameAlreadyExistsException {

        return userDetailsService.saveUser(userMap);
    }
}
