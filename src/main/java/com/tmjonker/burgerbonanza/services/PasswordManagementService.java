package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.exceptions.UserNotFoundException;
import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<?> changePassword(String username, String newPassword) {

        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null)
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);

        user.setPassword(passwordEncoder.encode(newPassword));
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    public boolean validatePassword(String username, String oldPassword) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    public String encodePassword(String password) {

        return passwordEncoder.encode(password);
    }
}
