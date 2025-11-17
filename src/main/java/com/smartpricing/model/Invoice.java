package com.smartpricing.model;

import com.smartpricing.model.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString(exclude = "items")
@EqualsAndHashCode(of = "number")
public class Invoice {

    @Id
    @UuidGenerator
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, length = 100, unique = true)
    private String number;

    @Column(nullable = false, length = 200)
    private String supplier;

    @Column(nullable = false, updatable = false)
    private LocalDateTime issueDate;

    @Column(nullable = false, precision = 10, scale = 2)
    @Builder.Default
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private InvoiceStatus status = InvoiceStatus.PENDENTE;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<InvoiceItem> items = new ArrayList<>();

    public void addItem(InvoiceItem item) {
        items.add(item);
        item.setInvoice(this);
        item.calculateTotalPrice();
        recalculateTotalAmount();
    }

    public void removeItem(InvoiceItem item) {
        items.remove(item);
        item.setInvoice(null);
        recalculateTotalAmount();
    }

    private void recalculateTotalAmount() {
        this.totalAmount = items.stream()
                .map(InvoiceItem::getTotalPrice)
                .filter(price -> price != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}