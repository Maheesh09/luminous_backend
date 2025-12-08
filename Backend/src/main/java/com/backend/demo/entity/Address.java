package com.backend.demo.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "address_line1",nullable = false,length = 255)
    private String addressLine1;

    @Column(name = "address_line2",length = 255)
    private String addressLine2;

    @Column(name = "city",nullable = false,length = 100)
    private String city;

    @Column(name = "district",nullable = false,length = 100)
    private String district;

    @Column(name = "postal_code",length = 20)
    private String postalCode;

    @Column(name = "is_default",nullable = false)
    private boolean isDefault = false;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
