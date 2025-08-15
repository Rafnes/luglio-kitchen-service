package com.lugliopizza.luglio_kitchen_service.service;

import com.lugliopizza.luglio_kitchen_service.enums.Role;
import com.lugliopizza.luglio_kitchen_service.model.KitchenEmployee;
import com.lugliopizza.luglio_kitchen_service.repository.KitchenEmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KitchenEmployeeService {
    private final KitchenEmployeeRepository kitchenEmployeeRepository;
    private final PasswordEncoder encoder;

    public KitchenEmployeeService(KitchenEmployeeRepository kitchenEmployeeRepository, PasswordEncoder encoder) {
        this.kitchenEmployeeRepository = kitchenEmployeeRepository;
        this.encoder = encoder;
    }

    public void saveEmployee (KitchenEmployee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        kitchenEmployeeRepository.save(employee);
    }
}
