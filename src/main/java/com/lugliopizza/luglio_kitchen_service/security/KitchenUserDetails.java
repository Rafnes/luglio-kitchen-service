package com.lugliopizza.luglio_kitchen_service.security;

import com.lugliopizza.luglio_kitchen_service.model.KitchenUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class KitchenUserDetails implements UserDetails {
    private final KitchenUser kitchenUser;

    public KitchenUserDetails(KitchenUser kitchenUser) {
        this.kitchenUser = kitchenUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(kitchenUser.getRole());
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return kitchenUser.getPassword();
    }

    @Override
    public String getUsername() {
        return kitchenUser.getUsername();
    }
}
