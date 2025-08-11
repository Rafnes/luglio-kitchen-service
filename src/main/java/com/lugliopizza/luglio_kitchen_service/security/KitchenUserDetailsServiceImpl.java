package com.lugliopizza.luglio_kitchen_service.security;

import com.lugliopizza.luglio_kitchen_service.exception.UserNotFoundException;
import com.lugliopizza.luglio_kitchen_service.model.KitchenUser;
import com.lugliopizza.luglio_kitchen_service.repository.KitchenUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class KitchenUserDetailsServiceImpl implements UserDetailsService {

    private final KitchenUserRepository kitchenUserRepository;

    public KitchenUserDetailsServiceImpl(KitchenUserRepository kitchenUserRepository) {
        this.kitchenUserRepository = kitchenUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        KitchenUser kitchenUser = kitchenUserRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("Пользователь %s не найден", username)));
        return new KitchenUserDetails(kitchenUser);
    }
}
