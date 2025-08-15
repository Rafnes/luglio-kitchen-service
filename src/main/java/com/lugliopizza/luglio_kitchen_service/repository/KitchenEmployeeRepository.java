package com.lugliopizza.luglio_kitchen_service.repository;

import com.lugliopizza.luglio_kitchen_service.model.KitchenEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KitchenEmployeeRepository extends JpaRepository<KitchenEmployee, Integer> {
    Optional<KitchenEmployee> findByUsername(String username);
}
