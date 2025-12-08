package com.backend.demo.entity;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "product_variants",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_variant_sku",
                        columnNames = "sku"
                )
        }
)
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variant_id")
    private Long variantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(name = "size",nullable = false,length = 20)
    private String size;

    @Column(name = "colour", nullable = false, length = 50)
    private String colour;

    @Column(name = "stock", nullable = false)
    private Integer stock = 0;

    @Column(name = "sku", length = 100)
    private String sku;

    @Column(name = "additional_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal additionalPrice = BigDecimal.ZERO;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();



}
