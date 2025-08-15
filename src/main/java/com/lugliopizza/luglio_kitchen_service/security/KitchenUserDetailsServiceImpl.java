package com.lugliopizza.luglio_kitchen_service.security;

import com.lugliopizza.luglio_kitchen_service.exception.UserNotFoundException;
import com.lugliopizza.luglio_kitchen_service.model.KitchenEmployee;
import com.lugliopizza.luglio_kitchen_service.repository.KitchenEmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KitchenUserDetailsServiceImpl implements UserDetailsService {

    private final KitchenEmployeeRepository kitchenEmployeeRepository;

    public KitchenUserDetailsServiceImpl(KitchenEmployeeRepository kitchenEmployeeRepository) {
        this.kitchenEmployeeRepository = kitchenEmployeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        KitchenEmployee kitchenEmployee = kitchenEmployeeRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("Пользователь %s не найден", username)));
        return new KitchenUserDetails(kitchenEmployee);
    }
}
