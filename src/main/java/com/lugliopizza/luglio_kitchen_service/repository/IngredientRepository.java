package com.lugliopizza.luglio_kitchen_service.repository;

import com.lugliopizza.luglio_kitchen_service.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
