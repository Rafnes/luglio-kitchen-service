package com.lugliopizza.luglio_kitchen_service.controller;

import com.lugliopizza.luglio_kitchen_service.enums.IngredientType;
import com.lugliopizza.luglio_kitchen_service.model.Ingredient;
import com.lugliopizza.luglio_kitchen_service.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin_panel/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/addIngredient")
    public String showAddIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        model.addAttribute("types", IngredientType.values());
        return "add-ingredient";
    }

    @PostMapping("/saveIngredient")
    public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
        return "redirect:/admin_panel/ingredientStorage";
    }

    @GetMapping()
    public String showInventory(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        return "ingredient-storage";
    }
}
