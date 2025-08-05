package com.lugliopizza.luglio_kitchen_service.model;

import com.lugliopizza.luglio_kitchen_service.enums.DoughType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "dough_type", nullable = false)
    private DoughType doughType;

    private List<Ingredient> ingredients = new ArrayList<>();
}
