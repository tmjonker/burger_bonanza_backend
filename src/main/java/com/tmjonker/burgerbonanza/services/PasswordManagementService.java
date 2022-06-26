package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.exceptions.UserNotFoundException;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordManagementService {

    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public PasswordManagementService(PasswordEncoder passwordEncoder, UserRepository userRepository) {

        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User changePassword(String username, String newPassword) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }

    public boolean validatePassword(String username, String oldPassword) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    public String encodePassword(String password) {

        return passwordEncoder.encode(password);
    }
}
