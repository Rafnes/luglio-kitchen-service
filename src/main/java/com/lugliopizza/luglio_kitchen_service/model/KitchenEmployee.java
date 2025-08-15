package com.lugliopizza.luglio_kitchen_service.model;

import com.lugliopizza.luglio_kitchen_service.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "kitchen_employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KitchenEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Setter
    private String username;

    @Column(nullable = false)
    private  String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public KitchenEmployee(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = Role.valueOf(role);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        KitchenEmployee user = (KitchenEmployee) obj;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }
}
