package com.bezkoder.springjwt.config;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleInitializer {

    @Bean
    public CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            for (ERole role : ERole.values()) {
                if (!roleRepository.existsByName(role)) {
                    roleRepository.save(new Role(role));
                    System.out.println("✅ Added role: " + role);
                }
            }
        };
    }
}