package com.lugliopizza.luglio_kitchen_service.repository;

import com.lugliopizza.luglio_kitchen_service.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
