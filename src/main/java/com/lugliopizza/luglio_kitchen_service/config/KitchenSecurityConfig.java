package com.lugliopizza.luglio_kitchen_service.config;

import com.lugliopizza.luglio_kitchen_service.security.KitchenUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class KitchenSecurityConfig {
    @Autowired
    private KitchenUserDetailsServiceImpl kitchenUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/kitchen/admin/**").hasRole("ADMIN")
                        .requestMatchers("/kitchen/**").hasAnyRole("ADMIN", "COOK")
                        .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }
}
