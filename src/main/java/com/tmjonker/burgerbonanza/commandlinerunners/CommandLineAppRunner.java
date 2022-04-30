package com.tmjonker.burgerbonanza.commandlinerunners;

import com.tmjonker.burgerbonanza.user.User;
import com.tmjonker.burgerbonanza.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public CommandLineAppRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("tmjonker1", passwordEncoder.encode("password"), "ADMIN");
        userRepository.save(user);
    }
}
