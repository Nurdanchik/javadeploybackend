package com.bezkoder.springjwt.config;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class AdminInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // ✅ Убедимся, что роль ROLE_ADMIN существует
        Optional<Role> adminRoleOpt = roleRepository.findByName(ERole.ROLE_ADMIN);
        Role adminRole;

        if (adminRoleOpt.isEmpty()) {
            adminRole = new Role();
            adminRole.setName(ERole.ROLE_ADMIN);
            roleRepository.save(adminRole);
            System.out.println("✅ Роль ROLE_ADMIN была создана");
        } else {
            adminRole = adminRoleOpt.get();
        }

        // ✅ Проверим, есть ли уже админ
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("admin123"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            admin.setRoles(roles);

            userRepository.save(admin);
            System.out.println("✅ Админ создан: admin");
        } else {
            System.out.println("⚠️ Админ уже существует. Пропускаем создание.");
        }
    }
}