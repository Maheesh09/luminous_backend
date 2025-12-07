package com.backend.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class User {

    public enum Role{
        CUSTOMER, ADMIN, STAFF
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone",length = 20)
    private String phone;

    @Column(name = "password_hash",nullable = false,length = 255)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",length = 20)
    private Role role = Role.CUSTOMER;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

}
