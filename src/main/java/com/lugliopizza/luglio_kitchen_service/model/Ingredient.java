package com.lugliopizza.luglio_kitchen_service.model;

import com.lugliopizza.luglio_kitchen_service.enums.IngredientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Setter
    private IngredientType type;

    @Column(name = "name", nullable = false)
    @Setter
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Setter
    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas = new ArrayList<>();
}
