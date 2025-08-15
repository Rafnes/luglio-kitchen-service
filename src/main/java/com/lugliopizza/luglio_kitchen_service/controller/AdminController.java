package com.lugliopizza.luglio_kitchen_service.controller;

import com.lugliopizza.luglio_kitchen_service.model.KitchenEmployee;
import com.lugliopizza.luglio_kitchen_service.service.KitchenEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin_panel")
public class AdminController {
    private final KitchenEmployeeService kitchenEmployeeService;

    public AdminController(KitchenEmployeeService kitchenEmployeeService) {
        this.kitchenEmployeeService = kitchenEmployeeService;
    }

    @GetMapping
    @ResponseBody
    public String adminStartPage() {
        return "Hey there";
    }

    @GetMapping("/addEmployee")
    public String showAddKitchenEmployeeForm(Model model) {
        model.addAttribute("kitchenEmployee", new KitchenEmployee());
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("kitchenEmployee") KitchenEmployee kitchenEmployee) {
        kitchenEmployeeService.saveEmployee(kitchenEmployee);
        return "redirect:/admin_panel";
    }
}
