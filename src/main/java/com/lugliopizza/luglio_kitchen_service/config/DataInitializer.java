package com.lugliopizza.luglio_kitchen_service.config;

import com.lugliopizza.luglio_kitchen_service.enums.Role;
import com.lugliopizza.luglio_kitchen_service.model.KitchenEmployee;
import com.lugliopizza.luglio_kitchen_service.repository.KitchenEmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner dataLoader(KitchenEmployeeRepository kitchenEmployeeRepository, PasswordEncoder encoder) {
        return args -> {
            if (kitchenEmployeeRepository.findByUsername("LUGLIO_ADMIN").isEmpty()) {
                KitchenEmployee admin = new KitchenEmployee();
                admin.setUsername("LUGLIO_ADMIN");
                admin.setPassword(encoder.encode("admin"));
                admin.setRole(Role.ADMIN);
                kitchenEmployeeRepository.save(admin);
            }
        };
    }
}
