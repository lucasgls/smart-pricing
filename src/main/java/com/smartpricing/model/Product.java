package com.smartpricing.model;

import jakarta.persistence.*;
import lombok.*;
import com.smartpricing.model.enums.Category;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;

    @NonNull
    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Category category;

    @NonNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costPrice;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt;

}