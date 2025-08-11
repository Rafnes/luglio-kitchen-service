package com.lugliopizza.luglio_kitchen_service.repository;

import com.lugliopizza.luglio_kitchen_service.model.KitchenUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KitchenUserRepository extends JpaRepository<KitchenUser, Integer> {
    Optional<KitchenUser> findByUsername(String username);
}
