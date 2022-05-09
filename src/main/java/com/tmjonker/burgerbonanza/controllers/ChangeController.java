package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.services.PasswordManagementService;
import com.tmjonker.burgerbonanza.user.User;
import com.tmjonker.burgerbonanza.user.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChangeController {

    UserRepository userRepository;
    PasswordManagementService passwordManagementService;

    public ChangeController(UserRepository userRepository, PasswordManagementService passwordManagementService) {
        this.userRepository = userRepository;
        this.passwordManagementService = passwordManagementService;
    }

    @PostMapping("/change")
    public User postChange(@RequestBody Map<String, Object> payload) {

        String username = (String) payload.get("username");
        String newPassword = (String) payload.get("newPassword");

        return passwordManagementService.changePassword(username, newPassword);
    }
}
