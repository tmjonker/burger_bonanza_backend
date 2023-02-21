package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.exceptions.UsernameAlreadyExistsException;
import com.tmjonker.burgerbonanza.services.CustomUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> register(@RequestBody Map<String, String> userMap) throws UsernameAlreadyExistsException {

        try {
            User user = userDetailsService.saveNewUser(userMap);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
