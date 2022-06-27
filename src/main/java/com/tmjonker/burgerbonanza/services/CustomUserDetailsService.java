package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.entities.user.User;
import com.tmjonker.burgerbonanza.exceptions.UsernameAlreadyExistsException;
import com.tmjonker.burgerbonanza.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordManagementService passwordManagementService;

    public CustomUserDetailsService(UserRepository userRepository, PasswordManagementService passwordManagementService) {

        this.userRepository = userRepository;
        this.passwordManagementService = passwordManagementService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username"));
    }

    public User saveNewUser(Map<String, String> userMap) throws UsernameAlreadyExistsException {

        if (!userRepository.existsByUsername(userMap.get("username"))) {
            User user = new User(userMap.get("username"), passwordManagementService.encodePassword(userMap.get("password1")));

            return userRepository.save(user);
        } else {
            throw new UsernameAlreadyExistsException(userMap.get("username"));
        }
    }

    public User saveUser(User user) {

        return userRepository.save(user);
    }
}
