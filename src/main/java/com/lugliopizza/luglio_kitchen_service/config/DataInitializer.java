package com.lugliopizza.luglio_kitchen_service.config;

import com.lugliopizza.luglio_kitchen_service.enums.Role;
import com.lugliopizza.luglio_kitchen_service.model.KitchenUser;
import com.lugliopizza.luglio_kitchen_service.repository.KitchenUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner dataLoader(KitchenUserRepository kitchenUserRepository, PasswordEncoder encoder) {
        return args -> {
            if (kitchenUserRepository.findByUsername("LUGLIO_ADMIN").isEmpty()) {
                KitchenUser admin = new KitchenUser();
                admin.setUsername("LUGLIO_ADMIN");
                admin.setPassword(encoder.encode("LUGLIO_MASTER"));
                admin.setRole(Role.ADMIN);
                kitchenUserRepository.save(admin);
            }
        };
    }
}
