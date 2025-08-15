package com.lugliopizza.luglio_kitchen_service.controller;

import com.lugliopizza.luglio_kitchen_service.service.KitchenEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {
    private final KitchenEmployeeService kitchenEmployeeService;

    public KitchenController(KitchenEmployeeService kitchenEmployeeService) {
        this.kitchenEmployeeService = kitchenEmployeeService;
    }

    @GetMapping("/orders")
    public String getOrders() {
        return "Пока заказов нет";
    }

}
