package com.javafood.server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="discount_id")
    DiscountEntity discount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    List<ImageEntity> images;

    @NotEmpty
    String productName;
    @NotEmpty
    String brand;
    @NotEmpty
    @Column(columnDefinition = "TEXT")
    String description;
    BigDecimal price;
    @NotEmpty
    String material;
    @NotEmpty
    String dimensions;
    @NotEmpty
    String tags;
    Boolean isActive;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
}
