package com.tmjonker.burgerbonanza.commandlinerunners;

import com.tmjonker.burgerbonanza.role.Role;
import com.tmjonker.burgerbonanza.role.RoleRepository;
import com.tmjonker.burgerbonanza.user.User;
import com.tmjonker.burgerbonanza.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    @Lazy
    public CommandLineAppRunner(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // create default admin account with a default password that can be changed later.
        if (!userRepository.existsByUsername("admin")) {
            User user = new User("admin", passwordEncoder.encode("password"));
            Role role = new Role("Admin");

            roleRepository.save(role);

            user.addRole(role);
            userRepository.save(user);
        }
    }
}
