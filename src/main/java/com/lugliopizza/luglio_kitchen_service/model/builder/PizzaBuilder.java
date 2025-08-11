package com.lugliopizza.luglio_kitchen_service.model.builder;

import com.lugliopizza.luglio_kitchen_service.enums.DoughType;
import com.lugliopizza.luglio_kitchen_service.model.Ingredient;
import com.lugliopizza.luglio_kitchen_service.model.Pizza;

import java.util.List;

public class PizzaBuilder {
    private String name;
    private String description;
    private double price;
    private DoughType doughType;
    private List<Ingredient> ingredients;

    public PizzaBuilder(String name, String description, DoughType doughType) {
        this.name = name;
        this.description = description;
        this.doughType = doughType;
    }

    public PizzaBuilder price(double price) {
        this.price = price;
        return this;
    }

    public PizzaBuilder ingredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public Pizza build() {
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setDescription(description);
        pizza.setPrice(price);
        pizza.setDoughType(doughType);
        pizza.setIngredients(ingredients);
        return pizza;
    }
}
