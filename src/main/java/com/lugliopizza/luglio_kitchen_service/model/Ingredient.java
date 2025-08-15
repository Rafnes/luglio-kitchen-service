package com.lugliopizza.luglio_kitchen_service.model;

import com.lugliopizza.luglio_kitchen_service.enums.IngredientType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Setter
    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingredient ingredient = (Ingredient) obj;
        return Objects.equals(id, ingredient.id) && type == ingredient.type && Objects.equals(name, ingredient.name) && Objects.equals(description, ingredient.description) && Objects.equals(quantity, ingredient.quantity) && Objects.equals(pizzas, ingredient.pizzas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, description, quantity, pizzas);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
