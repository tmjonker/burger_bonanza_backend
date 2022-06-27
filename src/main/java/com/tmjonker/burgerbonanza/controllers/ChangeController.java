package com.tmjonker.burgerbonanza.controllers;

import com.tmjonker.burgerbonanza.entities.user.ChangePasswordRequest.ChangePasswordRequest;
import com.tmjonker.burgerbonanza.services.AuthenticationService;
import com.tmjonker.burgerbonanza.services.PasswordManagementService;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChangeController {

    UserRepository userRepository;
    PasswordManagementService passwordManagementService;
    AuthenticationService authenticationService;

    public ChangeController(UserRepository userRepository, PasswordManagementService passwordManagementService,
                            AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.passwordManagementService = passwordManagementService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/change")
    public User postChange(@RequestBody ChangePasswordRequest cpr) throws Exception {

        String username = cpr.getUsername();
        String newPassword = cpr.getNewPassword();
        String oldPassword = cpr.getOldPassword();

        authenticationService.authenticate(username, oldPassword);

        return passwordManagementService.changePassword(username, newPassword);

    }
}
