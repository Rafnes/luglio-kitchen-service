package com.lugliopizza.luglio_kitchen_service.security;

import com.lugliopizza.luglio_kitchen_service.model.KitchenEmployee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class KitchenUserDetails implements UserDetails {
    private final KitchenEmployee kitchenEmployee;

    public KitchenUserDetails(KitchenEmployee kitchenEmployee) {
        this.kitchenEmployee = kitchenEmployee;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(kitchenEmployee.getRole().toString());
        return List.of(role);
    }

    @Override
    public String getPassword() {
        return kitchenEmployee.getPassword();
    }

    @Override
    public String getUsername() {
        return kitchenEmployee.getUsername();
    }
}
