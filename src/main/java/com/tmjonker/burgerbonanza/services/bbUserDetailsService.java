package com.tmjonker.burgerbonanza.services;

import com.tmjonker.burgerbonanza.user.User;
import com.tmjonker.burgerbonanza.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class bbUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public bbUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username"));
    }
}
