package com.famzzie.inventory.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Inventory")
@Table(name = "inventory")
public class Inventory {

    @Id
    @SequenceGenerator(name = "inventory_id_sequence", sequenceName = "inventory_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "inventory_id_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", updatable = false, nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(name = "amount", nullable = false, columnDefinition = "NUMERIC(30,2) DEFAULT 0.00")
    private BigDecimal amount;

    @Column(name = "quantity", nullable = false, columnDefinition = "BIGINT")
    private Long quantity;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()")
    private LocalDateTime createdAt;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()")
    private LocalDateTime updatedAt;
}
